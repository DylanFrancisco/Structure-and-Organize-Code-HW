package com.comp301.a08shopping;

import com.comp301.a08shopping.events.BackInStockEvent;
import com.comp301.a08shopping.events.OutOfStockEvent;
import com.comp301.a08shopping.events.PurchaseEvent;
import com.comp301.a08shopping.events.SaleEndEvent;
import com.comp301.a08shopping.events.SaleStartEvent;
import com.comp301.a08shopping.events.StoreEvent;
import com.comp301.a08shopping.exceptions.OutOfStockException;
import com.comp301.a08shopping.exceptions.ProductNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StoreImpl implements Store {

  private final String name;
  private final List<StoreObserver> observers = new ArrayList<>();
  private final List<Product> products = new ArrayList<>();

  public StoreImpl(String name) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void addObserver(StoreObserver observer) {
    if (observer == null) {
      throw new IllegalArgumentException();
    }
    if (observers.contains(observer)) {
    } else {
      observers.add(observer);
    }
  }

  @Override
  public void removeObserver(StoreObserver observer) {
    if (observer == null) {
      throw new IllegalArgumentException();
    }
    observers.remove(observer);
  }

  @Override
  public List<Product> getProducts() {
    ArrayList copyList = new ArrayList<>();
    for (Product i : products) {
      copyList.add(i);
    }
    return copyList;
  }

  @Override
  public Product createProduct(String name, double basePrice, int inventory) {
    if (name == null || basePrice <= 0.0 || inventory < 0) {
      throw new IllegalArgumentException();
    }
    Product product = new ProductImpl(name, basePrice, inventory);
    products.add(product);
    return product;
  }

  @Override
  public ReceiptItem purchaseProduct(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    if (products.contains(product)) {
      ProductImpl productToBuy = (ProductImpl) products.get(products.indexOf(product));
      try {
        double productToBuyPrice = productToBuy.buy();
        notify(new PurchaseEvent(productToBuy, this));
        if (productToBuy.outOfStock()) {
          notify(new OutOfStockEvent(productToBuy, this));
        }
        return new ReceiptItemImpl(productToBuy.getName(), productToBuyPrice, getName());
      } catch (OutOfStockException e) {
        notify(new OutOfStockEvent(productToBuy, this));
        throw new OutOfStockException();
      }
    } else {
      throw new ProductNotFoundException();
    }
  }

  @Override
  public void restockProduct(Product product, int numItems) {
    if (product == null || numItems < 0) {
      throw new IllegalArgumentException();
    }
    if (!products.contains(product)) {
      throw new ProductNotFoundException();
    } else {
      ProductImpl productToRestock = (ProductImpl) products.get(products.indexOf(product));
      if (productToRestock.outOfStock() && numItems > 0) {
        notify(new BackInStockEvent(productToRestock, this));
      }
      productToRestock.restock(numItems);
    }
  }

  @Override
  public void startSale(Product product, double percentOff) {
    if (product == null || percentOff <= 0 || percentOff >= 1.0) {
      throw new IllegalArgumentException();
    }
    if (!products.contains(product)) {
      throw new ProductNotFoundException();
    } else {
      ProductImpl productOnSale = (ProductImpl) products.get(products.indexOf(product));
      productOnSale.sale(percentOff);
      notify(new SaleStartEvent(productOnSale, this));
    }
  }

  @Override
  public void endSale(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    if (!products.contains(product)) {
      throw new ProductNotFoundException();
    } else {
      ProductImpl productOnSale = (ProductImpl) products.get(products.indexOf(product));
      productOnSale.saleEnd();
      notify(new SaleEndEvent(productOnSale, this));
    }
  }

  @Override
  public int getProductInventory(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    if (!products.contains(product)) {
      throw new ProductNotFoundException();
    } else {
      ProductImpl currentProduct = (ProductImpl) products.get(products.indexOf(product));
      return currentProduct.getQuantity();
    }
  }

  @Override
  public boolean getIsInStock(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    if (!products.contains(product)) {
      throw new ProductNotFoundException();
    } else {
      ProductImpl currentProduct = (ProductImpl) products.get(products.indexOf(product));
      return !currentProduct.outOfStock();
    }
  }

  @Override
  public double getSalePrice(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    if (!products.contains(product)) {
      throw new ProductNotFoundException();
    } else {
      ProductImpl currentProduct = (ProductImpl) products.get(products.indexOf(product));
      return currentProduct.getSalePrice();
    }
  }

  @Override
  public boolean getIsOnSale(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    if (!products.contains(product)) {
      throw new ProductNotFoundException();
    } else {
      ProductImpl currentProduct = (ProductImpl) products.get(products.indexOf(product));
      return currentProduct.getSalePrice() < currentProduct.getBasePrice();
    }
  }

  private void notify(StoreEvent event) {
    for (StoreObserver o : observers) {
      o.update(event);
    }
  }
}

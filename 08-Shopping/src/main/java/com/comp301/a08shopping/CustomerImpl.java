package com.comp301.a08shopping;

import com.comp301.a08shopping.events.BackInStockEvent;
import com.comp301.a08shopping.events.OutOfStockEvent;
import com.comp301.a08shopping.events.PurchaseEvent;
import com.comp301.a08shopping.events.SaleEndEvent;
import com.comp301.a08shopping.events.SaleStartEvent;
import com.comp301.a08shopping.events.StoreEvent;
import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements Customer {

  private final String name;
  private final List<ReceiptItem> receipts = new ArrayList<>();
  private double budget;

  public CustomerImpl(String name, double budget) {
    if (name == null || budget < 0) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.budget = budget;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public double getBudget() {
    return budget;
  }

  @Override
  public void purchaseProduct(Product product, Store store) {
    if (product == null || store == null) {
      throw new IllegalArgumentException();
    }
    double priceOfProduct = store.getSalePrice(product);
    if (priceOfProduct > budget) {
      throw new IllegalStateException();
    } else {
      receipts.add(store.purchaseProduct(product));
      budget = budget - priceOfProduct;
    }
  }

  @Override
  public List<ReceiptItem> getPurchaseHistory() {
    List<ReceiptItem> copyList = new ArrayList<>();
    for (ReceiptItem i : receipts) {
      copyList.add(i);
    }
    return copyList;
  }

  @Override
  public void update(StoreEvent event) {
    if (event == null) {
      throw new IllegalArgumentException();
    }
    if (event instanceof BackInStockEvent) {
      System.out.println(
          event.getProduct().getName() + " is back in stock at " + event.getStore().getName());
    } else if (event instanceof OutOfStockEvent) {
      System.out.println(
          event.getProduct().getName() + " is now out of stock at " + event.getStore().getName());
    } else if (event instanceof PurchaseEvent) {
      System.out.println(
          "Someone purchased "
              + event.getProduct().getName()
              + " at "
              + event.getStore().getName());
    } else if (event instanceof SaleEndEvent) {
      System.out.println(
          "The sale for "
              + event.getProduct().getName()
              + " at "
              + event.getStore().getName()
              + " has ended");
    } else if (event instanceof SaleStartEvent) {
      System.out.println(
          "New sale for "
              + event.getProduct().getName()
              + " at "
              + event.getStore().getName()
              + "!");
    }
  }
}

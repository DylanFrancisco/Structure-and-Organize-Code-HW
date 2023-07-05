package com.comp301.a08shopping;

import com.comp301.a08shopping.exceptions.OutOfStockException;

public class ProductImpl implements Product {

  private final String name;
  private final double basePrice;
  private double salePrice;
  private int quantity;

  public ProductImpl(String name, double basePrice, int quantity) {
    if (basePrice <= 0.0) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.basePrice = basePrice;
    this.quantity = quantity;
    this.salePrice = basePrice;
  }

  public ProductImpl(String name, double basePrice) {
    if (basePrice <= 0.0) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.basePrice = basePrice;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public double getBasePrice() {
    return basePrice;
  }

  public boolean outOfStock() {
    return quantity <= 0;
  }

  public double buy() {
    if (quantity <= 0) {
      throw new OutOfStockException();
    }
    quantity--;
    return salePrice;
  }

  public void restock(int numItems) {
    if (numItems < 0) {
      throw new IllegalArgumentException();
    }
    quantity += numItems;
  }

  public void saleEnd() {
    this.salePrice = basePrice;
  }

  public void sale(double percentOff) {
    this.salePrice = basePrice * ((1.0 - percentOff));
  }

  public int getQuantity() {
    return quantity;
  }

  public double getSalePrice() {
    return salePrice;
  }
}

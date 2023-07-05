package com.comp301.a01sushi;

public class SuperIngredient implements Ingredient {

  private final String name;
  private final double pricePerOz;
  private final int caloriesPerOz;
  private final boolean isVegetarian;
  private final boolean hasRice;
  private final boolean hasShellfish;

  public SuperIngredient(
      String name,
      double pricePerOz,
      int caloriesPerOz,
      boolean isVegetarian,
      boolean hasRice,
      boolean hasShellfish) {
    this.name = name;
    this.pricePerOz = pricePerOz;
    this.caloriesPerOz = caloriesPerOz;
    this.isVegetarian = isVegetarian;
    this.hasRice = hasRice;
    this.hasShellfish = hasShellfish;
  }

  public String getName() {
    return name;
  }

  @Override
  public double getCaloriesPerDollar() {
    return caloriesPerOz / this.pricePerOz;
  }

  @Override
  public int getCaloriesPerOunce() {

    return this.caloriesPerOz;
  }

  @Override
  public double getPricePerOunce() {
    return this.pricePerOz;
  }

  @Override
  public boolean getIsVegetarian() {
    return this.isVegetarian;
  }

  @Override
  public boolean getIsRice() {
    return this.hasRice;
  }

  @Override
  public boolean getIsShellfish() {
    return this.hasShellfish;
  }

  @Override
  public boolean equals(Ingredient other) {
    return (other.getName().equals(this.getName()));
  }
}



package com.comp301.a01sushi;

public class SuperIngredientPortion implements IngredientPortion {

  private final double amount;
  private final Ingredient ingredient;

  public SuperIngredientPortion(Ingredient ingredient, double amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("Less than 0!");
    }
    this.ingredient = ingredient;
    this.amount = amount;
  }

  @Override
  public Ingredient getIngredient() {
    return this.ingredient;
  }

  @Override
  public double getAmount() {
    return this.amount;
  }

  @Override
  public String getName() {
    return this.ingredient.getName();
  }

  @Override
  public boolean getIsVegetarian() {
    return this.ingredient.getIsVegetarian();
  }

  @Override
  public boolean getIsRice() {
    return this.ingredient.getIsRice();
  }

  @Override
  public boolean getIsShellfish() {
    return this.ingredient.getIsShellfish();
  }

  @Override
  public double getCalories() {
    return this.ingredient.getCaloriesPerOunce() * this.amount;
  }

  @Override
  public double getCost() {
    return (this.amount * this.ingredient.getPricePerOunce());
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    }
    if (!other.getIngredient().equals(this.getIngredient())) {
      throw new IllegalArgumentException("not the same ingredient");
    }
    return null;
  }
}

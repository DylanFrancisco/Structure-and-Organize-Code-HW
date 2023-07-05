package com.comp301.a01sushi;

import java.text.DecimalFormat;

public class Roll implements Sushi {

  private static final DecimalFormat dp = new DecimalFormat("0.00");
  private final String name;
  private final int counter = 0;
  private final IngredientPortion[] roll_ingredients;

  public Roll(String name, IngredientPortion[] roll_ingredients) {
    this.name = name;
    if (roll_ingredients == null) {
      throw new IllegalArgumentException("Ingredient array must exist!");
    }
    for (int i = 0; i < roll_ingredients.length; i++) {
      if (roll_ingredients[i] == null) {
        throw new IllegalArgumentException("Ingredient cannot be null!");
      }
    }
    double seaweedAmount = 0.0;
    for (int i = 0; i < roll_ingredients.length; i++) {
      if (roll_ingredients[i].getIngredient().getName().equals("seaweed")) {
        seaweedAmount += roll_ingredients[i].getAmount();
      }
    }

    if (seaweedAmount < 0.10) {
      double additionalSeaweed = 0.105 - seaweedAmount;
      IngredientPortion[] newIngredients = new IngredientPortion[roll_ingredients.length + 1];
      System.arraycopy(roll_ingredients, 0, newIngredients, 0, roll_ingredients.length);
      newIngredients[roll_ingredients.length] = new SeaweedPortion(additionalSeaweed);
      this.roll_ingredients = newIngredients;
    } else {
      this.roll_ingredients = roll_ingredients.clone();
    }
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public IngredientPortion[] getIngredients() {
    IngredientPortion[] clone_ingredients = this.roll_ingredients.clone();
    return clone_ingredients;
  }

  @Override
  public int getCalories() {
    int total = 0;
    for (int i = 0; i < this.roll_ingredients.length; i++) {
      total += (int) Math.round(this.roll_ingredients[i].getCalories());
    }
    return total;
  }

  @Override
  public double getCost() {
    double total = 0.0;
    for (int i = 0; i < this.roll_ingredients.length; i++) {
      total = total + this.roll_ingredients[i].getCost();
    }
    return Double.parseDouble(dp.format(total));
  }

  @Override
  public boolean getHasRice() {
    for (int i = 0; i < this.roll_ingredients.length; i++) {
      if (this.roll_ingredients[i].getIsRice()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean getHasShellfish() {
    for (int i = 0; i < this.roll_ingredients.length; i++) {
      if (this.roll_ingredients[i].getIsShellfish()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean getIsVegetarian() {
    for (int i = 0; i < this.roll_ingredients.length; i++) {
      if (this.roll_ingredients[i].getIsVegetarian()) {
        return true;
      }
    }
    return false;
  }
}
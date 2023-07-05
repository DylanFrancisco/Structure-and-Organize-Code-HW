package com.comp301.a01sushi;

public class AvocadoPortion extends SuperIngredientPortion {

  public AvocadoPortion(double amount) {
    super(new Avocado(), amount);
    if (amount < 0) {
      throw new IllegalArgumentException("Amount can not be less than 0!");
    }
  }

  public IngredientPortion combine(IngredientPortion other) {
    if (!(other instanceof AvocadoPortion)) {
      throw new IllegalArgumentException("Only can combine with itself");
    }
    return new AvocadoPortion(this.getAmount() + other.getAmount());
  }
}

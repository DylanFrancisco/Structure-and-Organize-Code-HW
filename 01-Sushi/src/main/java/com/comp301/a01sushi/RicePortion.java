package com.comp301.a01sushi;

public class RicePortion extends SuperIngredientPortion {

  public RicePortion(double amount) {
    super(new Rice(), amount);
    if (amount < 0) {
      throw new IllegalArgumentException("Amount can not be less than 0!");
    }
  }

  public IngredientPortion combine(IngredientPortion other) {
    if (!(other instanceof RicePortion)) {
      throw new IllegalArgumentException("Only can combine with itself");
    }
    return new RicePortion(this.getAmount() + other.getAmount());
  }
}

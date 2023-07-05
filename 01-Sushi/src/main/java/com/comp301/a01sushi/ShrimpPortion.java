package com.comp301.a01sushi;

public class ShrimpPortion extends SuperIngredientPortion {

  public ShrimpPortion(double amount) {
    super(new Shrimp(), amount);
    if (amount < 0) {
      throw new IllegalArgumentException("Amount can not be less than 0!");
    }
  }

  public IngredientPortion combine(IngredientPortion other) {
    if (!(other instanceof ShrimpPortion)) {
      throw new IllegalArgumentException("Only can combine with itself");
    }
    return new ShrimpPortion(this.getAmount() + other.getAmount());
  }
}

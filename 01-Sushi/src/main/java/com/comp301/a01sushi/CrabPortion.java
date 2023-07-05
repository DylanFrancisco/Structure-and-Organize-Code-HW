package com.comp301.a01sushi;

public class CrabPortion extends SuperIngredientPortion {

  public CrabPortion(double amount) {
    super(new Crab(), amount);
    if (amount < 0) {
      throw new IllegalArgumentException("Amount can not be less than 0!");
    }
  }

  public IngredientPortion combine(IngredientPortion other) {
    if (!(other instanceof CrabPortion)) {
      throw new IllegalArgumentException("Only can combine with itself");
    }
    return new CrabPortion(this.getAmount() + other.getAmount());
  }
}

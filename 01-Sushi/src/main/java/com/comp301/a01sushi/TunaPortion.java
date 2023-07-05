package com.comp301.a01sushi;

public class TunaPortion extends SuperIngredientPortion {

  public TunaPortion(double amount) {
    super(new Tuna(), amount);
    if (amount < 0) {
      throw new IllegalArgumentException("Amount can not be less than 0!");
    }
  }

  public IngredientPortion combine(IngredientPortion other) {
    if (!(other instanceof TunaPortion)) {
      throw new IllegalArgumentException("Only can combine with itself");
    }
    return new TunaPortion(this.getAmount() + other.getAmount());
  }
}

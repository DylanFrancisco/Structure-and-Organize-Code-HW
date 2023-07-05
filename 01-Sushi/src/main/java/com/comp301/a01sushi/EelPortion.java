package com.comp301.a01sushi;

public class EelPortion extends SuperIngredientPortion {

  public EelPortion(double amount) {
    super(new Eel(), amount);
    if (amount < 0) {
      throw new IllegalArgumentException("Amount can not be less than 0!");
    }
  }

  public IngredientPortion combine(IngredientPortion other) {
    if (!(other instanceof EelPortion)) {
      throw new IllegalArgumentException("Only can combine with itself");
    }
    return new EelPortion(this.getAmount() + other.getAmount());
  }
}

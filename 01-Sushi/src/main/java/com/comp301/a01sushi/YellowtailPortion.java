package com.comp301.a01sushi;

public class YellowtailPortion extends SuperIngredientPortion {

  public YellowtailPortion(double amount) {
    super(new Yellowtail(), amount);
    if (amount < 0) {
      throw new IllegalArgumentException("Amount can not be less than 0!");
    }
  }

  public IngredientPortion combine(IngredientPortion other) {
    if (!(other instanceof YellowtailPortion)) {
      throw new IllegalArgumentException("Only can combine with itself");
    }
    return new YellowtailPortion(this.getAmount() + other.getAmount());
  }
}

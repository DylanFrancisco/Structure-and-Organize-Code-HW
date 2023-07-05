package com.comp301.a01sushi;

public class SeaweedPortion extends SuperIngredientPortion {

  public SeaweedPortion(double amount) {
    super(new Seaweed(), amount);
    if (amount < 0) {
      throw new IllegalArgumentException("Amount can not be less than 0!");
    }
  }

  public IngredientPortion combine(IngredientPortion other) {
    if (!(other instanceof SeaweedPortion)) {
      throw new IllegalArgumentException("Only can combine with itself");
    }
    return new SeaweedPortion(this.getAmount() + other.getAmount());
  }
}

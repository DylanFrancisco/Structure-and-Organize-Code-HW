package com.comp301.a01sushi;

public class Sashimi implements Sushi {
  IngredientPortion protein;

  public Sashimi(SashimiType type) {
    switch (type) {
      case TUNA:
        this.protein = new TunaPortion(0.75);
        break;
      case YELLOWTAIL:
        this.protein = new YellowtailPortion(0.75);
        break;
      case EEL:
        this.protein = new EelPortion(0.75);
        break;
      case CRAB:
        this.protein = new CrabPortion(0.75);
        break;
      case SHRIMP:
        this.protein = new ShrimpPortion(0.75);
        break;
    }
  }

  @Override
  public String getName() {
    return (this.protein.getName() + " sashimi");
  }

  @Override
  public IngredientPortion[] getIngredients() {
    IngredientPortion[] ingredients = new IngredientPortion[1];
    ingredients[0] = this.protein;
    return ingredients;
  }

  @Override
  public int getCalories() {
    return (int) (Math.round(this.protein.getCalories()));
  }

  @Override
  public double getCost() {
    return this.protein.getCost();
  }

  @Override
  public boolean getHasRice() {
    return false;
  }

  @Override
  public boolean getHasShellfish() {
    return this.protein.getIsShellfish();
  }

  @Override
  public boolean getIsVegetarian() {
    return false;
  }

  public enum SashimiType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  }
}

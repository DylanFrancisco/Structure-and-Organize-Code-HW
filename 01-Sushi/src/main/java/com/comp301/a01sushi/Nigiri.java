package com.comp301.a01sushi;

public class Nigiri implements Sushi {

  IngredientPortion protein;
  IngredientPortion ricePortion = new SuperIngredientPortion(new Rice(), 0.5);

  public Nigiri(NigiriType type) {
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
    return (this.protein.getName() + " nigiri");
  }

  @Override
  public IngredientPortion[] getIngredients() {
    IngredientPortion[] ingredients = new IngredientPortion[2];
    ingredients[0] = this.protein;
    ingredients[1] = ricePortion;
    return ingredients;
  }

  @Override
  public int getCalories() {
    return (int)
        ((Math.round(this.protein.getCalories())) + (Math.round(ricePortion.getCalories())));
  }

  @Override
  public double getCost() {
    return (this.protein.getCost() + ricePortion.getCost());
  }

  @Override
  public boolean getHasRice() {
    return true;
  }

  @Override
  public boolean getHasShellfish() {
    return this.protein.getIsShellfish();
  }

  @Override
  public boolean getIsVegetarian() {
    return false;
  }

  public enum NigiriType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  }
}

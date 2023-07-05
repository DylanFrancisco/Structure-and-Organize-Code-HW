package com.comp301.a07pizza;

public class IngredientImpl implements Ingredient {

  private final String name;
  private final boolean veggie;
  private final boolean vegan;

  public IngredientImpl(String name, boolean veggie, boolean vegan) {
    this.name = name;
    this.veggie = veggie;
    this.vegan = vegan;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public boolean isVegetarian() {
    return this.veggie;
  }

  @Override
  public boolean isVegan() {
    return this.vegan;
  }
}

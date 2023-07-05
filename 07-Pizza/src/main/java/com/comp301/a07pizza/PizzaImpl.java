package com.comp301.a07pizza;

public class PizzaImpl implements Pizza {

  private final Size size;
  private final Crust crust;
  private final Sauce sauce;
  private final Cheese cheese;
  private final Topping[] toppings;

  public PizzaImpl(Size size, Crust crust, Sauce sauce, Cheese cheese, Topping[] toppings) {
    this.size = size;
    this.crust = crust;
    this.sauce = sauce;
    this.cheese = cheese;
    this.toppings = toppings.clone();
  }

  @Override
  public boolean isVegetarian() {
    for (Topping t : toppings) {
      if (!t.isVegetarian()) {
        return false;
      }
    }
    return crust.isVegetarian() && sauce.isVegetarian() && cheese.isVegetarian();
  }

  @Override
  public boolean isVegan() {
    for (Topping t : toppings) {
      if (!t.isVegan()) {
        return false;
      }
    }
    return crust.isVegan() && sauce.isVegan() && cheese.isVegan();
  }

  @Override
  public double getPrice() {
    double price;
    switch (size) {
      case SMALL:
        price = 7.00 + (toppings.length * 0.25);
        break;
      case MEDIUM:
        price = 9.00 + (toppings.length * 0.50);
        break;
      case LARGE:
        price = 11.00 + (toppings.length * 0.75);
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + size);
    }
    return price;
  }

  @Override
  public Size getSize() {
    return this.size;
  }

  @Override
  public Ingredient getSauce() {
    return this.sauce;
  }

  @Override
  public Ingredient getCheese() {
    return this.cheese;
  }

  @Override
  public Ingredient getCrust() {
    return this.crust;
  }

  @Override
  public Ingredient[] getToppings() {
    return toppings.clone();
  }

  @Override
  public Ingredient[] getIngredients() {
    Ingredient[] ingredients = new Ingredient[toppings.length + 3];
    ingredients[0] = crust;
    ingredients[1] = sauce;
    ingredients[2] = cheese;
    System.arraycopy(toppings, 0, ingredients, 3, toppings.length);
    return ingredients;
  }
}

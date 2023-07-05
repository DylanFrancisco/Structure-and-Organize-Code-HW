package com.comp301.a01sushi;

public interface Ingredient {

  /**
   * Getter method for the name of the ingredient
   *
   * @return the name of the ingredient as a String
   */
  String getName();

  /**
   * Getter method for the number of calories in one dollar's worth of the ingredient
   *
   * @return the number of calories per dollar's worth of the ingredient
   */
  double getCaloriesPerDollar();

  /**
   * Getter method for the number of calories in one ounce of the ingredient
   *
   * @return the number of calories per ounce of the ingredient
   */
  int getCaloriesPerOunce();

  /**
   * Getter method for the price of one ounce of the ingredient
   *
   * @return the price per ounce of the ingredient, in dollars
   */
  double getPricePerOunce();

  /**
   * Getter method which returns true if the ingredient is vegetarian
   *
   * @return true if the ingredient is vegetarian; false otherwise
   */
  boolean getIsVegetarian();

  /**
   * Getter method which returns true if the ingredient is rice
   *
   * @return true if the ingredient is rice; false otherwise
   */
  boolean getIsRice();

  /**
   * Getter method which returns true if the ingredient is shellfish
   *
   * @return true if the ingredient is shellfish; false otherwise
   */
  boolean getIsShellfish();

  boolean equals(Ingredient other);
}

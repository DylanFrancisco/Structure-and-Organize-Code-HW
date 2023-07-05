package com.comp301.a07pizza;

import com.comp301.a07pizza.Pizza.Size;

public class PizzaFactory {

  public static Pizza makeCheesePizza(Size size) {
    Crust crust = Crust.HAND_TOSSED;
    Sauce sauce = Sauce.TOMATO;
    Cheese cheese = Cheese.BLEND;
    Topping[] toppings = new Topping[0];
    return new PizzaImpl(size, crust, sauce, cheese, toppings);
  }

  public static Pizza makeHawaiianPizza(Size size) {
    Crust crust = Crust.HAND_TOSSED;
    Sauce sauce = Sauce.TOMATO;
    Cheese cheese = Cheese.BLEND;
    Topping[] toppings = {Topping.HAM, Topping.PINEAPPLE};
    return new PizzaImpl(size, crust, sauce, cheese, toppings);
  }

  public static Pizza makeMeatLoversPizza(Size size) {
    Crust crust = Crust.DEEP_DISH;
    Sauce sauce = Sauce.TOMATO;
    Cheese cheese = Cheese.BLEND;
    Topping[] toppings = new Topping[4];
    toppings[0] = Topping.PEPPERONI;
    toppings[1] = Topping.SAUSAGE;
    toppings[2] = Topping.BACON;
    toppings[3] = Topping.GROUND_BEEF;
    return new PizzaImpl(size, crust, sauce, cheese, toppings);
  }

  public static Pizza makeVeggieSupremePizza(Size size) {
    Crust crust = Crust.THIN;
    Sauce sauce = Sauce.TOMATO;
    Cheese cheese = Cheese.BLEND;
    Topping[] toppings = new Topping[4];
    toppings[0] = Topping.SUN_DRIED_TOMATO;
    toppings[1] = Topping.GREEN_PEPPER;
    toppings[2] = Topping.MUSHROOMS;
    toppings[3] = Topping.OLIVES;
    return new PizzaImpl(size, crust, sauce, cheese, toppings);
  }

  public static Pizza makeDailySpecialPizza() {
    Size size = Size.LARGE;
    Crust crust = Crust.THIN;
    Sauce sauce = Sauce.PESTO;
    Cheese cheese = Cheese.MOZZARELLA;
    Topping[] toppings = new Topping[0];
    return new PizzaImpl(size, crust, sauce, cheese, toppings);
  }
}

package src;

import java.util.ArrayList;

public class Order {
    private static int number = 1; //order number
    private static ArrayList<Pizza> pizzas = new ArrayList<>(); //can use List<E> instead of ArrayList<E>

    public Order() {
        this.number += 1;
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void addPizza(ArrayList<Pizza> pizza) {
        pizzas.addAll(pizza);
    }

    public ArrayList<Pizza> getPizzas() {
        return this.pizzas;
    }
}


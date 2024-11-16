package src;

import java.util.ArrayList;

public class Order {
    private  int number; //order number
    private ArrayList<Pizza> pizzas = new ArrayList<>(); //can use List<E> instead of ArrayList<E>

    public Order(int number) {
        this.number = number;
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

    public int getNumber() {
        return this.number;
    }

    public void clearOrder(){
        this.pizzas.clear();
    }

    public void removePizza(Pizza pizza) {
        this.pizzas.remove(pizza);
    }
}


package src;

import java.util.ArrayList;

public class Deluxe extends Pizza {

    private static ArrayList<Topping> toppings = new ArrayList<>();

    Crust crust;

    Deluxe(Crust crust){
        super(toppings, crust);
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.GREENPEPPER);
        toppings.add(Topping.ONION);
        toppings.add(Topping.MUSHROOM);
    }


    @Override
    public double price() {
        switch(super.getSize()){
            case SMALL -> {
                return 16.99;
            }
            case MEDIUM -> {
                return 18.99;
            }
            case LARGE -> {
                return 20.99;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Delux Chicken" + this.toppings.toString() + super.getCrust().toString() + this.price();
    }

    @Override
    public void addToppings(Topping topping) {

    }
}

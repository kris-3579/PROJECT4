package src;

import java.util.ArrayList;

public class Deluxe extends Pizza {


    Crust crust;

    Deluxe(Crust crust){
        super(new ArrayList<Topping>(), crust);
        this.addToppings(Topping.SAUSAGE);
        this.addToppings(Topping.PEPPERONI);
        this.addToppings(Topping.GREENPEPPER);
        this.addToppings(Topping.ONION);
        this.addToppings(Topping.MUSHROOM);
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
        return "Deluxe Chicken " + super.getType() + " " + super.getToppings().toString() + " " + super.getCrust().toString() + " " + this.price();
    }

}

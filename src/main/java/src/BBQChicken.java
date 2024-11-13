package src;

import java.util.ArrayList;

public class BBQChicken extends Pizza {

    private static ArrayList<Topping> toppings = new ArrayList<>();
    Crust crust;

    BBQChicken(Crust crust) {
        super(toppings, crust);
        toppings.add(Topping.BBQCHICKEN);
        toppings.add(Topping.GREENPEPPER);
        toppings.add(Topping.PROVOLONE);
        toppings.add(Topping.CHEDDAR);
    }

    @Override
    public double price() {
        switch(super.getSize()){

            case LARGE -> {
                return 19.99;
            }
            case MEDIUM -> {
                return 16.99;
            }
            case SMALL -> {
                return 14.99;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "BBQ Chicken" + this.toppings.toString() + super.getCrust().toString() + this.price();
    }

    @Override
    public void addToppings(Topping topping) {

    }


}

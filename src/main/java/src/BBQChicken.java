package src;

import java.util.ArrayList;

public class BBQChicken extends Pizza {


    BBQChicken(Crust crust) {
        super(new ArrayList<Topping>(), crust);
        this.addToppings(Topping.BBQCHICKEN);
        this.addToppings(Topping.GREENPEPPER);
        this.addToppings(Topping.PROVOLONE);
        this.addToppings(Topping.CHEDDAR);
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
        return "BBQ Chicken " + super.getType() + " " + super.getToppings().toString() + " " + super.getCrust().toString() + " " + this.price();
    }


}

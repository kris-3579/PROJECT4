package src;

import java.util.ArrayList;

public class Meatzza extends Pizza {



    Meatzza(Crust crust){
        super(new ArrayList<>(), crust);
        this.addToppings(Topping.SAUSAGE);
        this.addToppings(Topping.PEPPERONI);
        this.addToppings(Topping.BEEF);
        this.addToppings(Topping.HAM);


    }
    @Override
    public double price() {
        switch(super.getSize()){
            case SMALL -> {
                return 17.99;
            }

            case MEDIUM -> {
                return 19.99;
            }
            case LARGE -> {
                return 21.99;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Meatzza " + super.getType() + " " + super.getToppings().toString() + " " + super.getCrust().toString() + " " + this.price();
    }


}

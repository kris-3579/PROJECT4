package src;

import java.util.ArrayList;

public class Meatzza extends Pizza {
    private static ArrayList<Topping> toppings = new ArrayList<Topping>();

    Crust crust;


    Meatzza(Crust crust){
        super(toppings, crust);
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.BEEF);
        toppings.add(Topping.HAM);

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
        return "Meatzza" + this.toppings.toString() + super.getCrust().toString() + this.price();
    }

    @Override
    public void addToppings(Topping topping) {

    }
}

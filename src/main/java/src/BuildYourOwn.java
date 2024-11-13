package src;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza {
    private static ArrayList<Topping> toppings = new ArrayList<>();

    Crust crust;

    BuildYourOwn(Crust crust) {
        super(toppings, crust);
    }
    @Override
    public double price() {
        switch(super.getSize()){

            case LARGE -> {
                return 12.99;
            }
            case MEDIUM -> {
                return 10.99;
            }
            case SMALL -> {
                return 8.99;
            }
        }
        return 0;
    }
    public void addToppings(Topping topping){
        toppings.add(topping);
    }

    @Override
    public String toString() {
        return "Build Your Own" + this.toppings.toString() + super.getCrust().toString() + this.price();
    }
}

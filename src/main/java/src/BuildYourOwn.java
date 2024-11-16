package src;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza {


    Crust crust;

    BuildYourOwn(Crust crust) {
        super(new ArrayList<>(), crust);
    }
    @Override
    public double price() {

        double toppingsCost = Math.round(this.getToppings().size() * 1.69 + 100.0) / 100.0;
        switch(super.getSize()){

            case LARGE -> {
                return 12.99 + toppingsCost;
            }
            case MEDIUM -> {
                return 10.99 + toppingsCost;
            }
            case SMALL -> {
                return 8.99 + toppingsCost;
            }
        }
        return 0;
    }


    @Override
    public String toString() {
        return "Build Your Own " + super.getType() + " " + super.getToppings().toString() + " " + super.getCrust().toString() + " " + this.price();
    }
}

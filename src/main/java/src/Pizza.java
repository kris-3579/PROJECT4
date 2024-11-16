package src;

import java.util.ArrayList;

public abstract class Pizza {
    private ArrayList<Topping> toppings; //Topping is a Enum class
    private Crust crust; //Crust is a Enum class
    private Size size;
    private String type;//Size is a Enum class



    public Pizza(ArrayList<Topping> toppings, Crust crust) {
        this.toppings = toppings;
        this.crust = crust;
        this.size = null;
    }

    public void setSize(Size s){
        this.size = s;
    }

    public void setType(String type){
        this.type = type;
    }


    public String getType(){
        return this.type;
    }

    public Size getSize(){
        return this.size;
    }

    public abstract double price();

    public Crust getCrust(){
        return this.crust;
    }
    public abstract String toString();

    public void addToppings(Topping topping) {
        this.toppings.add(topping);
    }

    public ArrayList<Topping> getToppings(){
        return this.toppings;
    }


}



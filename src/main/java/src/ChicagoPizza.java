package src;

public class ChicagoPizza implements PizzaFactory {

    @Override
    public Pizza createDeluxe() {
        Pizza pizza =  new Deluxe(Crust.DEEPDISH);
        pizza.setType("Chicago");
        return pizza;
    }

    @Override
    public Pizza createMeatzza() {
        Pizza pizza = new Meatzza(Crust.STUFFED);
        pizza.setType("Chicago");
        return pizza;
    }

    @Override
    public Pizza createBBQChicken() {
        Pizza pizza = new BBQChicken(Crust.PAN);
        pizza.setType("Chicago");
        return pizza;

    }

    @Override
    public Pizza createBuildYourOwn() {
        Pizza pizza = new BuildYourOwn(Crust.PAN);
        pizza.setType("Chicago");
        return pizza;
    }
}

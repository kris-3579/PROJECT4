package src;

public class NYPizza implements PizzaFactory {
    @Override
    public Pizza createDeluxe() {
        Pizza pizza = new Meatzza(Crust.BROOKLYN);
        pizza.setType("New York Style");
        return pizza;
    }

    @Override
    public Pizza createMeatzza() {
        Pizza pizza = new Meatzza(Crust.HANDTOSSED);
        pizza.setType("New York Style");
        return pizza;

    }

    @Override
    public Pizza createBBQChicken() {
        Pizza pizza = new BBQChicken(Crust.THIN);
        pizza.setType("New York Style");
        return pizza;

    }

    @Override
    public Pizza createBuildYourOwn() {
        Pizza pizza = new BuildYourOwn(Crust.THIN);
        pizza.setType("New York Style");
        return pizza;
    }
}

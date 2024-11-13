package src;

public class ChicagoPizza implements PizzaFactory {

    @Override
    public Pizza createDeluxe() {
        return new Deluxe(Crust.DEEPDISH);
    }

    @Override
    public Pizza createMeatzza() {
        return new Meatzza(Crust.STUFFED);
    }

    @Override
    public Pizza createBBQChicken() {
        return new BBQChicken(Crust.PAN);
    }

    @Override
    public Pizza createBuildYourOwn() {
        return new BuildYourOwn(Crust.PAN);
    }
}

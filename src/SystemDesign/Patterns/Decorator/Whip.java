package SystemDesign.Patterns.Decorator;

public class Whip implements Addon{

    private Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int getCost() {
        return 50 + beverage.getCost();
    }

    @Override
    public void getDescription() {
        beverage.getDescription();
        System.out.println("Addon Whip");
    }
}

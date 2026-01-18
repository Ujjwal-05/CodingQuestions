package SystemDesign.Patterns.Decorator;

public class Milk implements Addon{

    private Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int getCost() {
        return 20 + beverage.getCost();
    }

    @Override
    public void getDescription() {
        beverage.getDescription();
        System.out.println("Addon Milk");
    }
}

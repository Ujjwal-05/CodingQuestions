package SystemDesign.Patterns.Decorator;

public class Decaf implements Beverage{
    @Override
    public int getCost() {
        return 100;
    }

    @Override
    public void getDescription() {
        System.out.println("Beverage Decaf");
    }
}

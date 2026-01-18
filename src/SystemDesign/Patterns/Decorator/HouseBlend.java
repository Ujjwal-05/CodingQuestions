package SystemDesign.Patterns.Decorator;

public class HouseBlend implements Beverage{
    @Override
    public int getCost() {
        return 200;
    }

    @Override
    public void getDescription() {
        System.out.println("HouseBlend has been added");
    }
}

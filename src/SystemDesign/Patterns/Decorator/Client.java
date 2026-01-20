package SystemDesign.Patterns.Decorator;

interface Beverage {

    public int getCost();
    public void getDescription();

}

class Decaf implements Beverage{
    @Override
    public int getCost() {
        return 100;
    }

    @Override
    public void getDescription() {
        System.out.println("Beverage Decaf");
    }
}

class HouseBlend implements Beverage{
    @Override
    public int getCost() {
        return 200;
    }

    @Override
    public void getDescription() {
        System.out.println("HouseBlend has been added");
    }
}

interface Addon extends Beverage{
}

class Milk implements Addon{

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

class Whip implements Addon{

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


public class Client {
    public static void main(String[] args) {
        Beverage beverage=new Decaf();
        beverage=new Milk(beverage);
        beverage=new Whip(beverage);
        beverage=new Milk(beverage);

        beverage.getDescription();
        System.out.println("Total Cost:"+ beverage.getCost());
    }
}

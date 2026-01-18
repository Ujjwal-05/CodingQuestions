package SystemDesign.Patterns.Decorator;

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

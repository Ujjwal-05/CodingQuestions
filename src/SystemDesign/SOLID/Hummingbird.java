package SystemDesign.SOLID;

public class Hummingbird extends Bird implements Flyable{

    public Hummingbird(String name, String colour, int weight) {
        super(name, colour, weight);
    }

    @Override
    public void fly() {
        System.out.println("Hummingbird can Fly");
    }
}

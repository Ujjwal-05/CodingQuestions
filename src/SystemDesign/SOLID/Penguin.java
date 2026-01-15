package SystemDesign.SOLID;

public class Penguin extends Bird implements Walkable{
    public Penguin(String name, String colour, int weight) {
        super(name, colour, weight);
    }

    @Override
    public void walk() {
        System.out.println("Penguin Can Walk");
    }
}

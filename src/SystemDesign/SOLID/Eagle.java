package SystemDesign.SOLID;

public class Eagle extends Bird implements Flyable,Walkable{
    public Eagle(String name, String colour, int weight) {
        super(name, colour, weight);
    }

    @Override
    public void fly() {
        System.out.println("Eagle can Fly also");
    }

    @Override
    public void walk() {
        System.out.println("Eagle can Walk also");
    }
}

package SystemDesign.SOLID;


import java.util.ArrayList;
import java.util.List;

public class SOLID {
    public static void main(String[] args) {

        Bird hummingbird = new Hummingbird("Hummingbird","Red",10);
        Bird penguin = new Penguin("Penguin","White",15);
        Bird eagle = new Eagle("Eagle","Brown",20);

        //// Calling Methods:
        hummingbird.eat();
//      hummingbird.fly(); Not Allowed
        ((Flyable)hummingbird).fly();

        Flyable flyable=new Hummingbird("Hummingbird","Red",10);
        flyable.fly();
//      flyable.eat(); Not allowed
        ((Bird)flyable).eat();

        //// To call both the method Either use child class refernce or create new interface:
        Hummingbird hummingbird1=new Hummingbird("Hummingbird","Red",10);
        hummingbird1.eat();
        hummingbird1.fly();

        //// List of Flyables
        List<Flyable> flyables=new ArrayList<>();
        flyables.add((Flyable) hummingbird);

        ////List of Flyable and walkable both;

        List<Bird> birds=new ArrayList<>();
        birds.add(hummingbird);
        birds.add(penguin);
        birds.add(eagle);

        List<Bird> flyandwalkables=new ArrayList<>();

        for (Bird b:birds){
            if(b instanceof Flyable && b instanceof Walkable){
                flyandwalkables.add(b);
            }
        }

        for (Bird b:flyandwalkables){
            System.out.println(b.name);
        }

    }
}

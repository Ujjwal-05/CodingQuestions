package SystemDesign.Patterns.FlyWeight;
//import org.openjdk.jol.info.ClassLayout;

public class Client {
    public static void main(String[] args) {
        BulletType redBulletType = BulletFactory.getBulletType("Red", 10);

        Bullet b1 = new Bullet(redBulletType, 10, 20);
        Bullet b2 = new Bullet(redBulletType, 50, 60);

        b1.show();
        b2.show();

//        System.out.println(ClassLayout.parseInstance(type).toPrintable());
//        System.out.println(ClassLayout.parseInstance(bullet).toPrintable());

        System.out.println("Same BulletType object? " + (redBulletType == BulletFactory.getBulletType("Red", 10)));

    }
}

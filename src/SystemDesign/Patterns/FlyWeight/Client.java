package SystemDesign.Patterns.FlyWeight;
//import org.openjdk.jol.info.ClassLayout;

import java.util.HashMap;
import java.util.Map;

// Flyweight (Shared data)
class BulletType {
    String color;
    int damage;

    BulletType(String color, int damage) {
        this.color = color;
        this.damage = damage;
    }
}

class Bullet {
    // Shared (Intrinsic)
    private final BulletType type;

    // Unique (Extrinsic)
    private int x;
    private int y;

    Bullet(BulletType type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    void show() {
        System.out.println("Bullet => color: " + type.color +
                ", damage: " + type.damage +
                ", position: (" + x + "," + y + ")");
    }
}

// Flyweight Factory (Reuse BulletType objects)
 class BulletFactory {
    private static final Map<String, BulletType> cache = new HashMap<>();

    static BulletType getBulletType(String color, int damage) {
        String key = color + "-" + damage;

        if (!cache.containsKey(key)) {
            cache.put(key, new BulletType(color, damage));
        }
        return cache.get(key);
    }
}

public class Client {
    public static void main(String[] args) {
        BulletType redBulletType = BulletFactory.getBulletType("Red", 10);

        Bullet b1 = new Bullet(redBulletType, 10, 20);
        Bullet b2 = new Bullet(redBulletType, 50, 60);

        b1.show();
        b2.show();

    }
}







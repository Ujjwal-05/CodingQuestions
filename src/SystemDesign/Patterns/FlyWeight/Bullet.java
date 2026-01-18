package SystemDesign.Patterns.FlyWeight;

// Bullet object (Has unique + shared data)
public class Bullet {
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

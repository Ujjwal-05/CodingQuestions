package SystemDesign.Patterns.FlyWeight;
// Flyweight (Shared data)
public class BulletType {
    String color;
    int damage;

    BulletType(String color, int damage) {
        this.color = color;
        this.damage = damage;
    }
}

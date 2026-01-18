package SystemDesign.Patterns.FlyWeight;

import java.util.HashMap;
import java.util.Map;

// Flyweight Factory (Reuse BulletType objects)
public class BulletFactory {
    private static final Map<String, BulletType> cache = new HashMap<>();

    static BulletType getBulletType(String color, int damage) {
        String key = color + "-" + damage;

        if (!cache.containsKey(key)) {
            cache.put(key, new BulletType(color, damage));
        }
        return cache.get(key);
    }
}

package SystemDesign.Patterns.Prototype;

class Student {
    private String name;
    private int age;

    Student(String name, int age){
        this.name=name;
        this.age=age;
    }
    Student(Student student){
        this.name= student.name;
        this.age= student.age;
    }

    public Student clone(){
        return new Student(this);
    }

}

class IntelligentStudent extends Student{
    int id;

    IntelligentStudent(IntelligentStudent intelligentStudent){
        super(intelligentStudent);
        this.id=intelligentStudent.id;
    }

    @Override
    public IntelligentStudent clone(){
        return new IntelligentStudent(this);
    }

}

public class Prototype {
    public static void main(String[] args) {

    Student student=new Student("Ujjwal",25);
    Student clonedStudent=student.clone();

    }
}


/*

In a game, we want to spawn many zombies quickly.All zombies have common properties like:
type = Zombie
baseHealth = 100
speed = 5
weapon = "Bite"

But every spawned zombie will have different:
position (x, y)
maybe different health based on level
Instead of creating a new zombie again and again with new Zombie(...), we keep one prototype zombie, and clone it whenever we need a new zombie

========================================================================================
PROTOTYPE PATTERN - GAME EXAMPLE (Enemy Spawning)
========================================================================================
Problem:
- In games we need to create many similar objects (Enemies, Bullets, NPCs)
- Creating each object from scratch is costly and repetitive

Solution:
- Create one base object (Prototype)
- Clone it whenever a new enemy is required
- Modify only required fields (like position)
========================================================================================

interface GameObject {
    GameObject cloneObject();
}


// Concrete Prototype: Zombie Enemy
class Zombie implements GameObject {

    private String type;
    private int health;
    private int speed;

    // Changing values for each spawned zombie
    private int x;
    private int y;

    public Zombie(String type, int health, int speed, int x, int y) {
        this.type = type;
        this.health = health;
        this.speed = speed;
        this.x = x;
        this.y = y;
    }

    // Copy Constructor (Cloning)
    public Zombie(Zombie zombie) {
        this.type = zombie.type;
        this.health = zombie.health;
        this.speed = zombie.speed;
        this.x = zombie.x;
        this.y = zombie.y;
    }

    @Override
    public Zombie cloneObject() {
        return new Zombie(this);
    }

    // Set position for each clone
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void showZombie() {
        System.out.println("Zombie{" +
                "type='" + type + '\'' +
                ", health=" + health +
                ", speed=" + speed +
                ", position=(" + x + "," + y + ")" +
                '}');
    }
}


// Game class (Client)
public class PrototypeGameExample {
    public static void main(String[] args) {

        // Base Zombie Prototype (common properties)
        Zombie zombiePrototype = new Zombie("Zombie", 100, 5, 0, 0);

        // Spawn Zombie 1 (clone prototype + change position)
        Zombie z1 = zombiePrototype.cloneObject();
        z1.setPosition(10, 20);
        z1.showZombie();

        // Spawn Zombie 2
        Zombie z2 = zombiePrototype.cloneObject();
        z2.setPosition(50, 80);
        z2.showZombie();

        // Spawn Zombie 3
        Zombie z3 = zombiePrototype.cloneObject();
        z3.setPosition(100, 150);
        z3.showZombie();
    }
}
*/

/*
package SystemDesign.Patterns;

import java.util.HashMap;
import java.util.Map;


========================================================================================
PROTOTYPE DESIGN PATTERN - GAME EXAMPLE (WITH PROTOTYPE REGISTRY)
========================================================================================
Real Life Scenario (Games):
- In games we need to spawn many objects quickly:
  ✅ Enemies (Zombie, Soldier, Boss)
  ✅ Bullets
  ✅ NPCs
  ✅ Trees / rocks

Problem:
- Creating objects again and again using "new" is repetitive and slow
- Client needs to know all details of object creation (tight coupling)

Solution:
- Create 1 base object of each type (Prototype)
- Store them in a Registry (Map)
- Whenever required -> clone from registry and modify only required fields (position, level etc.)

Benefits:
✅ Faster object creation (spawning)
✅ Reuse base configuration
✅ Easy to add new enemy type (OCP friendly)
========================================================================================

interface Enemy<T> {
    T cloneEnemy();
    void setPosition(int x, int y);
    void show();
}

class Zombie implements Enemy {

    private String type;
    private int health;
    private int speed;

    private int x;
    private int y;

    public Zombie(String type, int health, int speed) {
        this.type = type;
        this.health = health;
        this.speed = speed;
    }

    // Copy Constructor (cloning)
    public Zombie(Zombie zombie) {
        this.type = zombie.type;
        this.health = zombie.health;
        this.speed = zombie.speed;
        this.x = zombie.x;
        this.y = zombie.y;
    }

    @Override
    public Enemy cloneEnemy() {
        return new Zombie(this);
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void show() {
        System.out.println("Zombie{" +
                "type='" + type + '\'' +
                ", health=" + health +
                ", speed=" + speed +
                ", position=(" + x + "," + y + ")" +
                '}');
    }
}


class Soldier implements Enemy {

    private String type;
    private int health;
    private int bullets;

    private int x;
    private int y;

    public Soldier(String type, int health, int bullets) {
        this.type = type;
        this.health = health;
        this.bullets = bullets;
    }

    // Copy Constructor
    public Soldier(Soldier soldier) {
        this.type = soldier.type;
        this.health = soldier.health;
        this.bullets = soldier.bullets;
        this.x = soldier.x;
        this.y = soldier.y;
    }

    @Override
    public Enemy cloneEnemy() {
        return new Soldier(this);
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void show() {
        System.out.println("Soldier{" +
                "type='" + type + '\'' +
                ", health=" + health +
                ", bullets=" + bullets +
                ", position=(" + x + "," + y + ")" +
                '}');
    }
}

class Boss implements Enemy {

    private String type;
    private int health;
    private int power;

    private int x;
    private int y;

    public Boss(String type, int health, int power) {
        this.type = type;
        this.health = health;
        this.power = power;
    }

    // Copy Constructor
    public Boss(Boss boss) {
        this.type = boss.type;
        this.health = boss.health;
        this.power = boss.power;
        this.x = boss.x;
        this.y = boss.y;
    }

    @Override
    public Enemy cloneEnemy() {
        return new Boss(this);
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void show() {
        System.out.println("Boss{" +
                "type='" + type + '\'' +
                ", health=" + health +
                ", power=" + power +
                ", position=(" + x + "," + y + ")" +
                '}');
    }
}

========================================================================================
PROTOTYPE REGISTRY
========================================================================================
- Stores base prototypes for each enemy type
- Client will not create objects using new each time
========================================================================================

class EnemyRegistry {

    private final Map<String, Enemy> enemyMap = new HashMap<>();

    public void addPrototype(String key, Enemy enemy) {
        enemyMap.put(key, enemy);
    }

    public Enemy getClone(String key) {
        Enemy prototype = enemyMap.get(key);
        if (prototype == null) {
            throw new IllegalArgumentException("No prototype found for key: " + key);
        }
        return prototype.cloneEnemy();
    }
}

public class PrototypeGameWithRegistry {
    public static void main(String[] args) {

        // Step 1: Create Registry
        EnemyRegistry registry = new EnemyRegistry();

        // Step 2: Create base prototypes (common configuration)
        registry.addPrototype("zombie", new Zombie("Zombie", 100, 5));
        registry.addPrototype("soldier", new Soldier("Soldier", 200, 30));
        registry.addPrototype("boss", new Boss("Boss", 1000, 500));

        // Step 3: Spawn enemies by cloning prototypes

        Enemy e1 = registry.getClone("zombie");
        e1.setPosition(10, 20);
        e1.show();

        Enemy e2 = registry.getClone("zombie");
        e2.setPosition(40, 60);
        e2.show();

        Enemy e3 = registry.getClone("soldier");
        e3.setPosition(100, 150);
        e3.show();

        Enemy e4 = registry.getClone("boss");
        e4.setPosition(500, 700);
        e4.show();

        OUTPUT EXAMPLE:
        Zombie{type='Zombie', health=100, speed=5, position=(10,20)}
        Zombie{type='Zombie', health=100, speed=5, position=(40,60)}
        Soldier{type='Soldier', health=200, bullets=30, position=(100,150)}
        Boss{type='Boss', health=1000, power=500, position=(500,700)}


    }
}

✔ Yes, to avoid repeating variables → use Abstract Base Class + interface
✔ If you don’t use it → it’s interface-based design, used when objects don’t share common state

*/
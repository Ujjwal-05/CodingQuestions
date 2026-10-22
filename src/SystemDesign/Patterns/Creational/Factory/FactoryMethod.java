package SystemDesign.Patterns.Creational.Factory;

abstract class VehicleFactory {
    abstract Vehicle createVehicle(); // Factory Method
}

class CarFactory extends VehicleFactory {
    @Override
    Vehicle createVehicle() {
        return new Car();
    }
}

class BikeFactory extends VehicleFactory {
    @Override
    Vehicle createVehicle() {
        return new Bike();
    }
}

interface Vehicle {
    void drive();
}

class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a Car...");
    }
}

class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a Bike...");
    }
}

public class FactoryMethod {
    public static void main(String[] args) {

        VehicleFactory factory1 = new CarFactory();
        Vehicle v1 = factory1.createVehicle(); // Factory Method call
        v1.drive();

        VehicleFactory factory2 = new BikeFactory();
        Vehicle v2 = factory2.createVehicle(); // Factory Method call
        v2.drive();
    }
}
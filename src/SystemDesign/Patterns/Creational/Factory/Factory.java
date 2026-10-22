package SystemDesign.Patterns.Creational.Factory;

//interface Vehicle {
//    void drive();
//}
//
//class Car implements Vehicle {
//    public void drive() {
//        System.out.println("Driving Car");
//    }
//}
//
//class Bike implements Vehicle {
//    public void drive() {
//        System.out.println("Driving Bike");
//    }
//}
//
//
//// Factory Class
//class VehicleFactory {
//
//    public static Vehicle getVehicle(String type) {
//
//
//        if (type.equalsIgnoreCase("car")) {
//            return new Car();
//        } else if (type.equalsIgnoreCase("bike")) {
//            return new Bike();
//        }
//
//
//        throw new IllegalArgumentException("Invalid vehicle type");
//    }
//}
//
//
//public class Factory {
//    public static void main(String[] args) {
//        Vehicle v1 = VehicleFactory.getVehicle("car");
//        v1.drive();
//
//
//        Vehicle v2 = VehicleFactory.getVehicle("bike");
//        v2.drive();
//    }
//}

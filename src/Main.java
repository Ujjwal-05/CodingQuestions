import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String tablet, String electronics, double v) {
        this.name=tablet;
        this.category=electronics;
        this.price=v;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
// constructor, getters, setters, toString
}


class Employee{
    int id;
    String name;
    int age;
    Double Salary;
    int department;


    public Employee(int id, String name, int age, Double salary, int department) {
        this.id = id;
        this.name = name;
        this.age = age;
        Salary = salary;
        this.department=department;


    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Double getSalary() {
        return Salary;
    }

    public int getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", Salary=" + Salary +
                ", department=" + department +
                '}';
    }
}

class Human{
     public synchronized void show(){

    }
}

public class Main {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Laptop", "Electronics", 1200),
                new Product("Phone", "Electronics", 800),
                new Product("TV", "Electronics", 1500),
                new Product("Headphones", "Electronics", 200),
                new Product("Shirt", "Clothing", 50),
                new Product("Jacket", "Clothing", 150),
                new Product("Jeans", "Clothing", 100),
                new Product("Shoes", "Clothing", 200),
                new Product("Watch", "Accessories", 500)
        );





        List<Employee> employees = Arrays.asList(
                new Employee(1, "A", 10, 10000.0, 100),
                new Employee(2, "B", 10, 20000.0, 100),
                new Employee(3, "C", 20, 30000.0, 200),
                new Employee(4, "D", 20, 40000.0, 300),
                new Employee(5, "E", 30, 50000.0, 300));

        List<String> fullNames = List.of("John Doe", "Jane Smith", "Alice Johnson", "Bob Brown", "Jane Smith", "alice   johnson");
        List<List<Integer>> listOfLists = List.of(List.of(1, 2, 3), List.of(4, 5), List.of(6, 7, 8, 9));


        List<String> sentences = List.of("Java is fun", "Streams are powerful", "Java Streams are awesome", "Java is good");
        List<Integer> integers = List.of(1, 2, 3, 5, 4, 5);
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        List<Integer> list2 = List.of(3, 4, 5, 6, 7);
        List<Integer> list=new ArrayList<>();

        int[] array={1,1,2,2,3,4,5,6,7,8,9,10,10};
        List<String> names = List.of("Rahul", "Amit", "Sureshhhh", "Ankit", "Naman", "Amit");
        String string = "daadbccdb@#123DC";

        Arrays.stream(array).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(entry->entry.getValue()>1)
                .map(Map.Entry::getKey).toList();

        names.stream().flatMap(str -> str.chars().mapToObj(c -> (char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(entry -> entry.getValue()))
                .map(entry -> entry.getKey());


        String reduce = string.chars().mapToObj(c -> String.valueOf((char) c)).reduce("", (a, b) -> b + a);

        System.out.println(reduce);


    }

}























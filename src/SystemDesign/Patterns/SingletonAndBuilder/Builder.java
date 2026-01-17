package SystemDesign.Patterns.SingletonAndBuilder;

class Employee {

    private final String name;
    private final int age;
    private final double salary;

    // Private constructor so object can only be created via Builder
    private Employee(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.salary = builder.salary;
    }

    // Getters (No setters -> Immutable object)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    // Builder class
    public static class Builder {

        private String name;
        private int age;
        private double salary;

        public Builder setName(String name) {
            this.name = name;
            return this; // chaining
        }

        public Builder setAge(int age) {
            this.age = age;
            return this; // chaining
        }

        public Builder setSalary(double salary) {
            this.salary = salary;
            return this; // chaining
        }

        // Validation happens here
        public Employee build() {

            if (age <= 18) {
                throw new IllegalArgumentException("Age must be greater than 18");
            }

            if (salary <= 10000) {
                throw new IllegalArgumentException("Salary must be greater than 10000");
            }

            return new Employee(this);
        }
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}


public class Builder {
    public static void main(String[] args) {

        // ✅ Valid object creation
        Employee emp1 = new Employee.Builder()
                .setName("Ujjwal")
                .setAge(25)
                .setSalary(50000)
                .build();

        System.out.println(emp1);

        // ❌ Invalid age (throws exception)
        Employee emp2 = new Employee.Builder()
                .setName("Test")
                .setAge(17)
                .setSalary(20000)
                .build();
    }
}


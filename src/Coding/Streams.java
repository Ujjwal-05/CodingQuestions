package Coding;

import java.util.*;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

public class Streams {
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


        List<Employee> employees =List.of(
                new Employee(1,"Aakash",10,10000.0,100),
                new Employee(2,"Aiswajit",10,20000.0,100),
                new Employee(3,"Chetan",20,30000.0,200),
                new Employee(4,"Deepak",20,40000.0,300),
                new Employee(5,"Eknath",30,50000.0,300),
                new Employee(6,"Eshan",35,60000.0,400)
        );

//        List<List<Integer>> numbers = List.of(
//                List.of(1, 2),
//                List.of(3, 4),
//                List.of(5, 6)
//        );

        int[] arr={1,2,3,4,5,-1};
        List<Integer> list= List.of(1,1,2,3,4,5,-1);
        List<String> names = List.of("Rahul", "Amit", "Sureshhhh", "Ankit","Naman","Amit","listen","silent","cat","act");
        String str="AAbbcccddd42s1d1s21d";
        List<String> sentences = List.of("Java is fun", "Streams are powerful", "Java Streams are awesome","Java is good");
        List<String> fullNames = List.of("John Doe", "Jane Smith", "Alice Johnson", "Bob Brown", "Jane Smith", "alice   johnson");
        List<List<Integer>> listOfLists = List.of(List.of(1, 2, 3),List.of(4, 5),List.of(6, 7, 8, 9));
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        List<Integer> list2 = List.of(3, 4, 5, 6, 7);

////Here are the most common ways to create a Stream from different data sources in Java.

//        String[] stringArray= {"John","mike","bob"};              // From Array
//        Stream<String>  streamfromstringarray =Arrays.stream(stringArray);

//        Integer[] integerArray={1,2,3,4,5};                       // From Array
//        Stream<Integer> stream = Arrays.stream(integerArray);

//        int[] intArray={1,2,3,4,5};                               // From Array
//        Stream<Integer> boxed = Arrays.stream(intArray).boxed();

//        List<String> names = List.of("John", "Alice", "Bob");      // From List
//        Stream<String> stream = names.stream();

//        String str = "Hello";                                       // From String
//        Stream<Character> stream = str.chars().mapToObj(c -> (char) c);

////Generate a stream of 20 different elements, skip the first 5, and print the remaining elements in reverse order (without sorting).

        List<Integer> list3 = Stream.iterate(0, i -> i + 1).limit(20).skip(5).toList();

////Find the maximum and minimum number from a list or from array using streams.

        OptionalInt max = Arrays.stream(arr).max();
        OptionalInt min = Arrays.stream(arr).min();

        Optional<Integer> max1 = list.stream().max(Comparator.comparingInt(e -> e));
        Optional<Integer> min1 = list.stream().min(Comparator.comparingInt(e -> e));
        Integer listIsEmpty = list.stream().max(Integer::compareTo).orElseThrow(() -> new NoSuchElementException("List is empty"));
        //list.stream().max(Comparator.naturalOrder()).ifPresentOrElse(System.out::println, ()-> System.out.println("List is empty"));

////Calculate the sum of squares of distinct numbers using reduce().

        Integer reduce = Arrays.stream(arr).distinct().map(n -> n * n).reduce(0, (a, b) -> a + b);

////Check if all numbers are even / any number is negative / none is zero using match methods.

        boolean b0 = Arrays.stream(arr).allMatch(x -> x % 2 == 0);
        boolean b1 = Arrays.stream(arr).anyMatch(x -> x < 0);
        boolean b2 = Arrays.stream(arr).noneMatch(x -> x != 0);

////Find all elements greater than the average value.

        double asDouble = list.stream().mapToInt(Integer::intValue).average().getAsDouble();
        List<Integer> list5 = list.stream().filter(x -> x > asDouble).toList();

//Arrays.stream(int[]) returns an IntStream, which is a primitive stream and directly supports methods like average(), sum(), and max(). On the other hand,
// List<Integer>.stream() returns a Stream<Integer>, which is a generic object stream and does not provide these numeric operations.
// Therefore, we use mapToInt(Integer::intValue) to convert the Stream<Integer> into an IntStream before calling average().

////Find the k-th largest or k-th smallest element.

        int k=3;
        Optional<Integer> first = list.stream().distinct().sorted().skip(k - 1).findFirst();
        list.stream().distinct().sorted(Comparator.reverseOrder()).skip(k-1).findFirst();

////Group elements based on their remainder when divided by 3.

        Map<Boolean, List<Integer>> collect = list.stream().collect(Collectors.groupingBy(x -> x % 3 == 0));

        Arrays.stream(arr).boxed().collect(Collectors.groupingBy(x->x%3==0));

//      boxed() is required because Arrays.stream(int[]) returns an IntStream, whereas Collectors.groupingBy() works only with Stream<T>.
//      The boxed() method converts each primitive int into an Integer, producing a Stream<Integer>, which can then be used with collectors
//      such as groupingBy(), mapping(), and toList().

////Partition integers into even and odd using partitioningBy().

        Map<Boolean, List<Integer>> collect1 = list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));


////Convert an array into a List<Integer>.

        Arrays.stream(arr).boxed().toList();

////Find duplicate elements in an array.

        List<Integer> list4 = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey).toList();

////Check if a string contains only digits.

        boolean b5 = str.chars().allMatch(Character::isDigit);

////Create a list of string lengths.

        names.stream().map(name -> name.length()).toList();

////Convert all strings to uppercase.

        names.stream().map(name -> name.toUpperCase()).toList();

////Reverse a string using Stream API.

        str.chars().mapToObj(c -> String.valueOf((char)c)).reduce("", (a, b) -> b + a);

//      The map() method is used on a Stream<T> to transform one object into another object. It accepts a function that takes an object of type T and returns an object
//      of type R, producing a Stream<R>. In contrast, mapToObj() is used on primitive streams such as IntStream, LongStream, or DoubleStream. It converts each primitive
//      value into an object by applying a mapping function and returns a Stream<R>. In simple terms, use map() when you already have a stream of objects,
//      and use mapToObj() when you have a primitive stream and need to convert its elements into objects.

////Count strings that start with a specific letter / contain a character / have a character at a given position.

        long a = names.stream().filter(s -> s.startsWith("A")).count();
        long a1 = names.stream().filter(s -> s.contains("A")).count();

////Sort the list of strings in ascending or descending order based on length and then alphabetically.

        names.stream().sorted(Comparator.comparingInt(String::length).reversed().thenComparing(Comparator.naturalOrder())).toList();

////Find the longest string using reduce() or max().

        names.stream().max(Comparator.comparingInt(String::length)).get();

////Find all palindromic strings.

        names.stream().filter(s->s.equalsIgnoreCase(new StringBuffer(str).reverse().toString())).toList();

////Count the frequency of each character in a string or list of strings.

        names.stream().flatMap(s -> s.chars().mapToObj(c -> (char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

////Find repeated characters in a string.

        List<Character> repeated = str.chars()    //str.chars() returns an IntStream.
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1) // keep only repeated characters
                .map(entry->entry.getKey())
                .toList();

//map() transforms a value within the same primitive stream (IntStream → IntStream, LongStream → LongStream, etc.)
//mapToObj() converts a primitive stream into an object stream (IntStream → Stream<T>). This is why mapToObj(c -> (char) c) produces a Stream<Character>,
// while map(c -> (char) c) remains an IntStream.

////Find the first non-repeated character in a string.

        str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey).findFirst();

////Find the most frequent character in a string.

//        One most frequent character → use max().

        Character c1 = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(entry -> entry.getValue()))
                .map(entry -> entry.getKey()).get();

//max(Comparator.comparingLong(entry -> entry.getValue())): it returns one Map.Entry with the highest value.If multiple entries have the same maximum value,
//it returns one of them (typically the first encountered in the stream), not all of them.

//All characters tied for the highest frequency → find the maximum count first, then filter all entries with that count.

        Map<Character, Long> frequency = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long maxFrequency = frequency.values().stream().mapToLong(Long::longValue).max().orElse(0);

        List<Character> result = frequency.entrySet().stream()
                .filter(entry -> entry.getValue() == maxFrequency)
                .map(Map.Entry::getKey)
                .toList();

//filter() operates on one element at a time and requires a Predicate, which returns true or false to decide whether an element should remain in the stream.
// In contrast, max() needs to determine the largest element by comparing pairs of elements, so it requires a Comparator that defines the ordering between two elements.

////Find the most frequent word in a sentence.

        sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split("\\s+")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(entry -> entry.getValue()))
                .map(Map.Entry::getKey).get();

////Reverse each word in a sentence.

        sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .map(word -> new StringBuilder(word).reverse().toString()).toList();

////Extract all unique words from a list of sentences using flatMap().

        Stream<String> stream = sentences.stream();
        stream.flatMap(sentence -> Arrays.stream(sentence.split("\\s+")))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().
                filter(s -> s.getValue() == 1)
                .map(Map.Entry::getKey)
                .toList();

////Find all anagrams in a list of words using groupingBy() on sorted characters.

        Map<String, List<String>> collect2 = names.stream().collect(Collectors.groupingBy(
                word -> word.chars()
                        .sorted()
                        .mapToObj(c -> String.valueOf((char) c))
                        .collect(Collectors.joining())));

//The inner collect(Collectors.joining()) combines the sorted characters of a single word into one String, which serves as the grouping key.
// The outer collect(Collectors.groupingBy(...)) collects all words into a Map by grouping them according to that key. They operate on two different streams—one
// of characters and one of words—so both collect() calls are necessary. The grouping by function needs to group the element so inside groupingby we are defining key.

////Create a comma-separated string of names sorted alphabetically or by length from employees.

        String collect3 = employees.stream().map(employee -> employee.getName()).sorted().collect(Collectors.joining(","));

////Convert a list of names into a map (name → length).

        names.stream().collect(Collectors.toMap(
                name->name,
                name->name.length(),
                (oldvalue,newvalue)->oldvalue,     //merge function when duplicate keys are there
                LinkedHashMap::new                              // if you want to preserve insertion order
        ));

        //        Use toMap() when each key maps to exactly one value.
        //        Use groupingBy() when one key can have multiple values (groups).

////Extract first names from full names, convert to uppercase, remove duplicates, and sort.

        fullNames.stream().map(s -> s.trim().split("\\s+")[0])
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .toList();

////Flatten a list of lists into a single list using flatMap().

        listOfLists.stream().flatMap(List::stream).toList();

////Group names by their first letter.

        Map<Character, List<String>> collect4 = employees.stream().map(employee -> employee.getName()).collect(Collectors.groupingBy(s -> s.charAt(0)));
//        collect4.forEach((key,value)-> System.out.println(key  +" " + value));

////Find common elements between two lists.

        List<Integer> list6 = list1.stream().filter(x -> list2.contains(x)).toList();

////Find the average salary per department.

        employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
        ));

////Partition employees into high and low earners.

        Map<Boolean, List<Employee>> collect5 = employees.stream().collect(Collectors.partitioningBy(employee -> employee.getSalary() > 1000));
        collect5.get(true);
        collect5.get(false);

////Sort employees by age and then by name.

        employees.stream().sorted(Comparator.comparingInt(Employee::getAge).thenComparing(Comparator.comparing(Employee::getName))).toList();

////Find the highest-paid and second-highest-paid employee.

        Optional<Employee> highest = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));

        employees.stream().filter(emp->emp.getSalary()< highest.get().getSalary())
                .max(Comparator.comparingDouble(Employee::getSalary));

////Find the department with the highest total salary.

        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.summingDouble(Employee::getSalary)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(null);

// When working with a Map or a stream of Map.Entry objects, we can use
// methods like Map.Entry::getKey, Map.Entry::getValue,
// Map.Entry.comparingByKey(), and Map.Entry.comparingByValue()
// to access keys/values and compare map entries without knowing the key or value types explicitly.

//entry.getKey()        // A
//entry.getValue()      // 3

//Map.Entry::getKey
//Map.Entry::getValue

//Map.Entry.comparingByKey()
//Map.Entry.comparingByValue()

//Whenever you stream over a map using entrySet().stream(), each element is a Map.Entry<K, V>. The Map.Entry methods (getKey(), getValue(), comparingByKey(),
// and comparingByValue()) provide a concise and type-safe way to access or compare the keys and values of those entries.

////Group employees by age and salary (nested grouping).

        Map<Integer, Map<Double, List<Employee>>> collect6 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getAge, Collectors.groupingBy(Employee::getSalary)));

////Sort employees by age, salary, and name using null-safe comparators.

        List<Employee> sortedEmployees =employees.stream()
                .sorted(Comparator.comparing(Employee::getAge,Comparator.nullsLast(Integer::compareTo))
                                .thenComparing(Employee::getSalary,Comparator.nullsLast(Double::compareTo))
                                .thenComparing(Employee::getName, Comparator.nullsLast(String::compareToIgnoreCase)))
                .collect(Collectors.toList());

////Find the highest-paid employee in each department.

            employees.stream().
                    collect(Collectors.groupingBy(Employee::getDepartment,
                            Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)))
                    );

////Find all departments sorted by total salary (descending).

        employees.stream().collect(
                Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.summingDouble(Employee::getSalary))
                )
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .toList();

////Find employees whose names start and end with the same letter.

                List<Employee> filtered = employees.stream()
                .filter(e -> {
                    String name = e.getName().toLowerCase();
                    return name.charAt(0) == name.charAt(name.length() - 1);
                }).collect(Collectors.toList());

////Find employees whose salary is greater than their department's average salary.

        Map<Integer, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        employees.stream().filter(emp->emp.getSalary()>avgSalaryByDept.get(emp.getDepartment())).toList();


////Create a map of department → list of employee names (sorted order using TreeMap).

        Map<Integer, List<String>> collect7 = employees.stream().
                collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.mapping(
                            Employee::getName,
                            Collectors.toList()))
                );


////4Group products by category and then find top 3 highest priced products per category.

        Map<String, List<Product>> top3ByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory, // group by category
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                listt -> listt.stream()
                                        .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                                        .limit(3)
                                        .toList()
                        )
                ));

//Remove duplicate strings while preserving insertion order.
//Find the second largest and second smallest element.
//Find the intersection and union of two lists.
//Find the missing number from an array using streams.
//Find duplicate words in a sentence.
//Count vowels and consonants in a string.
//Merge two lists and remove duplicates.
//Convert a list into a Map grouped by string length.
//Find the employee with the minimum salary in each department.
//Find departments having more than N employees.
//Count employees in each department.
//Find the youngest and oldest employee.
//Find the top N highest-paid employees.
//Join employee names with a delimiter using Collectors.joining().
//Convert a list of employees into a Map<Id, Employee>.
//Find duplicate employee names.
//Partition employees into adults and minors (or based on age threshold).
//Find the first employee matching a condition.
//Demonstrate parallel stream processing and compare it with sequential streams.

    }
}


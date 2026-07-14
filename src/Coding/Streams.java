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
                new Employee(1,"A",10,10000.0,100),
                new Employee(2,"B",10,20000.0,100),
                new Employee(3,"C",20,30000.0,200),
                new Employee(4,"D",20,40000.0,300),
                new Employee(5,"E",30,50000.0,300));

//        List<String> fullNames = List.of("John Doe", "Jane Smith", "Alice Johnson", "Bob Brown", "Jane Smith", "alice   johnson");
//        List<List<Integer>> listOfLists = List.of(List.of(1, 2, 3),List.of(4, 5),List.of(6, 7, 8, 9));
//        List<String> names = List.of("Rahul", "Amit", "Sureshhhh", "Ankit","Naman","Amit");
//        String str="daadbccdb@#123DC";
//        List<String> sentences = List.of("Java is fun", "Streams are powerful", "Java Streams are awesome","Java is good");
//        List<Integer> integers = List.of(1,2,3,5,4,5);
//        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
//        List<Integer> list2 = List.of(3, 4, 5, 6, 7);
//        OptionalDouble average = integers.stream().mapToInt(Integer::intValue).average();
//        int k=2;
//        Optional<Integer> max = integers.stream().distinct().max(Comparator.naturalOrder());
////        List<Integer> list = Arrays.stream(array).boxed().toList();

//        List<List<Integer>> numbers = List.of(
//                List.of(1, 2),
//                List.of(3, 4),
//                List.of(5, 6)
//        );

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

//        List<Integer> list = Stream.iterate(0, i -> i + 1).limit(20).skip(5).toList();
//        System.out.println(list);


////Find the maximum and minimum number from a list or from array using streams.

//        int[] arr={1,2,3,4,5,-1};
//        OptionalInt max = Arrays.stream(arr).max();
//        OptionalInt min = Arrays.stream(arr).min();


//        List<Integer> list= List.of(1,1,2,3,4,5,-1);
//        Optional<Integer> max = list.stream().max(Comparator.comparingInt(e -> e));
//        Optional<Integer> min = list.stream().min(Comparator.comparingInt(e -> e));
//        Integer listIsEmpty = integers.stream().max(Integer::compareTo).orElseThrow(() -> new NoSuchElementException("List is empty"));
//        integers.stream().max(Comparator.naturalOrder()).ifPresentOrElse(System.out::println, ()-> System.out.println("List is empty"));

////Calculate the sum of squares of distinct numbers using reduce().

//        int[] arr={1,2,3,4,5,1,10,5,5};
//        Integer reduce = Arrays.stream(arr).distinct().mapToObj(n -> n * n).reduce(0, (a, b) -> a + b);
//        System.out.println(reduce);


////Check if all numbers are even / any number is negative / none is zero using match methods.

//        int[] arr={1,2,3,4,5,1,10,5,-5};
//        boolean b = Arrays.stream(arr).allMatch(x -> x % 2 == 0);
//        boolean b1 = Arrays.stream(arr).anyMatch(x -> x < 0);
//        boolean b2 = Arrays.stream(arr).noneMatch(x -> x != 0);

////Find all elements greater than the average value.

//        List<Integer> list= List.of(1,1,2,3,4,5,1);
//        double asDouble = list.stream().mapToInt(Integer::intValue).average().getAsDouble();
//        List<Integer> list1 = list.stream().filter(x -> x > asDouble).toList();

//Arrays.stream(int[]) returns an IntStream, which is a primitive stream and directly supports methods like average(), sum(), and max(). On the other hand,
// List<Integer>.stream() returns a Stream<Integer>, which is a generic object stream and does not provide these numeric operations.
// Therefore, we use mapToInt(Integer::intValue) to convert the Stream<Integer> into an IntStream before calling average().

////Find the k-th largest or k-th smallest element.

//        int k=3;
//        List<Integer> list= List.of(1,1,2,3,4,5,1);
//        Optional<Integer> first = list.stream().distinct().sorted().skip(k - 1).findFirst();
//        list.stream().distinct().sorted(Comparator.reverseOrder()).skip(k-1).findFirst();

////Group elements based on their remainder when divided by 3.

//        List<Integer> list= List.of(1,1,2,3,4,5,1);
//        Map<Boolean, List<Integer>> collect = list.stream().collect(Collectors.groupingBy(x -> x % 3 == 0));
//        System.out.println(collect.entrySet());
//
//        int[] arr={1,2,3,4,5,1,10,5,-5};
//        Arrays.stream(arr).boxed().collect(Collectors.groupingBy(x->x%3==0));

//        boxed() is required because Arrays.stream(int[]) returns an IntStream, whereas Collectors.groupingBy() works only with Stream<T>.
//        The boxed() method converts each primitive int into an Integer, producing a Stream<Integer>, which can then be used with collectors
//        such as groupingBy(), mapping(), and toList().

////Partition integers into even and odd using partitioningBy().

//        List<Integer> list= List.of(1,1,2,3,4,5,1);
//        Map<Boolean, List<Integer>> collect = list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
//        System.out.println(collect.get(true));

////Convert an array into a List<Integer>.

//        int[] arr={1,2,3,4,5,1,10,5,-5};
//        Arrays.stream(arr).boxed().toList();

////Find duplicate elements in an array.

//        int[] arr={1,2,3,4,5,1,10,5,-5};
//        List<Integer> list = Arrays.stream(arr).boxed()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet().stream()
//                .filter(entry -> entry.getValue() > 1)
//                .map(Map.Entry::getKey).toList();

////Check if a string contains only digits.

//        String str="12s1d1s21d";
//        boolean b = str.chars().allMatch(Character::isDigit);


////Create a list of string lengths.

//        List<String> names = List.of("Rahul", "Amit", "Sureshhhh", "Ankit","Naman","Amit");
//        List<Integer> list = names.stream().map(name -> name.length()).toList();
//        System.out.println(list);


////Convert all strings to uppercase.

//        List<String> names = List.of("Rahul", "Amit", "Sureshhhh", "Ankit","Naman","Amit");
//        List<String> list = names.stream().map(name -> name.toUpperCase()).toList();
//        System.out.println(list);

////        Reverse a string using Stream API.

//        String str="12s1d1s21d";
//        String reduce = str.chars()
//                .mapToObj(c -> String.valueOf((char)c)).reduce("", (a, b) -> b + a);
//        System.out.println(reduce);

//      The map() method is used on a Stream<T> to transform one object into another object. It accepts a function that takes an object of type T and returns an object
//      of type R, producing a Stream<R>. In contrast, mapToObj() is used on primitive streams such as IntStream, LongStream, or DoubleStream. It converts each primitive
//      value into an object by applying a mapping function and returns a Stream<R>. In simple terms, use map() when you already have a stream of objects,
//      and use mapToObj() when you have a primitive stream and need to convert its elements into objects.

////Count strings that start with a specific letter / contain a character / have a character at a given position.

//        List<String> names = List.of("Rahul", "Amit", "Sureshhhh", "Ankit","Naman","Amit");
//        long a = names.stream().filter(str -> str.startsWith("A")).count();
//        long a1 = names.stream().filter(str -> str.contains("A")).count();

////Sort the list of strings in ascending or descending order based on length and then alphabetically.

//        List<String> names = List.of("Rahul", "Amit", "Sureshhhh", "Ankit","Naman","Amit");
//        List<String> list = names.stream().sorted(Comparator.comparingInt(String::length).reversed().thenComparing(Comparator.naturalOrder())).toList();

////Find the longest string using reduce() or max().

//        List<String> names = List.of("Rahul", "Amit", "Sureshhhh", "Ankit","Naman","Amit");
//        String s = names.stream().max(Comparator.comparingInt(String::length)).get();

////Find all palindromic strings.

//        List<String> names = List.of("Rahul", "Amit", "Sureshhhh", "Ankit","Naman","Amit");
//        names.stream().filter(str->str.equalsIgnoreCase(new StringBuffer(str).reverse().toString())).toList();

////Count the frequency of each character in a string or list of strings.

//        List<String> names = List.of("Rahul", "Amit", "Sureshhhh", "Ankit","Naman","Amit");
//        Map<Character, Long> collect = names.stream().flatMap(str -> str.chars().mapToObj(c -> (char) c))
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

////Find repeated characters in a string.
//        List<Character> repeated = str.chars()
//                .mapToObj(c -> (char) c)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet()
//                .stream()
//                .filter(entry -> entry.getValue() > 1) // keep only repeated characters
//                .map(entry->entry.getKey())
//                .toList();

////Find the first non-repeated character in a string.

//        String str="Abcdankdnk5545";
//
//        Optional<Character> first = str.chars().mapToObj(c -> (char) c)
//                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
//                .entrySet().stream().filter(entry -> entry.getValue() == 1)
//                .map(Map.Entry::getKey).findFirst();

////Find the most frequent character in a string.



////Find the most frequent word in a sentence.
////Reverse each word in a sentence.
////Extract all unique words from a list of sentences using flatMap().
////Find all anagrams using groupingBy() on sorted characters.
////Create a comma-separated string of names sorted alphabetically or by length.
////Convert a list of names into a map (name → length).
////Extract first names from full names, convert to uppercase, remove duplicates, and sort.
////Flatten a list of lists into a single list using flatMap().
////Group names by their first letter.
////Find common elements between two lists.
////Group employees by department.
////Find the average salary per department.
////Partition employees into high and low earners.
////Sort employees by age and then by name.
////Find the highest-paid and second-highest-paid employee.
////Find the department with the highest total salary.
////Group employees by age and salary (nested grouping).
////Sort employees by age, salary, and name using null-safe comparators.
////Find the highest-paid employee in each department.
////Find all departments sorted by total salary (descending).
////Find employees whose names start and end with the same letter.
////Find employees whose salary is greater than their department's average salary.
////Create a map of department → list of employee names.
////Group products by category and find the top 3 highest-priced products in each category.





////20. Find the first non-repeated character in a string.
//        Character NonRepeatedCharacter = str.chars().mapToObj(c -> (char) c).
//                  collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
//                 .entrySet().stream()
//                 .filter(entry -> entry.getValue() > 1)
//                 .map(Map.Entry::getKey)
//                 .findFirst().orElse(null);
//        System.out.println(NonRepeatedCharacter);

////21. Find the most frequent character in a string using Stream API.
//        Character c1 = str.chars()
//                .mapToObj(c -> (char) c)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet().stream()
//                .max(Comparator.comparingLong(Map.Entry::getValue))
//                .map(entry->entry.getKey())
//                .orElse(null);

////22. Given a sentence, find the most frequent word using streams.
//        String s = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split("\\s+")))
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet().stream()
//                .max(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey)
//                .orElse(null);

////23. Reverse each word in a sentence using streams.

////24. Extract all unique words from a list of sentences using flatMap().
//        List<String> list = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split("\\s+"))).map(String::toLowerCase).distinct().toList();
//        List<String> list = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split("\\s+"))).map(String::toLowerCase)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet().stream().filter(s -> s.getValue() == 1)
//                .map(s -> s.getKey()).toList();

////25. Find all anagrams in a list of words using groupingBy() on sorted characters.

//        Map<String, List<String>> anagrams = words.stream()
//                .collect(Collectors.groupingBy(word -> word.chars().sorted().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining())));

////26. Create a comma-separated string of names sorted alphabetically or by length.
//        String collect = employees.stream().map(Employee::getName).sorted().collect(Collectors.joining(","));
//        employees.stream().map(org.coding.Employee::getName).sorted(Comparator.comparingInt(String::length).reversed()).toList();

////27. Convert a list of names into a map with key = name, value = length of the name.
//        LinkedHashMap<String, Integer> collect = names.stream().collect(Collectors.toMap(
//                name -> name,
//                String::length,
//                (old_value, new_value) -> old_value,  //merge function when duplicate keys are there
//                LinkedHashMap::new                    // if you want to preserve insertion order
//        ));

//        Use toMap() when each key maps to exactly one value.
//        Use groupingBy() when one key can have multiple values (groups).

////28. Extract first names from a list of full names, convert to uppercase, remove duplicates, and sort alphabetically using streams.
//        List<String> list = fullNames.stream().map(s -> s.trim().split("\\s+")[0]).map(String::toUpperCase).distinct().sorted().toList();

////29. Flatten a list of lists of integers into a single list using flatMap().
//        List<Integer> list = listOfLists.stream().flatMap(List::stream).toList();

////30. Group a list of names by their first letter.
//        Map<Character, List<String>> collect = names.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
//        collect.forEach((key,value)-> System.out.println(key + " -> " + value));

////31. Find common elements between two lists using Stream API and filter().
//        List<Integer> common = list1.stream().filter(list2::contains).toList();
//        List<Integer> list = list1.stream().filter(x -> list2.contains(x)).toList();

////32. Group employees by department.
//        Map<Integer, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));

////33. Find the average salary per department.
//        Map<Integer, Double> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

////34. Partition employees into high and low earners using a salary threshold.
//        double threshold = 70000;
//        Map<Boolean, List<Employee>> partitioned = employees.stream().collect(Collectors.partitioningBy(e -> e.Salary > threshold));
//        System.out.println("High Earners Count: " + partitioned.get(true).size());
//        System.out.println("Low Earners Count: " + partitioned.get(false).size());

////35. Sort employees by age, then by name using Comparator.comparing() and thenComparing().
//        List<Employee> list = employees.stream().sorted(Comparator.comparingInt(Employee::getAge).thenComparing(Comparator.comparing(Employee::getName))).toList();

////36. Find the highest-paid and second-highest-paid employee.
//        Optional<Employee> highest = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
//        System.out.println(highest.get().getName());
//        Optional<Employee> secondhighest = employees.stream().filter(e -> highest == null || e.getSalary() < highest.get().getSalary()).max(Comparator.comparingDouble(Employee::getSalary));

////37. Find the department with the highest total salary.
//        Integer i = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getAge, Collectors.summingDouble(Employee::getSalary)))
//                .entrySet().stream()
//                .max(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey).orElse(null);

////38. Group employees by age and salary.
//        Map<Integer, Map<Double, List<Employee>>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.groupingBy(Employee::getSalary)));

////39. Sort list of employees by multiple fields (age, salary, name) using null-safe comparators.
//        List<Employee> sortedEmployees =employees.stream()
//                .sorted(Comparator.comparing(Employee::getAge,Comparator.nullsLast(Integer::compareTo))
//                                .thenComparing(Employee::getSalary,Comparator.nullsLast(Double::compareTo))
//                                .thenComparing(Employee::getName, Comparator.nullsLast(String::compareToIgnoreCase)))
//                .collect(Collectors.toList());

////40. Find employee(s) with the max salary in each department.
//        Map<Integer, Optional<Employee>> collect = employees.stream().
//        collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

////41. Find all departments sorted by total salary (descending).
//        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)))
//                .entrySet().stream()
//                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed()).toList();

////42. Find employees whose names start and end with the same letter.
//        List<Employee> filtered = employees.stream()
//                .filter(e -> {
//                    String name = e.name.toLowerCase();
//                    return name.charAt(0) == name.charAt(name.length() - 1);
//                }).collect(Collectors.toList());

////43. Find employees whose salary is greater than the average salary of their department (also using toMap).
//        Map<Integer, Double> avgSalaryByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
//        List<Employee> list = employees.stream().filter(e -> e.getSalary() > avgSalaryByDept.get(e.getDepartment())).toList();

////44. Create a map of department name → list of employee names.
//        Map<Integer, List<String>> deptToEmployees = employees.stream()
//                .collect(Collectors.groupingBy(
//                        Employee::getDepartment,                     // key → department name
//                        Collectors.mapping(Employee::getName,        // value → list of names
//                                Collectors.toList())
//                ));

////45. Create a map of department name → list of employee names (sorted order using TreeMap).
//        Map<Integer, ArrayList<String>> collect = employees.stream().collect(Collectors.toMap(
//                Employee::getDepartment,
//                e -> new ArrayList<>(List.of(e.getName())),
//                (existing, replacemet) -> {
//                    existing.addAll(replacemet);
//                    existing.sort(String::compareTo);
//                    return existing;
//                }
//        ));

////46. Group products by category and then find top 3 highest priced products per category.
//        Map<String, List<Product>> top3ByCategory = products.stream()
//                .collect(Collectors.groupingBy(
//                        Product::getCategory, // group by category
//                        Collectors.collectingAndThen(
//                                Collectors.toList(),
//                                list -> list.stream()
//                                        .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
//                                        .limit(3)
//                                        .toList()
//                        )
//                ));




////Generate a stream of different element with size 20 and skip the first 5 in reverse order.
//        List<Integer> list = Stream.iterate(1, i -> i + 1).skip(5).limit(20 ).sorted(Comparator.reverseOrder()).toList();
//        List<Integer> list = Stream.iterate(20, i -> i - 1).limit(15).toList();
//        System.out.println(list);

////Find the maximum and minimum number from a list using streams.
//        Optional<Integer> min = integers.stream().min((a, b) -> a - b);
//        Optional<Integer> max = integers.stream().max((a, b) -> a - b);
//        Integer listIsEmpty = integers.stream().max(Integer::compareTo).orElseThrow(() -> new NoSuchElementException("List is empty"));
//        integers.stream().max(Comparator.naturalOrder()).ifPresentOrElse(System.out::println, ()-> System.out.println("List is empty"));
//        max.ifPresent(maxi-> System.out.println(maxi));

////Calculate the sum of all squares of distinct numbers in a list using reduce().
//        Integer reduce = integers.stream().distinct().map(n -> n * n).reduce(0, Integer::sum);

////Check if all numbers are even / any number is negative / none is zero using different methods.
//        boolean b = integers.stream().allMatch(n -> n % 2 == 0);
//        System.out.println(b);
//        boolean b1 = integers.stream().anyMatch(n -> n < 0);
//        System.out.println(b1);
//        boolean b2 = integers.stream().noneMatch(n -> n == 0);
//        System.out.println(b2);

////Check if a string contains only digits using Stream API.
//        boolean only_digits_in_string = str.chars().allMatch(Character::isDigit);
//        System.out.println(only_digits_in_string);

////From a list of strings, create a list of their lengths.
//        List<Integer> list = names.stream().map(String::length).toList();

////Given a list of strings, convert all to uppercase and print.
//        List<String> list = names.stream().map(String::toUpperCase).toList();

////Flatten a list of lists of integers into a single list using flatMap().
//        List<Integer> list = listOfLists.stream().flatMap(List::stream).toList();

////Extract all unique words from a list of sentences using flatMap().
//        List<String> list = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split("\\s+"))).map(String::toLowerCase).distinct().toList();
//        List<String> list = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split("\\s+"))).map(String::toLowerCase)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet().stream().filter(s -> s.getValue() == 1)
//                .map(s -> s.getKey()).toList();

////Reverse the string.
//    String reversed = str.chars().mapToObj(c -> String.valueOf((char) c)).reduce("", (a, b) -> b + a);

////Given a list of names, group them by their first letter.
//        Map<Character, List<String>> collect = names.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
//        collect.forEach((key,value)-> System.out.println(key + " -> " + value));

////Count the number of strings that start with the letter "A" and at random position.
//        long a = names.stream().filter(s -> s.startsWith("A")).count();
//        long count = names.stream().filter(s -> s.startsWith("k",2)).count();
//        long a = names.stream().filter(s -> s.toLowerCase().contains("A")).count();

////Sort the list on ascending/descending order basis on the length and then alphabetically.
//    List<String> list = names.stream().sorted(Comparator.comparingInt(String::length).reversed().thenComparing(Comparator.naturalOrder())).toList();

////From a list of strings, find the longest string using reduce() or max().
//        String s = names.stream().max(Comparator.comparingInt(String::length)).orElse(null);
//        String s1 = names.stream().reduce((a, b) -> a.length() >= b.length() ? a : b).orElse(null);

////Find all palindromic strings from a list.
//        List<String> palindromes = names.stream().filter(word -> word.equalsIgnoreCase(new StringBuilder(word).reverse().toString())).toList();

//// Find all elements greater than the average.
//        double average = integers.stream().mapToInt(Integer::intValue).average().orElse(0);
//        List<Integer> greaterThanAvg = integers.stream().filter(n -> n > average).toList();

////Find common elements between two lists using Stream API.
//        List<Integer> common = list1.stream().filter(list2::contains).toList();
//        List<Integer> list = list1.stream().filter(x -> list2.contains(x)).toList();

////Group elements of a list based on their remainder when divided by 3 using Stream API.
//        Map<Boolean, List<Integer>> collect = integers.stream().collect(Collectors.groupingBy(x -> x % 3 == 0));

////Partition a list of integers into even and odd using partitioningBy().
//        Map<Boolean, List<Integer>> collect = integers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));

////Count the frequency of each character in a string/list of string using Stream API.
//        Map<Character, Long> frequency = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        Map<Character, Long> frequency = names.stream().flatMap(s -> s.chars().mapToObj(c -> (char) c)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

////Find the repeated characters in the string.
//        List<Character> repeated = str.chars()
//                .mapToObj(c -> (char) c)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet()
//                .stream()
//                .filter(entry -> entry.getValue() > 1) // keep only repeated characters
//                .map(entry->entry.getKey())
//                .collect(Collectors.toList());

////Find the first non-repeated character in the string:
//        Character NonRepeatedCharacter = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
//                .entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).findFirst().orElse(null);
//        List<Character> list = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
//                .entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).toList();
//        System.out.println(NonRepeatedCharacter);

////Find the most frequent character in a string using Java Stream API.
//        Character c1 = str.chars()
//                .mapToObj(c -> (char) c)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet().stream()
//                .max(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey)
//                .orElse(null);

//// Given a sentence, find the most frequent word using streams. .max((e1, e2) -> Long.compare(e1.getValue(), e2.getValue()))
//        String s = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split("\\s+")))
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet().stream()
//                .max(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey)
//                .orElse(null);

////Reverse each word in a sentence using streams.

////30: Extract first names from a list of full names, convert to uppercase, remove duplicates, and sort alphabetically using Java Streams.
//        List<String> list = fullNames.stream().map(s -> s.trim().split("\\s+")[0]).map(String::toUpperCase).distinct().sorted().toList();

////31: Find the kth largest or smallest element using streams.
//        int k = 3;
//        int kthLargest = integers.stream().sorted(Comparator.reverseOrder()).skip(k - 1).findFirst().orElseThrow(() -> new NoSuchElementException("List too small"));
//        int kthSmallest = integers.stream().sorted().skip(k - 1).findFirst().orElseThrow(() -> new NoSuchElementException("List too small"));

////34: Given a list of employees, group them by department.
//        Map<Integer, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));

////35: Given a list of employees, find the average salary per department.
//        Map<Integer, Double> collect = employees.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.averagingDouble(Employee::getSalary)));

////36: Partition employees into high and low earners.
//        double threshold = 70000;
//        Map<Boolean, List<Employee>> partitioned = employees.stream().collect(Collectors.partitioningBy(e -> e.Salary > threshold));
//        System.out.println("High Earners Count: " + partitioned.get(true).size());
//        System.out.println("Low Earners Count: " + partitioned.get(false).size());


////37: Sort employees by age, then by name using Comparator.comparing() and thenComparing().
//        List<Employee> list = employees.stream().sorted(Comparator.comparingInt(Employee::getAge).thenComparing(Comparator.comparing(Employee::getName))).toList();

////38: Given a list of employees, find the name of the highest-paid employee and second highest paid employee.
//        Optional<Employee> highest = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
//        System.out.println(highest.get().getName());
//        Optional<Employee> secondhighest = employees.stream().filter(e -> highest == null || e.getSalary() < highest.get().getSalary()).max(Comparator.comparingDouble(Employee::getSalary));


////39: From a list of employees, find the department that has the highest total salary.
//        Integer i = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getAge, Collectors.summingDouble(Employee::getSalary)))
//                .entrySet().stream()
//                .max(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey).orElse(null);

////40: From a list of employees, create a comma-separated string of their names sorted alphabetically/ and on the length .
//        String collect = employees.stream().map(Employee::getName).sorted().collect(Collectors.joining(","));
//        employees.stream().map(org.coding.Employee::getName).sorted(Comparator.comparingInt(String::length).reversed()).toList()

////41: Group people by age and salary:
//        Map<Integer, Map<Double, List<Employee>>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.groupingBy(Employee::getSalary)));

////42: Sort list of employees by multiple fields age,salary and name with null-safe comparators.

//        List<Employee> sortedEmployees =employees.stream()
//                .sorted(Comparator.comparing(Employee::getAge,Comparator.nullsLast(Integer::compareTo))
//                                .thenComparing(Employee::getSalary,Comparator.nullsLast(Double::compareTo))
//                                .thenComparing(Employee::getName, Comparator.nullsLast(String::compareToIgnoreCase)))
//                .collect(Collectors.toList())

////43: Count the frequency of each character in a string using Stream API. String can contain uppercase character, and special character.
//        Map<Character, Long> collect = str.chars().mapToObj(c -> (char) c).filter(Character::isLetter).map(Character::toLowerCase).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        Map<Character, Long> collect1 = names.stream().flatMap(name -> name.chars().mapToObj(c -> (char) c)).filter(Character::isLetter).map(Character::toLowerCase).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

////44: Find employee(s) with max salary in each department.
//        Map<Integer, Optional<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

////46: Find all departments sorted by total salary descending.
//        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)))
//                .entrySet().stream()
//                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed()).toList();

////47: Find employees whose names start and end with the same letter.
//        List<Employee> filtered = employees.stream()
//                .filter(e -> {
//                    String name = e.name.toLowerCase();
//                    return name.charAt(0) == name.charAt(name.length() - 1);
//                }).collect(Collectors.toList());

////49. Find Employee whose salary is greater than the average salary of department.
//        Map<Integer, Double> avgSalaryByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
//        List<Employee> list = employees.stream().filter(e -> e.getSalary() > avgSalaryByDept.get(e.getDepartment())).toList();

////49. Group products by category and then find top 3 highest priced products per category.
//        Map<String, List<Product>> top3ByCategory = products.stream()
//                .collect(Collectors.groupingBy(
//                        Product::getCategory, // group by category
//                        Collectors.collectingAndThen(
//                                Collectors.toList(),
//                                list -> list.stream()
//                                        .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
//                                        .limit(3)
//                                        .toList()
//                        )
//                ));

////51. Convert a list of names into a map with key = name, value = length of the name.
//        LinkedHashMap<String, Integer> collect = names.stream().collect(Collectors.toMap(
//                name -> name,
//                String::length,
//                (old_value, new_value) -> old_value,
//                LinkedHashMap::new
//        ));

////52. Create a map of department name → list of employee names.

//        Map<Integer, List<String>> deptToEmployees = employees.stream()
//                .collect(Collectors.groupingBy(
//                        Employee::getDepartment,                     // key → department name
//                        Collectors.mapping(Employee::getName,        // value → list of names
//                                Collectors.toList())
//                ));

//        Map<Integer, ArrayList<String>> collect = employees.stream().collect(Collectors.toMap(
//                Employee::getDepartment,
//                e -> new ArrayList<>(List.of(e.getName())),
//                (existing, replacemet) -> {
//                    existing.addAll(replacemet);
//                    existing.sort(String::compareTo);
//                    return existing;
//                }
//        ));




    }
}


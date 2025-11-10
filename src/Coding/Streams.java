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

        List<String> fullNames = List.of("John Doe", "Jane Smith", "Alice Johnson", "Bob Brown", "Jane Smith", "alice   johnson");
        List<List<Integer>> listOfLists = List.of(List.of(1, 2, 3),List.of(4, 5),List.of(6, 7, 8, 9));
        List<String> names = List.of("Rahul", "Amit", "Sureshhhh", "Ankit","Naman","Amit");
        String str="daadbccdb@#123DC";
        List<String> sentences = List.of("Java is fun", "Streams are powerful", "Java Streams are awesome","Java is good");
        List<Integer> integers = List.of(1,2,3,5,4,5);
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        List<Integer> list2 = List.of(3, 4, 5, 6, 7);
        OptionalDouble average = integers.stream().mapToInt(Integer::intValue).average();
        int k=2;
        Optional<Integer> max = integers.stream().distinct().max(Comparator.naturalOrder());
//        List<Integer> list = Arrays.stream(array).boxed().toList();


////01. Generate a stream of 20 different elements, skip the first 5, and print remaining elements in reverse order (without sorting).
//        List<Integer> list = Stream.iterate(1, i -> i + 1).skip(5).limit(20 ).sorted(Comparator.reverseOrder()).toList();
//        List<Integer> list = Stream.iterate(20, i -> i - 1).limit(15).toList();
//        System.out.println(list);

////02. Find the maximum and minimum number from a list using streams.
//        Optional<Integer> min = integers.stream().min((a, b) -> a - b);
//        Optional<Integer> max = integers.stream().max((a, b) -> a - b);
//        Integer listIsEmpty = integers.stream().max(Integer::compareTo).orElseThrow(() -> new NoSuchElementException("List is empty"));
//        integers.stream().max(Comparator.naturalOrder()).ifPresentOrElse(System.out::println, ()-> System.out.println("List is empty"));
//        max.ifPresent(maxi-> System.out.println(maxi));

////03. Calculate the sum or sum of squares of distinct numbers in a list using reduce().
//        Integer reduce = integers.stream().distinct().map(n -> n * n).reduce(0, Integer::sum);

////04. Check if all numbers are even / any number is negative / none is zero using different match methods.
//        boolean b = integers.stream().allMatch(n -> n % 2 == 0);
//        System.out.println(b);
//        boolean b1 = integers.stream().anyMatch(n -> n < 0);
//        System.out.println(b1);
//        boolean b2 = integers.stream().noneMatch(n -> n == 0);
//        System.out.println(b2);

////05. Find all elements greater than the average value.
//        double average = integers.stream().mapToInt(Integer::intValue).average().orElse(0);
//        List<Integer> greaterThanAvg = integers.stream().filter(n -> n > average).toList();

////06. Find the k-th largest or smallest element using streams.
//        int k = 3;
//        int kthLargest = integers.stream().sorted(Comparator.reverseOrder()).skip(k - 1).findFirst().orElseThrow(() -> new NoSuchElementException("List too small"));
//        int kthSmallest = integers.stream().sorted().skip(k - 1).findFirst().orElseThrow(() -> new NoSuchElementException("List too small"));

////07. Group elements of a list into 3 groups based on their remainder when divided by 3 using Stream API
        Map<Integer, List<Integer>> collect = integers.stream().collect(Collectors.groupingBy(x -> x % 3));

////08. Partition a list of integers into even and odd using partitioningBy().
//        Map<Boolean, List<Integer>> collect = integers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));

////09. Convert array into list of integer.
//        List<Integer> list = Arrays.stream(array).boxed().toList();

////  Remove duplicates from the sorted array:
//        List<Integer> list = Arrays.stream(arr).boxed()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet().stream()
//                .filter(entry -> entry.getValue() > 1)
//                .map(entry -> entry.getKey()).toList();

////10. Check if a string contains only digits if it’s not empty using Stream API.
//        boolean only_digits_in_string = str.chars().allMatch(Character::isDigit);
//        System.out.println(only_digits_in_string);

////11. From a list of strings, create a list of their lengths.
//        List<Integer> list = names.stream().map(String::length).toList();

////12. Convert all strings in a list to uppercase and print.
//        List<String> list = names.stream().map(String::toUpperCase).toList();

////13. Reverse a string using Stream API.
//        String reversed = str.chars().mapToObj(c -> String.valueOf((char) c)).reduce("", (a, b) -> b + a);

////14. Count the number of strings that start with a specific letter (e.g., "A") / contain a specific alphabet / character at a random position.
//        long a = names.stream().filter(s -> s.startsWith("A")).count();
//        long count = names.stream().filter(s -> s.startsWith("k",2)).count();
//        long a = names.stream().filter(s -> s.toLowerCase().contains("A")).count();

////15. Sort the list of strings in ascending or descending order based on length and then alphabetically.
//        List<String> list = names.stream().sorted(Comparator.comparingInt(String::length).reversed().thenComparing(Comparator.naturalOrder())).toList();

////16. From a list of strings, find the longest string using reduce() or max().
//        String s = names.stream().max(Comparator.comparingInt(String::length)).orElse(null);
//        String s1 = names.stream().reduce((a, b) -> a.length() >= b.length() ? a : b).orElse(null);

////17. Find all palindromic strings from a list.
//        List<String> palindromes = names.stream().filter(word -> word.equalsIgnoreCase(new StringBuilder(word).reverse().toString())).toList();

////18. Count the frequency of each character in a string or list of strings using Stream API.
//        Map<Character, Long> frequency = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        Map<Character, Long> frequency = names.stream().flatMap(s -> s.chars().mapToObj(c -> (char) c)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

////19. Find repeated characters in a string.
//        List<Character> repeated = str.chars()
//                .mapToObj(c -> (char) c)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet()
//                .stream()
//                .filter(entry -> entry.getValue() > 1) // keep only repeated characters
//                .map(entry->entry.getKey())
//                .collect(Collectors.toList());

////20. Find the first non-repeated character in a string.
//        Character NonRepeatedCharacter = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
//                .entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).findFirst().orElse(null);
//        List<Character> list = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
//                .entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).toList();
//        System.out.println(NonRepeatedCharacter);

////21. Find the most frequent character in a string using Stream API.
//        Character c1 = str.chars()
//                .mapToObj(c -> (char) c)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet().stream()
//                .max(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey)
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

////26. Create a comma-separated string of names sorted alphabetically or by length.
//        String collect = employees.stream().map(Employee::getName).sorted().collect(Collectors.joining(","));
//        employees.stream().map(org.coding.Employee::getName).sorted(Comparator.comparingInt(String::length).reversed()).toList();

////27. Convert a list of names into a map with key = name, value = length of the name.
//        LinkedHashMap<String, Integer> collect = names.stream().collect(Collectors.toMap(
//                name -> name,
//                String::length,
//                (old_value, new_value) -> old_value,
//                LinkedHashMap::new
//        ));

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
//        Map<Integer, Double> collect = employees.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.averagingDouble(Employee::getSalary)));

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
//        Map<Integer, Optional<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

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


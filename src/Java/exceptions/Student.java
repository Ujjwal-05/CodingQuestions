package Java.exceptions;

public class Student {


    void checkAge(int age) throws EvenAgeException {
        if(age<18){
            throw new InvalidAgeException("Age is less than 18");
        } else if (age%2==0) {
            throw new EvenAgeException("Age is even");
        }else {
//            throw new RuntimeException("Something went wrong");
//            throw new IllegalArgumentException("Invalid input");
//            throw new RuntimeException(new IllegalArgumentException("Invalid input"));


        }

    }
}



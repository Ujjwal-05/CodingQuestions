package Java.exceptions;

public class Client {
    public static void main(String[] args) throws EvenAgeException {
        Student student=new Student();;
        student.checkAge(101);
    }
}

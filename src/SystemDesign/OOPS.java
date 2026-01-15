package SystemDesign;

class User{

    void login(){
        System.out.println("User logged in");
    }

    void show(){
        System.out.println("User class");
    }

}

class Student extends User{

    void marks(){
        System.out.println("Total marks is 80");
    }
    @Override
    void show(){
        System.out.println("Student class");
    }
}

class Faculty extends User{


    @Override
    void show() {
        System.out.println("Faculty class");
    }
}
class Akash extends Student{

    void marks(){
        System.out.println("Total marks is 80");
    }
    @Override
    void show(){
        System.out.println("Akash from Student class");
    }
}


public class OOPS {
    public static void main(String[] args) {

        User user=new User();
        user.show();  // User class

        User user1=new Student();
        user1.show();  // Student class
//      user1.marks(); // Compliation Error
        user1.login(); // User logged in

        User user2=new Faculty();
        user2.show();  // Faculty class
        user2.login(); // User logged in

        User akash=new Akash();
        akash.show();  // Akash from Student class
        user1.login(); // User logged in




    }
}



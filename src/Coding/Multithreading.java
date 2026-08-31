package Coding;

class Shape implements Runnable{

    private final int start;
    private final int end;

    Shape(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for(int i=start;i<=end;i++){
            System.out.println(Thread.currentThread().getName()+" " + i);
        }
    }
}

public class Multithreading {
    public static void main(String[] args) {

        Shape shape=new Shape(1,100);
        Thread thread1=new Thread(new Shape(1,50),"Thread1");
        Thread thread2=new Thread(new Shape(51,100),"Thread2");

        thread1.start();
        thread2.start();





    }
}

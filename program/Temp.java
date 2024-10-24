package program;

public class Temp {

    public static void main(String[] str)
    {
        System.out.println(Thread.currentThread());
        Runnable run1 = () -> System.out.println("Thread 1 running");
        Thread t1 = new Thread(run1);
        t1.start();
        System.out.println(Thread.currentThread());

        Thread t2 = new Thread(() -> System.out.println("Thread 2 running"));
        t2.start();
        System.out.println(Thread.currentThread());
    }
}

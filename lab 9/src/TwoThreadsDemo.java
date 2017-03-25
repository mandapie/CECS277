/**
 * Created by amanda on 4/13/2016.
 */
public class TwoThreadsDemo{
    public static void main (String[] args) {
        Runnable print1 = new SimpleThread("CECS 277");
        Runnable print2 = new SimpleThread("OOP in Java");
        Thread t1 = new Thread(print1);
        Thread t2 = new Thread(print2);
        t1.start();
        t2.start();
    }
}

/**
 * Created by amanda on 4/13/2016.
 */
import java.util.*;
public class SimpleThread implements Runnable{
    private String words;
    SimpleThread(String s){
        words = s;
    }
    public void run(){
        for (int i = 0; i< 11; i++) {
            if (i == 10)
                System.out.println("DONE!" + words);
            else
                System.out.println(i + " " + words);
        }
        try {
            Thread.sleep((int)(Math.random() * 1000));
        }
        catch (InterruptedException e)
        {
        }
    }
}

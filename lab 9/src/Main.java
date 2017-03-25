/**
 * Created by amanda on 4/13/2016.
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main {
    public static void main(String args[]){
        ExecutorService es = Executors.newFixedThreadPool(2);
        for(int i = 0; i<4; i++) {
            es.execute(new TaskThread(i));
        }
    }
}

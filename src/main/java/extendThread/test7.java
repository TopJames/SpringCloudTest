package extendThread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/3/6.
 */
public class test7 {


    public static void main(String[] args) throws Exception {
        Callable<String> call=() -> {
            System.out.println("start..");
            Thread.sleep(3000);
            System.out.println("end..");
            return "result";
        };

        FutureTask<String> task=new FutureTask<String>(call);
        Thread t=new Thread(task);
        t.start();
        try{
            System.out.println(task.get(1, TimeUnit.SECONDS));
        }catch (java.util.concurrent.TimeoutException e){
            System.out.println("time out!");
            
        }

        Thread.sleep(3000);

        System.out.println(task.get());
    }
}

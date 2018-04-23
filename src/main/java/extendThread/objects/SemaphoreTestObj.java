package extendThread.objects;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/4/18.
 */
public class SemaphoreTestObj {
    private Semaphore sp=new Semaphore(3);
    private ReentrantLock rl=new ReentrantLock();

    public void execute(){
        try {
            sp.acquire();
            System.out.println("Thread:" + Thread.currentThread().getName() + ",on action..");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            sp.release();
        }
    }

    public void execute2(){
        try {
            rl.lock();
            System.out.println("Thread:" + Thread.currentThread().getName() + ",on action..");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            rl.unlock();
        }
    }
}

package extendThread;

import extendThread.objects.SemaphoreTestObj;

/**
 * Created by Administrator on 2018/4/18.
 */
public class Test14 {

    public static void main(String[] args) {
        SemaphoreTestObj sto=new SemaphoreTestObj();
        Thread t1=new Thread(()->{
                sto.execute2();
        },"t1");
        Thread t2=new Thread(()->{
            sto.execute2();
        },"t2");
        Thread t3=new Thread(()->{
            sto.execute2();
        },"t3");
        Thread t4=new Thread(()->{
            sto.execute2();
        },"t4");
        Thread t5=new Thread(()->{
            sto.execute2();
        },"t5");
        Thread t6=new Thread(()->{
            sto.execute2();
        },"t6");
        Thread t7=new Thread(()->{
            sto.execute2();
        },"t7");
        Thread t8=new Thread(()->{
            sto.execute2();
        },"t8");
        Thread t9=new Thread(()->{
            sto.execute2();
        },"t9");
        Thread t10=new Thread(()->{
            sto.execute2();
        },"t10");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();


    }
}

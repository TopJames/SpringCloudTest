package extendThread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2018/3/8.
 */
public class test11 {
    public static void main(String[] args) throws Exception {
//        Field field=Unsafe.class.getDeclaredField("theUnsafe");
//        field.setAccessible(true);
//
//        Unsafe uf=(Unsafe)field.get(null);
//
//        long valueOffset=uf.objectFieldOffset(AtomicInteger.class.getDeclaredField("value"));
//        System.out.println(valueOffset);
//        AtomicInteger ai=new AtomicInteger(1);
//
//        int result=uf.getAndAddInt(ai,valueOffset,3);
//        System.out.println("getIntVolatile:"+uf.getIntVolatile(ai,valueOffset));
//        int result2=uf.getAndAddInt(ai, valueOffset, 3);
//        System.out.println("getIntVolatile:"+uf.getIntVolatile(ai,valueOffset));
//        System.out.println("result："+result+",result2:"+result2);

        test11 t11=new test11();
        int val=0;
        CountDownLatch cdl=new CountDownLatch(1);

//        new Thread(()->{
//            for(;t11.value<10000;t11.value++){
//                System.out.println(t11.value);
//            }
//        }).start();

        new Thread(()->{
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i=0;i<100;i++){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
             //   t11.value++;
                t11.addAndGet(1);
                System.out.println(t11.value);
            }
        }).start();

        new Thread(()->{
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i=0;i<100;i++){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //   t11.value++;
                t11.addAndGet(1);
                System.out.println(t11.value);
            }
        }).start();

        new Thread(()->{
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i=0;i<100;i++){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //   t11.value++;
                t11.addAndGet(1);
                System.out.println(t11.value);
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        cdl.countDown();
        System.out.println("wait....");
        TimeUnit.SECONDS.sleep(30);
        System.out.println("result:"+t11.value);

    }

    private static Unsafe uf;

    volatile int value;

     static{
         try {
             Field field = Unsafe.class.getDeclaredField("theUnsafe");
             field.setAccessible(true);
             uf=(Unsafe)field.get(null);
         } catch (Exception e) {
             e.printStackTrace();
         }
     }

    public void add(){
        value=value+1;
    }

    public int addAndGet(int val){
        long offSet= 0;
        try {
            offSet = uf.objectFieldOffset(this.getClass().getDeclaredField("value"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        int nextVal;
        while(true){
            int currentVal=uf.getIntVolatile(this,offSet);
            nextVal=currentVal+val;

            if(uf.compareAndSwapInt(this,offSet,currentVal,nextVal)){
                break;
            }
        }
        return nextVal;
    }


}

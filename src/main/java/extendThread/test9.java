package extendThread;

/**
 * Created by Administrator on 2018/3/6.
 */
public class test9 {

    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            int count=0;
            while(true){
                boolean b=Thread.interrupted();
                System.out.println("interrupted:"+b+",count:"+count);
                if(b){
                    System.out.println("after interrupted:"+Thread.interrupted());
                    count++;
                    if(count==2) break;
                }
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    System.out.println("interrupted while sleep.");
//                    break;
//                }
            }
        });
        t1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("stop!");
        t1.interrupt();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("stop 2nd!");
        t1.interrupt();
    }
}

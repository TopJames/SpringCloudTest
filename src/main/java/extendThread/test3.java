package extendThread;

/**
 * Created by Administrator on 2018/3/2.
 */
public class test3 {

    public static void main(String[] args) {
        test3 t=new test3();
        run r=t.new run();
        new Thread(() -> r.task1()).start();
        new Thread(() -> r.task2()).start();
        new Thread(() -> r.task3()).start();
    }


    public class run{

        void task1(){
            synchronized (this){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("heihei1~");
            }
        }
        void task2(){
            synchronized (this){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("heihei2~");
            }
        }
        void task3(){
            synchronized (this){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("heihei3~");
            }
        }
    }

}

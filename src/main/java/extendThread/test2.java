package extendThread;


import com.ayu.common.utils.ThreadExt;
import com.ayu.common.utils.ThreadExtend;
import com.weibo.api.motan.rpc.DefaultResponse;

import java.lang.reflect.Method;

public class test2
{
    public static void main ( String[] args ) throws Exception
    {

        ThreadExtend.init(1);

        ThreadExtend.TaskGroup tg=new ThreadExtend.TaskGroup("1");
        System.out.println("start....");

        ThreadExtend.Task t1=new ThreadExtend.Task(tg,String.valueOf(1));
        ThreadExtend.Task t2=new ThreadExtend.Task(tg,String.valueOf(2));
        ThreadExtend.Task t3=new ThreadExtend.Task(tg,String.valueOf(3));
        ThreadExtend.Task t4=new ThreadExtend.Task(tg,String.valueOf(4));
        ThreadExtend.Task t5=new ThreadExtend.Task(tg,String.valueOf(5));
        ThreadExtend.Task t6=new ThreadExtend.Task(tg,String.valueOf(6));

        t1.setInst(new ThreadExtend.Runnabled() {
            @Override
            public Object run() {
                String name="task"+1;
                System.out.println(name+" start:");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(name+" end:" );
                return 1;
            }
        });
        t2.setInst(new ThreadExtend.Runnabled() {
            @Override
            public Object run() {
                String name="task"+2;
                System.out.println(name+" start:");
                try {
                    Thread.sleep(1000);
                    this.interrupt(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name+" end:" );
                return 2;
            }
        });
        t3.setInst(new ThreadExtend.Runnabled() {
            @Override
            public Object run() {
                String name = "task" + 3;
                System.out.println(name + " start:");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + " end:");
                return 3;
            }
        });
        t4.setInst(new ThreadExtend.Runnabled() {
            @Override
            public Object run() {
                String name = "task" + 4;
                System.out.println(name + " start:");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + " end:");
                return 4;
            }
        });
        t5.setInst(new ThreadExtend.Runnabled() {
            @Override
            public Object run() {
                String name = "task" + 5;
                System.out.println(name + " start:");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + " end:");
                return 5;
            }
        });
        t6.setInst(new ThreadExtend.Runnabled() {
            @Override
            public Object run() {
                String name = "task" + 6;
                System.out.println(name + " start:");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + " end:");
                return 6;
            }
        });
        tg.addTask(t1);tg.addTask(t2);//tg.addTask(t3);
      //  tg.addTask(t4);tg.addTask(t5);tg.addTask(t6);

        ThreadExtend.execAsync(tg);

        System.out.println("end....");

    }
}
package extendThread;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by Administrator on 2018/3/6.
 */
public class test8 {

    public static void main(String[] args) {

        test8 t8=new test8();
        Inner i=t8.new Inner();
        i.run();
     //  i.run3();
    }


    class Inner{

        public void run(){
            System.out.println("run");
            run1();
        }

        public void run1(){
            System.out.println("run1");
            run2();
        }
        public void run2(){
            System.out.println("run2");
            run3();
        }
        public void run3(){

            System.out.println("run3");
            Exception e=new Exception();
            StringWriter sw=new StringWriter();
            PrintWriter pw=new PrintWriter(sw,true);
            e.printStackTrace(pw);
            e.printStackTrace();
            int stackSize=sw.getBuffer().toString().split("\n").length;
            System.out.println("size:"+stackSize);
        }
    }


}

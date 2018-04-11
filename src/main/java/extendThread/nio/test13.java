package extendThread.nio;

import extendThread.extended.Father;

/**
 * Created by Administrator on 2018/3/23.
 */
public class test13 extends Father {

    public  void dd(){
        System.out.println("this is son dd");
    }

    public static void main(String[] args) {
        test13 t13=new test13();
        t13.kk();
    }
}

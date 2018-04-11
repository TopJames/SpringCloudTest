package extendThread;

import extendThread.extended.Father;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Administrator on 2018/3/23.
 */
public class test12 extends Father{

    public void kk(){
        System.out.println("this is son kk");
    }

    public static void main(String[] args) {
        test12 t12=new test12();

        LinkedList list=new LinkedList<>();
        list.add(0,"s");
        list.add("aa");
//        Iterator it=list.iterator();
//        it.next();
//        it.remove();



    }
}

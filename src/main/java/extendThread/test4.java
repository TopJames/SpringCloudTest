package extendThread;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Administrator on 2018/3/2.
 */
public class test4 {
    public static void main(String[] args) {
        LinkedBlockingDeque<String> q=new LinkedBlockingDeque<>();
        System.out.println(q.isEmpty());
        q.offer("ss");
        System.out.println(q.isEmpty());
    }
}

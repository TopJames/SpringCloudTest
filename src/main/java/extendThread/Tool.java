package extendThread;

/**
 * Created by Administrator on 2018/3/2.
 */
public class Tool {

    public String getInfo(String info) throws Exception{
        System.out.println("acquired info:"+info);
        Thread.sleep(3000);
        System.out.println("end info:" + info);
        return info+",this is info.";
    }
}

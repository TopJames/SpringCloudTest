package extendThread;


import com.ayu.common.utils.ThreadExtend;
import com.weibo.api.motan.rpc.DefaultResponse;

import java.lang.reflect.Method;

public class test1
{
    public static void main ( String[] args ) throws Exception
    {

        Tool tool=new Tool();
        Class clazz=tool.getClass();
        Method m=clazz.getDeclaredMethod("getInfo", String.class);
        String groupId="11111111111";
        ThreadExtend.init(1);
        System.out.println("start....");
        Thread.sleep(3000);
//        ThreadExtend.appendTask(groupId, tool, m, null, new Object[]{"f*ck~"});

        ThreadExtend.TaskGroupCallback callback= new ThreadExtend.TaskGroupCallback(){

            @Override
            public Object call(Object result) {
                DefaultResponse response;
                if (!(result instanceof DefaultResponse)) {
                    response = new DefaultResponse(result);
                } else {
                    response = (DefaultResponse) result;
                }
                response.setAttachment("result","this is result.");
                System.out.println("call end.response:"+response.toString());
                return "call end.";
            }
        };

        ThreadExtend.execAsync(groupId, tool, m, callback, new Object[]{"f*ck~1"});
        ThreadExtend.execAsync(groupId, tool, m, callback, new Object[]{"f*ck~2"});
        ThreadExtend.execAsync(groupId, tool, m, callback, new Object[]{"f*ck~3"});
        ThreadExtend.execAsync(groupId, tool, m, callback, new Object[]{"f*ck~4"});
        ThreadExtend.execAsync(groupId, tool, m, callback, new Object[]{"f*ck~5"});
        ThreadExtend.execAsync(groupId, tool, m, callback, new Object[]{"f*ck~6"});
        System.out.println("end....");

    }
}
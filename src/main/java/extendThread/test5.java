package extendThread;


import com.ayu.common.utils.ThreadExtend;
import com.weibo.api.motan.rpc.DefaultResponse;

import java.lang.reflect.Method;

public class test5
{
    public static void main ( String[] args ) throws Exception
    {

        ThreadExtend.init(1);
        System.out.println("start....");
        for (int i=0;i<5;i++){
            Tool tool=new Tool();
            Class clazz=Tool.class;
            Method m=clazz.getDeclaredMethod("getInfo", String.class);
            String groupId=String.valueOf(i);
            ThreadExtend.TaskGroupCallback callback= (Object result) -> {
                DefaultResponse response;
                if (!(result instanceof DefaultResponse)) {
                    response = new DefaultResponse(result);
                } else {
                    response = (DefaultResponse) result;
                }
                response.setAttachment("result","this is result.");
                System.out.println("call end.response:"+response.toString());
                return "call end.";
            };
            ThreadExtend.TaskSplix spLix=new ThreadExtend.TaskSplixWapper(tool,m);
            ((ThreadExtend.TaskSplixWapper)spLix).setSync(false);
            ThreadExtend.TaskGroup tg=spLix.getTaskGroup(m.getName(),new Object[]{"f*ck~"+groupId});
            tg.setCallback(callback);
            tg.setGroupId(groupId);
            ThreadExtend.execAsync(tg);
//            ThreadExtend.appendTask(groupId,tool,m,callback,new Object[]{"f*ck~"+groupId});
        }

        System.out.println("end....");

    }
}
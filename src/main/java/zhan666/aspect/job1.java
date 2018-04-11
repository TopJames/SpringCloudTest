package zhan666.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import zhan666.annotation.stupid;

/**
 * Created by Administrator on 2018/2/28.
 */
@Aspect
@Component
public class job1 {

    @Before("@annotation(stupidtest)")
    public void before(JoinPoint point, stupid stupidtest){
        System.out.println("kind:" + point.getKind()+",Signature:"+point.getSignature().getName());
        System.out.println("before!"+stupidtest.howStupid());
    }

    @After("@annotation(stupidtest)")
    public void after(JoinPoint point, stupid stupidtest){
        System.out.println("after!"+stupidtest.howStupid());
    }


    @Around("@annotation(zhan666.annotation.Clever)")
    public Object around(ProceedingJoinPoint jp){
        System.out.println("round round ~~~");
        Object obj=null;
        try {
            obj=jp.proceed();
            System.out.println("proceed result:"+obj);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }

}

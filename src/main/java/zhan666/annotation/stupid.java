package zhan666.annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2018/2/28.
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.METHOD})
public @interface stupid {

    String howStupid() default "very";


}

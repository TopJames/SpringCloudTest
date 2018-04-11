package zhan666;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class HelloApp
{



    public static void main( String[] args )
    {

        SpringApplication sa=new SpringApplication(HelloApp.class);
        sa.run(args);
        System.out.println( "Hello World!" );
    }
}

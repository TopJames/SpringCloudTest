package zhan666.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zhan666.service.User;

@Configuration
public class config1 {

    @Bean
    public User user(){
        return new User();
    }
}

package top.wxy.userservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import top.wxy.userservice1.config.WxyProperties;

/**
 * @author 笼中雀
 */
@SpringBootApplication
@EnableConfigurationProperties(WxyProperties.class)
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}

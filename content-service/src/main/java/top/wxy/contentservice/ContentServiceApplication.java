package top.wxy.contentservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import top.wxy.contentservice.handler.SentinelConfig;

/**
 * @author 笼中雀
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "top.wxy.contentservice.client")
@Import({SentinelConfig.class})
public class ContentServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContentServiceApplication.class, args);
    }
}

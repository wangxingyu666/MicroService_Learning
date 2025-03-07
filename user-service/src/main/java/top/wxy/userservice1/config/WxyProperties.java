package top.wxy.userservice1.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 笼中雀
 */
@Component
@ConfigurationProperties(prefix = "wxy")
@Data
public class WxyProperties {
    private String username;
    private String job;
    private boolean serviceFlag;
}

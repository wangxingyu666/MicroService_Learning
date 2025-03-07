package top.wxy.aiservice2.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;

/**
 * @author 笼中雀
 */
@Component
@ConfigurationProperties(prefix = "deepseek")
@Data
public class DeepSeekProperties {
    private String apiKey;
    private String apiUrl;
}
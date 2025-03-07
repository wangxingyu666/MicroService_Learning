package top.wxy.aiservice2.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;

/**
 * @author 笼中雀
 */
@Component
@ConfigurationProperties(prefix = "oss")
@Data
public class OssProperties {
    private String endpoint;
    private String accessKey;
    private String secretKey;
    private String bucketName;
}
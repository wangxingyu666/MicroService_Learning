package top.wxy.aiservice2.controller;

import jakarta.annotation.Resource;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wxy.aiservice2.config.DeepSeekProperties;
import top.wxy.aiservice2.config.OssProperties;
import top.wxy.aiservice2.config.RedisProperties;

/**
 * @author 笼中雀
 */
@RestController
@RefreshScope
public class TestController {

    @Resource
    private RedisProperties redisProperties;

    @Resource
    private OssProperties ossProperties;

    @Resource
    private DeepSeekProperties deepSeekProperties;

    @Resource
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/test")
    public String testConfig() {
        // 读取 Redis 配置
        String redisConfig = String.format("Redis Config: %s:%d, DB: %d", redisProperties.getHost(), redisProperties.getPort(), redisProperties.getDatabase());

        // 读取 OSS 配置
        String ossConfig = String.format("OSS Config: Endpoint=%s, Bucket=%s", ossProperties.getEndpoint(), ossProperties.getBucketName());

        // 读取 DeepSeek 配置
        String deepSeekConfig = String.format("DeepSeek Config: API Key=%s, API URL=%s", deepSeekProperties.getApiKey(), deepSeekProperties.getApiUrl());

        // 将配置写入数据库
        jdbcTemplate.update("INSERT INTO config_log (config_type, config_value) VALUES (?, ?)", "Redis", redisConfig);
        jdbcTemplate.update("INSERT INTO config_log (config_type, config_value) VALUES (?, ?)", "OSS", ossConfig);
        jdbcTemplate.update("INSERT INTO config_log (config_type, config_value) VALUES (?, ?)", "DeepSeek", deepSeekConfig);

        return redisConfig + "\n" + ossConfig + "\n" + deepSeekConfig;
    }
}
package top.wxy.userservice1.controller;

import jakarta.annotation.Resource;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wxy.userservice1.config.WxyProperties;

/**
 * @author 笼中雀
 */
@RestController
@RefreshScope
public class TestController {
//    @Value("${wxy.username}")
//    private String username;
//
//    @Value("${wxy.job}")
//    private String job;
    @Resource
    private WxyProperties wxyProperties;

    @GetMapping("/test")
    public String get(){
        return "读取到配置中心的值:"+wxyProperties.getUsername()+" "+wxyProperties.getJob();
    }
}

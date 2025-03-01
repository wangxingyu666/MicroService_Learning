package top.wxy.helloservice.controller;


import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.wxy.helloservice.service.HelloService;

/**
 * @author 笼中雀
 */
@RestController
public class HelloController {
    @Resource
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello(){
        return "hello from "+helloService.getName();
    }

    @GetMapping("/sayHello")
    public String sayHello(@RequestParam String name){
        return helloService.sayHello(name);
    }
}

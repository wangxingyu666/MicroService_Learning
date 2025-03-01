package top.wxy.helloservice.service;


import org.springframework.stereotype.Service;

/**
 * @author 笼中雀
 */
@Service
public class HelloService {
    public String getName(){
        return "hello service";
    }

    public String sayHello(String name){
        return  "hello "+name;
    }
}

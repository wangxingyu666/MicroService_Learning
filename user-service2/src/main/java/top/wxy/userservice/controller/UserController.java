package top.wxy.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 笼中雀
 */
@RestController
public class UserController {

    @GetMapping("/user")
    public String getUser(@RequestParam String username){
        return "User: "+username;
    }
}

package top.wxy.userservice1.controller;


import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wxy.userservice1.config.WxyProperties;
import top.wxy.userservice1.entity.User;
import top.wxy.userservice1.service.UserService;

/**
 * @author 笼中雀
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private WxyProperties wxyProperties;


    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        if (wxyProperties.isServiceFlag()){
            return userService.getById(id);
        }else {
            throw new RuntimeException("Service is under maintenance");
        }
    }
}
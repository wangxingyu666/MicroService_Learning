package top.wxy.contentservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.wxy.contentservice.vo.UserVo;

/**
 * @author 笼中雀
 */
@FeignClient(name = "user-service1")
public interface UserServiceClient {

    @GetMapping("/user/{id}")
    UserVo getUserById(@PathVariable Integer id);
}
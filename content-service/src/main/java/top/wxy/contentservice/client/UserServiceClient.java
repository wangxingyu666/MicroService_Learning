package top.wxy.contentservice.client;

import com.alibaba.nacos.api.model.v2.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.wxy.contentservice.vo.UserVo;

/**
 * @author 笼中雀
 */
@FeignClient(name = "user-service",fallbackFactory = UserServiceFallBackFactory.class)
public interface UserServiceClient {

    @GetMapping("/user/{id}")
    Result<UserVo> getUserById(@PathVariable int id);
}
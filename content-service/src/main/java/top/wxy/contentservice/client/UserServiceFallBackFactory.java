package top.wxy.contentservice.client;

import com.alibaba.nacos.api.model.v2.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import top.wxy.contentservice.vo.UserVo;

/**
 * @author 笼中雀
 */
@Component
@Slf4j
public class UserServiceFallBackFactory implements FallbackFactory<UserServiceClient> {
    @Override
    public UserServiceClient create(Throwable cause) {
        log.error("用户服务调用异常:",cause);
        return new UserServiceClient() {
            @Override
            public Result<UserVo> getUserById(int id) {
                UserVo userVo=new UserVo();
                userVo.setId(-1);
                userVo.setUserName("异常的用户名");
                userVo.setAvatarUrl("https://my-wxy-bucket.oss-cn-nanjing.aliyuncs.com/picture/liang.jpg");
                return Result.success(userVo);
            }
        };
    }
}

package top.wxy.userservice1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.wxy.userservice1.entity.User;
/**
 * @author 笼中雀
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}

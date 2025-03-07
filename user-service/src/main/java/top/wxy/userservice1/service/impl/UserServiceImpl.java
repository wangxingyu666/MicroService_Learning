package top.wxy.userservice1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.wxy.userservice1.entity.User;
import top.wxy.userservice1.mapper.UserMapper;
import top.wxy.userservice1.service.UserService;

/**
 * @author 笼中雀
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
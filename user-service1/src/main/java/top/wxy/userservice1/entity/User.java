package top.wxy.userservice1.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author 笼中雀
 */
@Data
@TableName("t_user")
public class User {
    private Integer id;
    private String mobile;
    private String password;
    private String userName;
    private String avatarUrl;
    private Date createTime;
    private Date updateTime;
}
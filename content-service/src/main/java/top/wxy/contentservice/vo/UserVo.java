package top.wxy.contentservice.vo;

import lombok.Data;

@Data
public class UserVo {
    private Integer id;
    private String userName;
    private String avatarUrl;
    private String mobile;
    private String createTime;
    private String updateTime;
}
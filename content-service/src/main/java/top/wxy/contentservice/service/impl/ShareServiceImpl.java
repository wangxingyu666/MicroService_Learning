package top.wxy.contentservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.wxy.contentservice.entity.Share;
import top.wxy.contentservice.mapper.ShareMapper;
import top.wxy.contentservice.service.ShareService;

/**
 * @author 笼中雀
 */
@Service
public class ShareServiceImpl extends ServiceImpl<ShareMapper, Share> implements ShareService {
}
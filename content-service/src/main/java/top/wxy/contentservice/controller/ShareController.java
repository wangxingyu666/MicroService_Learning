package top.wxy.contentservice.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wxy.contentservice.entity.Share;
import top.wxy.contentservice.service.ShareService;
import top.wxy.contentservice.client.UserServiceClient;
import top.wxy.contentservice.vo.ShareVo;
import top.wxy.contentservice.vo.UserVo;

/**
 * @author 笼中雀
 */
@RestController
@RequestMapping("/share")
public class ShareController {

    @Autowired
    private ShareService shareService;

    @Autowired
    private UserServiceClient userServiceClient;

    @GetMapping("/{id}")
    public ShareVo getShareById(@PathVariable Integer id) {
        Share share = shareService.getById(id);

        UserVo userVo = userServiceClient.getUserById(share.getUserId());

        ShareVo shareVO = new ShareVo();
        shareVO.setId(share.getId());
        shareVO.setTitle(share.getTitle());
        shareVO.setCreateTime(share.getCreateTime().toString());
        shareVO.setUpdateTime(share.getUpdateTime().toString());
        shareVO.setIsOriginal(share.getIsOriginal());
        shareVO.setAuthor(share.getAuthor());
        shareVO.setCover(share.getCover());
        shareVO.setSummary(share.getSummary());
        shareVO.setPrice(share.getPrice());
        shareVO.setDownloadUrl(share.getDownloadUrl());
        shareVO.setBuyCount(share.getBuyCount());
        shareVO.setShowFlag(share.getShowFlag());
        shareVO.setAuditStatus(share.getAuditStatus());
        shareVO.setReason(share.getReason());
        shareVO.setAuthorInfo(userVo);

        return shareVO;
    }
}
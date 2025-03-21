package top.wxy.gatewayservice.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.HashMap;
import java.util.Map;


/**
 * @author 笼中雀
 */
@Slf4j
@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
        // 调用父类方法获取原始错误信息
        Throwable error = super.getError(request);
        // 记录异常日志，方便排查问题
        log.error("网关处理异常", error);
        // 创建一个 Map 用于封装自定义错误信息
        Map<String, Object> errorMap = new HashMap<>();
        // 设置错误消息为异常的详细信息
        errorMap.put("code", HttpStatus.BAD_REQUEST.value());
        errorMap.put("msg", error.getMessage());
        return errorMap;
    }
}

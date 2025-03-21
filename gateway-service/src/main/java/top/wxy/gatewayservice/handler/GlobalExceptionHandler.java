package top.wxy.gatewayservice.handler;

import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author 笼中雀
 */
//@Component
@Order(-2)
public class GlobalExceptionHandler extends AbstractErrorWebExceptionHandler {

    public GlobalExceptionHandler(GlobalErrorAttributes gea, ApplicationContext applicationContext,
                                  ServerCodecConfigurer serverCodecConfigurer) {
        // 调用父类构造函数
        super(gea, new WebProperties.Resources(), applicationContext);
        // 设置响应消息的编码器
        super.setMessageWriters(serverCodecConfigurer.getWriters());
        // 设置请求消息的解码器
        super.setMessageReaders(serverCodecConfigurer.getReaders());
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(final ErrorAttributes errorAttributes) {
        // 将所有请求映射到 renderErrorResponse 方法
        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
    }


    private Mono<ServerResponse> renderErrorResponse(final ServerRequest request) {
        // 获取错误属性
        final Map<String, Object> errorPropertiesMap = getErrorAttributes(request, ErrorAttributeOptions.defaults());
        // 构建错误响应
        return ServerResponse.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(errorPropertiesMap));
    }
}

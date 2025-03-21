package top.wxy.findnamegatewayservice.predicate;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author 笼中雀
 */
@Component
public class TimeRangeRoutePredicateFactory extends AbstractRoutePredicateFactory<TimeRangeRoutePredicateFactory.Config> {

    public TimeRangeRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("startTime", "endTime");
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return exchange -> {
            ZoneId zone = ZoneId.of("Asia/Shanghai");
            LocalTime now = LocalTime.now(zone);
            return !now.isBefore(config.startTime) && !now.isAfter(config.endTime);
        };
    }

    @Data
    @NoArgsConstructor
    public static class Config {
        @DateTimeFormat(pattern = "HH:mm")
        private LocalTime startTime;

        @DateTimeFormat(pattern = "HH:mm")
        private LocalTime endTime;
    }
}
package top.wxy.findnameservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author 笼中雀
 */
@RestController
@RequestMapping("/surname")
public class FindNameController {

    @Value("${tianapi.key}")
    private String apiKey;

    @Value("${tianapi.url}")
    private String apiUrl;

    private final WebClient webClient = WebClient.builder()
            .defaultHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
            .build();

    @GetMapping("/origin")
    public String getOrigin(@RequestParam String xing) {
        // 直接使用未编码的参数
        String requestUrl = apiUrl + "?key=" + apiKey + "&xing=" + xing;

        System.out.println("Request URL: " + requestUrl);

        return webClient.get()
                .uri(requestUrl)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
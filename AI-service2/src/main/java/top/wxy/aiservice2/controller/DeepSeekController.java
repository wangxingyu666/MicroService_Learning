package top.wxy.aiservice2.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.wxy.aiservice2.config.DeepSeekProperties;

@RestController
public class DeepSeekController {

    private static final Logger logger = LoggerFactory.getLogger(DeepSeekController.class);

    @Autowired
    private DeepSeekProperties deepSeekProperties;

    @GetMapping("/deepseek")
    public String callDeepSeek(@RequestParam String question) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + deepSeekProperties.getApiKey());
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);

        String requestBody = "{\n" +
                "  \"model\": \"deepseek-chat\",\n" +
                "  \"messages\": [\n" +
                "    {\n" +
                "      \"role\": \"user\",\n" +
                "      \"content\": \"" + question + "\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        // 创建 HttpEntity，包含请求头和请求体
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    deepSeekProperties.getApiUrl(),
                    HttpMethod.POST,
                    entity,
                    String.class
            );

            // 记录完整的 API 响应
            logger.info("DeepSeek API Response: {}", response.getBody());

            // 从响应中提取 content
            String responseBody = response.getBody();
            String answer = extractContentFromResponse(responseBody);

            return "DeepSeek API Answer: " + answer;
        } catch (Exception e) {
            logger.error("Failed to call DeepSeek API", e);
            return "Error: " + e.getMessage();
        }
    }

    // 提取 API 响应中的 content 部分
    private String extractContentFromResponse(String responseBody) {
        try {
            // 使用 JSON 解析工具（例如 Jackson）解析响应体
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(responseBody);
            JsonNode messageNode = rootNode.path("choices").get(0).path("message").path("content");
            return messageNode.asText();
        } catch (Exception e) {
            logger.error("Failed to extract content from response", e);
            return "Error extracting content";
        }
    }

}
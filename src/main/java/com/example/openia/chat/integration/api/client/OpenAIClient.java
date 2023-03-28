package com.example.openia.chat.integration.api.client;

import com.example.openia.chat.integration.api.DTO.request.ChatGPTRequest;
import com.example.openia.chat.integration.api.DTO.response.ChatGPTResponse;
import com.example.openia.chat.integration.api.config.OpenAIClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "openai-service",
        url = "${openai-service.urls.base-url}",
        configuration = OpenAIClientConfig.class
)
public interface OpenAIClient {

    @PostMapping(value = "${openai-service.urls.chat-url}", headers = {"Content-Type=application/json"})
    ChatGPTResponse chat(@RequestBody ChatGPTRequest chatGPTRequest);

}

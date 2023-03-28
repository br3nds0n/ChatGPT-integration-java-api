package com.example.openia.chat.integration.api.controller;

import com.example.openia.chat.integration.api.DTO.request.ChatRequest;
import com.example.openia.chat.integration.api.DTO.response.ChatGPTResponse;
import com.example.openia.chat.integration.api.service.OpenAIClientService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/chat")
public class OpenAIClientController {

    private final OpenAIClientService openAIClientService;

    public OpenAIClientController(OpenAIClientService openAIClientService) {
        this.openAIClientService = openAIClientService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ChatGPTResponse chat(@RequestBody ChatRequest chatRequest){
        return openAIClientService.chat(chatRequest);
    }
}

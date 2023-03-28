package com.example.openia.chat.integration.api.service.impl;

import com.example.openia.chat.integration.api.DTO.request.ChatGPTRequest;
import com.example.openia.chat.integration.api.DTO.request.ChatRequest;
import com.example.openia.chat.integration.api.DTO.request.Message;
import com.example.openia.chat.integration.api.DTO.response.ChatGPTResponse;
import com.example.openia.chat.integration.api.client.OpenAIClient;
import com.example.openia.chat.integration.api.config.OpenAIClientConfig;
import com.example.openia.chat.integration.api.service.OpenAIClientService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class OpenAIClientImpl implements OpenAIClientService {

    private final OpenAIClient openAIClient;
    private final OpenAIClientConfig openAIClientConfig;

    private static final String ROLE_USER = "user";

    public OpenAIClientImpl(OpenAIClient openAIClient, OpenAIClientConfig openAIClientConfig) {
        this.openAIClient = openAIClient;
        this.openAIClientConfig = openAIClientConfig;
    }

    @Override
    public ChatGPTResponse chat(ChatRequest chatRequest) {
        Message message = Message.builder()
                .role(ROLE_USER)
                .content(chatRequest.getQuestion())
                .build();
        ChatGPTRequest chatGPTRequest = ChatGPTRequest.builder()
                .model(openAIClientConfig.getModel())
                .messages(Collections.singletonList(message))
                .build();
        return openAIClient.chat(chatGPTRequest);
    }
}

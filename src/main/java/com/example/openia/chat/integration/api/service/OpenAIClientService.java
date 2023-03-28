package com.example.openia.chat.integration.api.service;

import com.example.openia.chat.integration.api.DTO.request.ChatRequest;
import com.example.openia.chat.integration.api.DTO.response.ChatGPTResponse;

public interface OpenAIClientService {

    ChatGPTResponse chat(ChatRequest chatRequest);
}

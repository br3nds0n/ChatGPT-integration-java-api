package com.example.openia.chat.integration.api.DTO.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChatRequest implements Serializable {
    private String question;
}
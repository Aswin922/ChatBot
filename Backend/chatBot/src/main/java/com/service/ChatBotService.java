package com.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.dto.ChatBotRequest;
import com.dto.ChatBotResponse;
import com.dto.PromptDTO;

import java.util.List;

@Service
public class ChatBotService {

    private RestClient restClient;

    @Value("${openai.api.key}")
    private String apiKey;

    @Value("${openai.api.model}")
    private String model;

    public void ChatGPTService(RestClient restClient) {
        this.restClient = restClient;
    }

    public String getChatResponse(PromptDTO userInput) {
        ChatBotRequest request = new ChatBotRequest(
                model,
                List.of(new ChatBotRequest.Message("user", userInput.prompt()))
        );

        ChatBotResponse response = restClient.post()
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .body(request)
                .retrieve()
                .body(ChatBotResponse.class);

        return response.choices().get(0).message().content();
    }
}
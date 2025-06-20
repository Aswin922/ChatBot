package com.dto;

import java.util.List;

public record ChatBotResponse(List<Choice> choices) {
    public static record Choice(Message message) {
        public static record Message(String role, String content) {}
    }
}
package com.dto;

import java.util.List;

public record ChatBotRequest(String model, List<Message> messages) {
    public static record Message(String role, String content) {}
}

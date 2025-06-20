package com.controller;

import org.springframework.web.bind.annotation.*;
import com.dto.PromptDTO;
import com.service.ChatBotService;

@CrossOrigin(
	    origins = "http://localhost:3000",
	    allowedHeaders = "*",
	    methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS}
	)
@RestController
@RequestMapping("/api/chat")
public class ChatBotController {
    private final ChatBotService chatBotService;

    public ChatBotController(ChatBotService chatBotService) {
        this.chatBotService = chatBotService;
    }

    @PostMapping
    public String chat(@RequestBody PromptDTO userInput) {
        return chatBotService.getChatResponse(userInput);
    }
}

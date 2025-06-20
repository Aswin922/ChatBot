package com.dto;

public record PromptDTO(String prompt) {

	public String prompt() {
		return prompt;
	}
	
}
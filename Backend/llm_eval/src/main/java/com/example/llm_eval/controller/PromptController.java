package com.example.llm_eval.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.llm_eval.model.Prompt;
import com.example.llm_eval.service.PromptService;

@RestController
@RequestMapping("/api/prompts")
public class PromptController {

    private final PromptService promptService;

    public PromptController(PromptService promptService) {
        this.promptService = promptService;
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody String text) {
        Prompt prompt = promptService.createPrompt(text);
        return ResponseEntity.ok(prompt.getId());
    }
}
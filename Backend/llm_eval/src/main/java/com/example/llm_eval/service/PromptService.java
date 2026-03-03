package com.example.llm_eval.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.llm_eval.model.LlmResponse;
import com.example.llm_eval.model.Prompt;
import com.example.llm_eval.repository.PromptRepository;
import com.example.llm_eval.repository.ResponseRepository;
import com.example.llm_eval.service.llm.LlmClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PromptService {

    private final PromptRepository promptRepo;
    private final ResponseRepository responseRepo;
    private final List<LlmClient> llmClients;

    public Prompt createPrompt(String text) {
        Prompt prompt = new Prompt();
        prompt.setText(text);
        promptRepo.save(prompt);

        for (LlmClient client : llmClients) {
            LlmResponse r = new LlmResponse();
            r.setPrompt(prompt);
            r.setContent(client.generateResponse(text));
            r.setModelName(client.modelname());
            responseRepo.save(r);
        }

        return prompt;
    }
}
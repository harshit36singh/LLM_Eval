package com.example.llm_eval.service.llm;

public interface LlmClient {

    String generateResponse(String prompt);
    String modelname();
}
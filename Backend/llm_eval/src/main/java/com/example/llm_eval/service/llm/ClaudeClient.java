package com.example.llm_eval.service.llm;

public class ClaudeClient implements LlmClient{

    @Override
    public String generateResponse(String prompt) {
      return "Response for : "+prompt;
    }

    @Override
    public String modelname() {
      return "claude generated response .";
    }

    
}
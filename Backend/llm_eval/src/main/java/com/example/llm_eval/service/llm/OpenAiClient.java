package com.example.llm_eval.service.llm;

public class OpenAiClient implements LlmClient {

    @Override
    public String generateResponse(String prompt) {
      return "Response for : "+ prompt;    }

    @Override
    public String modelname() {
    return "gpt-api called here .";
    }

    
}
package com.example.llm_eval.dto;

public record EvaluationRequestDto(
    Long responseId,
    int accuracy,
    int relevance,
    int clarity,
    String rationale
) {}
package com.example.llm_eval.service;

import org.springframework.stereotype.Service;

import com.example.llm_eval.model.Evaluation;

@Service
public class RationaleService {

    public String generate(Evaluation e) {
        return String.format(
            "Ranked based on accuracy=%d, relevance=%d, clarity=%d. " +
            "Accuracy weighted highest to prioritize factual correctness.",
            e.getAccuracy(),
            e.getRelevance(),
            e.getClarity()
        );
    }
}

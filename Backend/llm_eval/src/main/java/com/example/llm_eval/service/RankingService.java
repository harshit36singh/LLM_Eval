package com.example.llm_eval.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.llm_eval.model.Evaluation;

@Service
public class RankingService {

    private static final double ACCURACY_WEIGHT = 0.5;
    private static final double RELEVANCE_WEIGHT = 0.3;
    private static final double CLARITY_WEIGHT = 0.2;

    public double score(Evaluation e) {
        return e.getAccuracy() * ACCURACY_WEIGHT
                + e.getRelevance() * RELEVANCE_WEIGHT
                + e.getClarity() * CLARITY_WEIGHT;
    }

    public List<Evaluation> rank(List<Evaluation> evaluations) {
        return evaluations.stream()
                .sorted(Comparator
                        .comparingDouble(this::score)
                        .reversed()
                        .thenComparing(e -> e.getResponse().getId()))
                .toList();
    }
}
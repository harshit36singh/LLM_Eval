package com.example.llm_eval.service;

import org.springframework.stereotype.Service;

import com.example.llm_eval.model.Evaluation;
import com.example.llm_eval.model.LlmResponse;
import com.example.llm_eval.repository.EvaluationRepository;
import com.example.llm_eval.repository.ResponseRepository;

@Service
public class EvaluationService {

    private final EvaluationRepository evaluationRepo;
    private final ResponseRepository responseRepo;

    public EvaluationService(
        EvaluationRepository evaluationRepo,
        ResponseRepository responseRepo
    ) {
        this.evaluationRepo = evaluationRepo;
        this.responseRepo = responseRepo;
    }

    public Evaluation evaluate(
        Long responseId,
        int accuracy,
        int relevance,
        int clarity,
        String rationale
    ) {
        LlmResponse response = responseRepo.findById(responseId)
            .orElseThrow(() -> new IllegalArgumentException("Response not found"));

        Evaluation evaluation = new Evaluation();
        evaluation.setResponse(response);
        evaluation.setAccuracy(accuracy);
        evaluation.setRelevance(relevance);
        evaluation.setClarity(clarity);
        evaluation.setRationale(rationale);

        return evaluationRepo.save(evaluation);
    }
}
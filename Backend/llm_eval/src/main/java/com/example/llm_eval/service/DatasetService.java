package com.example.llm_eval.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.llm_eval.model.Evaluation;
import com.example.llm_eval.repository.EvaluationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DatasetService {

    private final EvaluationRepository evaluationRepo;
    private final RankingService rankingService;

    public List<Evaluation> highQualityForPrompt(Long promptId) {
        List<Evaluation> evaluations =
            evaluationRepo.findByResponse_Prompt_Id(promptId);

        return rankingService.rank(evaluations).stream()
            .filter(e -> e.getAccuracy() >= 4)
            .filter(e -> rankingService.score(e) >= 4.0)
            .toList();
    }
}
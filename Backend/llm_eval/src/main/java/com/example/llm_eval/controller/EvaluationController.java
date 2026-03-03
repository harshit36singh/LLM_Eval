package com.example.llm_eval.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.llm_eval.dto.EvaluationRequestDto;
import com.example.llm_eval.model.Evaluation;
import com.example.llm_eval.repository.EvaluationRepository;
import com.example.llm_eval.service.EvaluationService;
import com.example.llm_eval.service.RankingService;

@RestController
@RequestMapping("/api/evaluations")
public class EvaluationController {

    private final EvaluationService evaluationService;
    private final RankingService rankingService;
    private final EvaluationRepository evaluationRepo;

    public EvaluationController(
        EvaluationService evaluationService,
        RankingService rankingService,
        EvaluationRepository evaluationRepo
    ) {
        this.evaluationService = evaluationService;
        this.rankingService = rankingService;
        this.evaluationRepo = evaluationRepo;
    }

    @PostMapping
    public ResponseEntity<Long> evaluate(@RequestBody EvaluationRequestDto dto) {
        Evaluation e = evaluationService.evaluate(
            dto.responseId(),
            dto.accuracy(),
            dto.relevance(),
            dto.clarity(),
            dto.rationale()
        );
        return ResponseEntity.ok(e.getId());
    }

    @GetMapping("/prompt/{promptId}/ranked")
    public List<Evaluation> ranked(@PathVariable Long promptId) {
        List<Evaluation> evaluations =
            evaluationRepo.findByResponse_Prompt_Id(promptId);

        return rankingService.rank(evaluations);
    }
}
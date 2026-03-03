package com.example.llm_eval.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.llm_eval.model.Evaluation;

public interface EvaluationRepository extends JpaRepository<Evaluation,Long>{

        List<Evaluation> findByResponse_Prompt_Id(Long promptId);
}
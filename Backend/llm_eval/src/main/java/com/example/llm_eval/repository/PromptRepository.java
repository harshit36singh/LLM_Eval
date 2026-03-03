package com.example.llm_eval.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.llm_eval.model.Prompt;

public interface PromptRepository extends JpaRepository<Prompt,Long> {

    
}
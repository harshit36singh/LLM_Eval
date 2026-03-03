package com.example.llm_eval.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.llm_eval.model.LlmResponse;

public interface ResponseRepository extends JpaRepository<LlmResponse,Long>{

    
}
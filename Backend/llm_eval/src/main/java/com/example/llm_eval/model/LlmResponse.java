package com.example.llm_eval.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Entity
@Data
public class LlmResponse{
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Prompt prompt;

    @Column(nullable = false, length = 5000)
    private String content;

    @Column(nullable = false)
    private String modelName; 
}
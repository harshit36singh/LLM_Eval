package com.example.llm_eval.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.llm_eval.service.DatasetService;
import com.example.llm_eval.util.JsonlExporter;

@RestController
@RequestMapping("/api/datasets")
public class DatasetController {

    private final DatasetService datasetService;
    private final JsonlExporter exporter;

    public DatasetController(
        DatasetService datasetService,
        JsonlExporter exporter
    ) {
        this.datasetService = datasetService;
        this.exporter = exporter;
    }

    @GetMapping("/prompt/{promptId}/export")
    public ResponseEntity<String> export(@PathVariable Long promptId) {
        String jsonl = exporter.export(
            datasetService.highQualityForPrompt(promptId)
        );

        return ResponseEntity.ok()
            .header("Content-Type", "application/jsonl")
            .body(jsonl);
    }
}
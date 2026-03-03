package com.example.llm_eval.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.llm_eval.model.Evaluation;

@Component
public class JsonlExporter {

    public String export(List<Evaluation> evaluations) {
        StringBuilder sb = new StringBuilder();

        for (Evaluation e : evaluations) {
            sb.append("""
                {"prompt":"%s","response":"%s"}
                """.formatted(
                    escape(e.getResponse().getPrompt().getText()),
                    escape(e.getResponse().getContent())
                ).trim());
            sb.append("\n");
        }
        return sb.toString();
    }

    private String escape(String s) {
        return s.replace("\"", "\\\"");
    }
}
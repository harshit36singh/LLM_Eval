CREATE TABLE prompt (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    text VARCHAR(2000) NOT NULL,
    created_at TIMESTAMP
);

CREATE TABLE llm_response (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    prompt_id BIGINT NOT NULL,
    content VARCHAR(5000) NOT NULL,
    model_name VARCHAR(255) NOT NULL,
    CONSTRAINT fk_prompt FOREIGN KEY (prompt_id) REFERENCES prompt(id)
);

CREATE TABLE evaluation (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    response_id BIGINT NOT NULL,
    accuracy INT,
    relevance INT,
    clarity INT,
    rationale VARCHAR(2000),
    created_at TIMESTAMP,
    CONSTRAINT fk_response FOREIGN KEY (response_id) REFERENCES llm_response(id)
);
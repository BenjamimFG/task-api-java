package com.br.task.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
    private final String mensagem;
    private final String details;
    private final LocalDateTime timestamp;

    public ErrorResponse(String mensagem, String details) {
        timestamp = LocalDateTime.now();
        this.mensagem = mensagem;
        this.details = details;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public String getMensagem() {
        return mensagem;
    }
    public String getDetails() {
        return details;
    }
}

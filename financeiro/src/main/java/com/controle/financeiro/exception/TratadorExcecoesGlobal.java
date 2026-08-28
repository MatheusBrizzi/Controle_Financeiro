package com.controle.financeiro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class TratadorExcecoesGlobal {

    // Trata erros de recursos não encontrados (HTTP 404)
    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<Object> handleRecursoNaoEncontrado(RecursoNaoEncontradoException ex) {
        return buildResponse(HttpStatus.NOT_FOUND, "Recurso não encontrado", ex.getMessage());
    }

    // Trata violações de regras de negócio (HTTP 400)
    @ExceptionHandler(RegraNegocioException.class)
    public ResponseEntity<Object> handleRegraNegocio(RegraNegocioException ex) {
        return buildResponse(HttpStatus.BAD_REQUEST, "Violação de regra de negócio", ex.getMessage());
    }

    // Trata erros de validação das anotações do Bean Validation como @NotBlank, @NotNull, etc. (HTTP 400)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidacoes(MethodArgumentNotValidException ex) {
        Map<String, String> errosCampos = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            errosCampos.put(error.getField(), error.getDefaultMessage())
        );

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("erro", "Erro de validação nos campos");
        body.put("detalhes", errosCampos);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    // Método utilitário para construir o JSON de resposta
    private ResponseEntity<Object> buildResponse(HttpStatus status, String erro, String mensagem) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());
        body.put("erro", erro);
        body.put("mensagem", mensagem);

        return ResponseEntity.status(status).body(body);
    }
}
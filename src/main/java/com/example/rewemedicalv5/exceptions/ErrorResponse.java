package com.example.rewemedicalv5.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
    private String uri;
    private HttpStatus status;
    private int code;
    private String message;
    private Map<String, String> errors;

    public ErrorResponse() {
        this.timestamp = LocalDateTime.now();
        errors = new HashMap<>();
    }

        public ErrorResponse(String uri, HttpStatus status,
                         int code, String message) {
        this();
        this.uri = uri;
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public ErrorResponse(String uri, HttpStatus status,
                         int code, String message,
                         Map<String, String> errors) {
        this();
        this.uri = uri;
        this.status = status;
        this.code = code;
        this.message = message;
        this.errors = errors;
    }

}

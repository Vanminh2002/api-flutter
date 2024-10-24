package org.example.apiflutter.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<String> handlerRuntimeException(RuntimeException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());

    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<String> handlerMethodArgument(MethodArgumentNotValidException exception) {
        return ResponseEntity.badRequest().body(Objects.requireNonNull(exception.getFieldError()).getDefaultMessage());

    }
}

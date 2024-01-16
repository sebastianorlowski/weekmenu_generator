package com.meal_generator.api.validation;

import com.meal_generator.api.validation.exception.MealException;
import com.meal_generator.api.validation.exception.MealNotFoundException;
import com.meal_generator.api.validation.exception.RecipeNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.format.DateTimeParseException;
import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .toList();

        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(HttpMessageNotReadableException ex) {
        String error = ex.getMessage();

        return new ResponseEntity<>(getErrorsMap(List.of(error)), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(DateTimeParseException ex) {
        String error = ex.getMessage();

        return new ResponseEntity<>(getErrorsMap(List.of(error)), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RecipeNotFoundException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(RecipeNotFoundException ex) {
        String error = ex.getMessage();

        return new ResponseEntity<>(getErrorsMap(List.of(error)), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MealNotFoundException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MealNotFoundException ex) {
        String error = ex.getMessage();

        return new ResponseEntity<>(getErrorsMap(List.of(error)), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MealException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MealException ex) {
        String error = ex.getMessage();

        return new ResponseEntity<>(getErrorsMap(List.of(error)), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", sortErrorsAlphabetically(errors));
        return errorResponse;
    }

    private List<String> sortErrorsAlphabetically(List<String> errors) {
        List<String> sortedErrors = new ArrayList<>(errors);
        Collections.sort(sortedErrors);
        return sortedErrors;
    }
}

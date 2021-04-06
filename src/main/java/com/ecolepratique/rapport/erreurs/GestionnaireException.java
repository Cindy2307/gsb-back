package com.ecolepratique.rapport.erreurs;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GestionnaireException extends ResponseEntityExceptionHandler {
	
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        Map<String, Object> body = new HashMap<>();      
        BindingResult br = exception.getBindingResult();
        List<FieldError> fes = br.getFieldErrors();
        List<String> erreurs = new ArrayList<>();
        for(int i = 0; i < fes.size(); i++) {
        	erreurs.add(fes.get(i).getField() + " - " + fes.get(i).getDefaultMessage());
        }
        body.put("errors", erreurs);
        return new ResponseEntity<>(body, headers, status);
    }
}

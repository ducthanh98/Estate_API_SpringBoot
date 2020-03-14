package com.fushi.exception;

import com.fushi.dto.ResponseCode;
import com.fushi.util.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class MethodArgumentExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String message = ex.getBindingResult().getFieldError().getDefaultMessage();
        Response response = new Response<String>(ResponseCode.ERROR,message);


        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
    }
}

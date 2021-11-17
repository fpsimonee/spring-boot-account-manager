package br.com.spring.cache.demo.errors;

import br.com.spring.cache.demo.exception.BillingNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.core.serializer.support.SerializationFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorResponse> handleIllegalStateException(IllegalStateException e){

        HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
        return new ResponseEntity<>(new ErrorResponse(status, e.getMessage()), status);

    }

    @ExceptionHandler(BillingNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBillingNotFoundException(BillingNotFoundException e){

        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(new ErrorResponse(status, e.getMessage()), status);

    }

    @ExceptionHandler(SerializationFailedException.class)
    public ResponseEntity<ErrorResponse> handleJsonSerializationFailedException(SerializationFailedException e){

        HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
        return new ResponseEntity<>(new ErrorResponse(status, e.getMessage()), status);

    }
}

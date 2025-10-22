package ie.atu.week5.week5.errorHandling;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandling {
    @ExceptionHandler(MethodArgumentNotValidException.class)
         public ExceptionDetails showErrorDetails(MethodArgumentNotValidException mae)
    {
         ExceptionDetails exceptionDetails = new ExceptionDetails();
         exceptionDetails.setFieldName(mae.getBindingResult().getFieldError().getField());
         exceptionDetails.setFieldValue(mae.getBindingResult().getFieldError().getDefaultMessage());
         return exceptionDetails;
    }




}

package com.sst.productservicesst.exceptionHandler;

import com.sst.productservicesst.DTO.ExceptionDto;
import com.sst.productservicesst.exceptions.ProductNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmaticException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Arithmetic Exception Occurred");
        exceptionDto.setResolution("Please check the input values");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, org.springframework.http.HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDto> handleArrayIndexOutOfBoundsException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Arithmetic Exception Occurred");
        exceptionDto.setResolution("Please check the input values");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, org.springframework.http.HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("No product whith that id");
        exceptionDto.setResolution("Please check the input values");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, org.springframework.http.HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Exception Occurred");
        exceptionDto.setResolution("Please check the input values");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, org.springframework.http.HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

}

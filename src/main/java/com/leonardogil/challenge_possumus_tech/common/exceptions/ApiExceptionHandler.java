package com.leonardogil.challenge_possumus_tech.common.exceptions;

import com.leonardogil.challenge_possumus_tech.domain.exceptions.IntegerOutOfRangeException;
import com.leonardogil.challenge_possumus_tech.domain.exceptions.RomanValidationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RomanValidationException.class)
    @ResponseBody
    public ErrorMessage badRequestRoman(HttpServletRequest request, RomanValidationException exception){
        return new ErrorMessage(
                exception.getMessage(),
                exception.getClass().getSimpleName(),
                request.getRequestURI()
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IntegerOutOfRangeException.class)
    @ResponseBody
    public ErrorMessage badRequestInteger(HttpServletRequest request, IntegerOutOfRangeException exception){
        return new ErrorMessage(
                exception.getMessage(),
                exception.getClass().getSimpleName(),
                request.getRequestURI()
        );
    }

}

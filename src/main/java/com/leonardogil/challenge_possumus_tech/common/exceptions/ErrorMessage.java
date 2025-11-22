package com.leonardogil.challenge_possumus_tech.common.exceptions;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ErrorMessage {

    private String message;
    private String exception;
    private String path;

    public ErrorMessage(String message, String exception, String path){
        this.message = message;
        this.exception = exception;
        this.path = path;
    }

}

package io.github.pashazz.walker.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WalkNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(WalkNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String walkNotFound (WalkNotFoundException e) {
        return e.getLocalizedMessage();
    }

}

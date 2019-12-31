package com.warning.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ModelNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(ModelNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String modelNotFoundHandler(ModelNotFoundException ex) {
    return ex.getMessage();
  }
}

package com.fastcampus.javaallinone.project3.demo.exception.handler;

import com.fastcampus.javaallinone.project3.demo.exception.PersonNotFoundException;
import com.fastcampus.javaallinone.project3.demo.exception.RenameNotPermitException;
import com.fastcampus.javaallinone.project3.demo.exception.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RenameNotPermitException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleRenameNoPermittedException(RenameNotPermitException ex) {
        return ErrorResponse.of(BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handlePersonNotFoundException(PersonNotFoundException ex) {
        return ErrorResponse.of(BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ErrorResponse handleRuntimeException(RuntimeException ex) {
        log.error("서버오류 : {}", ex.getMessage(), ex);
        return ErrorResponse.of(INTERNAL_SERVER_ERROR, "알 수 없는 서버 오류가 발생하였습니다");
    }
}

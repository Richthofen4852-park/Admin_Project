package com.fastcampus.javaallinone.project3.demo.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RenameNotPermitException extends RuntimeException {

    public static final String MESSAGE = "이름 변경을 허용하지 않습니다";

    public RenameNotPermitException() {
        super(MESSAGE);
        log.info(MESSAGE);
    }
}

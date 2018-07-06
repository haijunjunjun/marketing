package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BizRuntimeException extends RuntimeException{
    public BizRuntimeException(String message) {
        super(message);
    }
}

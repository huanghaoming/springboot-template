package com.zhenmei.wsc.exception;

import lombok.Data;

@Data
public class SuccessException extends RuntimeException{
    private transient Object data;

    public SuccessException(Object data) {
        this.data = data;
    }

    public SuccessException() {
    }
}
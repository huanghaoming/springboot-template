package com.zhenmei.wsc.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 此类不该定义到common中
 */
@Getter
@AllArgsConstructor
@Deprecated
public class AuthorizeException extends RuntimeException {

    private String message;

}


package com.github.commonweb;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.PARTIAL_CONTENT)
public class ServiceException extends RuntimeException{
    protected  Integer code;
    protected String message;
    protected String detail;


    public ServiceException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ServiceException(Integer code, String message, String detail) {
        this.code = code;
        this.message = message;
        this.detail = detail;
    }

    public ServiceException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }


    public static ServiceException make(Integer exceptionCode, String msg  , Throwable cause) {
        ServiceException exception = new ServiceException(exceptionCode,msg, cause);
        exception.initCause(cause);
        return exception;
    }
    public static ServiceException make(Integer exceptionCode, String msg ) {
        ServiceException exception = new ServiceException(exceptionCode,msg);
        return exception;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}

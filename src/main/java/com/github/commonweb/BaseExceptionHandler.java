package com.github.commonweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * If you want use this handler,
 * make a class extends it and mark with org.springframework.web.bind.annotation.ControllerAdvice
 * @ControllerAdvice
 */
public class BaseExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(BaseExceptionHandler.class);

    // your can override these
    public  int DEFAULT_EXCEPTION_CODE = 100;
    public  int BIND_EXCEPTION_CODE = 101;
    public  int METHOD_EXCEPTION_CODE = 102;

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public RestResponse exceptionHandler(Exception ex) {
            return  createExceptionResponse(DEFAULT_EXCEPTION_CODE,"Error msg: "+ex.getMessage() + "\nCause by:\n"
                    +ex.getCause(), ex);
    }

    @ResponseBody
    @ExceptionHandler(value = org.springframework.validation.BindException.class)
    public RestResponse bindExceptionHandler(org.springframework.validation.BindException ex) {
        logger.error("Global [Exception] handler: " + ex.getMessage(), ex);
        StringBuffer sbErrorMessage = new StringBuffer();
        sbErrorMessage.append("Input param error:");
        for(FieldError fieldError:ex.getFieldErrors()){
            sbErrorMessage.append("“"+fieldError.getField()+"”");
            sbErrorMessage.append(":");
            sbErrorMessage.append(fieldError.getDefaultMessage());
            sbErrorMessage.append(";");
        }
        return createExceptionResponse(BIND_EXCEPTION_CODE,sbErrorMessage.toString(),ex);
    }

    @ResponseBody
    @ExceptionHandler(value = org.springframework.web.bind.MethodArgumentNotValidException.class)
    public RestResponse methodArgumentNotValidExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        String message=String.format("method input error: “%s”：%s",fieldError.getField(),fieldError.getDefaultMessage());
        return createExceptionResponse(METHOD_EXCEPTION_CODE, message,ex);
    }

    @ResponseBody
    @ExceptionHandler(value = ServiceException.class)
    public RestResponse serviceExceptionHandler(HttpServletRequest HttpServletRequest, ServiceException ex) {
        return this.createExceptionResponse(ex.getCode(), ex.message, ex);
    }

    private RestResponse createExceptionResponse(int code, String message, Exception ex){
        logger.error("Exception handler: " + ex.getMessage(), ex);
        return RestResponse.fail(code,message);
    }

}
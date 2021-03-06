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
 *
 * @ControllerAdvice
 */
public class BaseExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(BaseExceptionHandler.class);

    // your can override these
    public int CODE_DEFAULT_EXCEPTION = 100;
    public int CODE_BIND_EXCEPTION = 101;
    public int CODE_METHOD_EXCEPTION = 102;

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public RestResponse exceptionHandler(Exception ex) {
        String causeMsg;
        if (ex.getCause() != null) {
            causeMsg = "\nCause by:\n" + ex.getCause().getMessage();
        } else {
            causeMsg = "";
        }
        return createExceptionResponse(CODE_DEFAULT_EXCEPTION, "DEFAULT_EXCEPTION",
                ex.getMessage() + causeMsg,  ex);
    }

    @ResponseBody
    @ExceptionHandler(value = org.springframework.validation.BindException.class)
    public RestResponse bindExceptionHandler(org.springframework.validation.BindException ex) {
        StringBuffer sbErrorMessage = new StringBuffer();
        for (FieldError fieldError : ex.getFieldErrors()) {
            sbErrorMessage.append(formatFieldError(fieldError));
            sbErrorMessage.append("\n");
        }
        return createExceptionResponse(CODE_BIND_EXCEPTION, "BIND_EXCEPTION", sbErrorMessage.toString(), ex);
    }

    private String formatFieldError(FieldError e) {
        return String.format(" Input field: [%s] error, reason: [%s]", e.getField(), e.getDefaultMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = org.springframework.web.bind.MethodArgumentNotValidException.class)
    public RestResponse methodArgumentNotValidExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        return createExceptionResponse(CODE_METHOD_EXCEPTION, "METHOD_EXCEPTION", formatFieldError(fieldError), ex);
    }

    @ResponseBody
    @ExceptionHandler(value = ServiceException.class)
    public RestResponse serviceExceptionHandler(HttpServletRequest HttpServletRequest, ServiceException ex) {
        return this.createExceptionResponse(ex.getCode(), ex.message, ex.detail, ex);
    }

    private RestResponse createExceptionResponse(int code, String message, String detail, Exception ex) {
        logger.error("Exception handler: " + ex.getMessage(), ex);
        return RestResponse.fail(code, message, detail);
    }

}
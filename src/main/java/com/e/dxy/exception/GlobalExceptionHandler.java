package com.e.dxy.exception;

import com.e.dxy.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(basePackages = "com.e.dxy.controller")
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Response exceptionHandler(HttpServletRequest httpServletRequest, Exception e) {
        logger.error("[exceptionHandler]", e);
        return Response.error("500", e.getMessage());
    }
}

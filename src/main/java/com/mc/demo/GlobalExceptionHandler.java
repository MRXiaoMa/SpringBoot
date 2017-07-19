package com.mc.demo;

import com.mc.demo.web.ErrorInfo;
import com.mc.demo.web.MyException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorhandler(HttpServletRequest request, MyException exception)
    {
        ErrorInfo<String> error=new ErrorInfo<>();
        error.setCode(ErrorInfo.ERROR);
        error.setMsg(exception.getMessage());
        error.setData(null);
        error.setUrl(request.getRequestURL().toString());
        return error;
    }
}
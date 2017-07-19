package com.mc.demo.web;

public class SuccessInfo<T> extends ResultInfo<T>{

    public SuccessInfo(int code, String msg, T data) {
        super(code, msg, data);
    }

    public SuccessInfo(String msg)
    {
        super(Constant.SUCCESS,msg,null);
    }

    public SuccessInfo(String msg,T data){
        super(Constant.SUCCESS,msg,data);
    }
}

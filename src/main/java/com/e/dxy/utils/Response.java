package com.e.dxy.utils;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@SuppressWarnings("unchecked")
public class Response<T> implements Serializable {
    private String code;

    private String msg;

    private boolean success;

    private T data;

    public static Response success() {
        Response response = new Response();
        response.setCode("200");
        response.setMsg("success");
        response.setSuccess(true);
        return response;
    }

    public static Response success(Object data) {
        Response response = new Response();
        response.setCode("200");
        response.setMsg("success");
        response.setSuccess(true);
        response.setData(data);
        return response;
    }

    public static Response success(String code, String msg, Object data) {
        Response response = new Response();
        response.setCode(code);
        response.setMsg(msg);
        response.setSuccess(true);
        response.setData(data);
        return response;
    }

    public static Response error(String code, String msg) {
        Response response = new Response();
        response.setCode(code);
        response.setMsg(msg);
        response.setSuccess(false);
        return response;
    }
}

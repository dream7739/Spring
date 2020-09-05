package com.jm.sign.vo;

//요청에 대한 응답 객체


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DefaultRes<T> {
    private int status;
    private String message;
    private T data;

    public DefaultRes(int status, String message){
        this.status = status;
        this.message = message;
        this.data = null;
    }
}

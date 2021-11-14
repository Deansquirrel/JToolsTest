package com.yuansong.tools.vo.response;

public enum ResultCode {

    SUCCESS(0),
    FAIL(-1);

    public int code;

    ResultCode(int code) {this.code = code;}

}

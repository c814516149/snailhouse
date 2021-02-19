package com.channing.snailhouse.util;


import com.channing.snailhouse.bean.ErrorCode;

public class CheckedException extends RuntimeException {
    private static final long serialVersionUID = -7406701992372965750L;

    private String msg;
    private String code;

    public CheckedException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public CheckedException(String code,String msg){
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public CheckedException(ErrorCode errorCode){
        super(errorCode.getMsg());
        this.msg = errorCode.getMsg();
        this.code = errorCode.getCode();
    }

    public void setErrorMessage(String errorMessage) {
        this.msg = errorMessage;
    }

    public String getErrorMessage() {
        return msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}


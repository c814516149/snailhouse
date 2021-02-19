package com.channing.snailhouse.bean;

public class Result<T> {
    //业务状态 1:成功，-1：失败
    private Integer status = 1;

    private String code = "200";
    private String msg = "";

    private T data ;

    public Result(T data){
        this.status = 1;
        this.data = data;
    }

    public Result(T data, String code, String msg){
        this.data =data;
        this.code = code;
        this.msg = msg;
        this.status = -1;
    }

    public Result(T data, String code){
        this.data =data;
        this.code = code;
        this.status = -1;
    }

    public Result(ErrorCode error){
        this.code = error.getCode();
        this.msg = error.getMsg();
        this.status = -1;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result(){

    }

    @Override
    public String toString() {
        return "Result [status=" + status + ", code=" + code + ", msg=" + msg + ", data=" + data + "]";
    }

}


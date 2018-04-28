package com.edu.fjnu.cjrserver.model;

public class ResultData <T>{
    private T data;
    //如果返回值不是200，就是该操作有错
    private int code =200;
    //存储错误信息
    private String msg;

    private Boolean success = true;
    public Boolean getSuccess() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public int getCode() {

        return code;
    }
    public void setCode(int code) {
        if(200 != code){
            success = false;
        }
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public void setErrorResult(int c,boolean s,String m){
        code = c;
        success = s;
        msg = m;
    }
    public void setRightResult(String m){
        msg = m;
    }
}

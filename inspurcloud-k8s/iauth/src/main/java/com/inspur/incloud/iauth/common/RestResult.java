package com.inspur.incloud.iauth.common;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by kaenry on 2016/9/20.
 * RestResult
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResult<T> {

    private boolean flag;

    private String errCode;

    private T resData;

    private RestResult() {}

    public static <T> RestResult<T> newInstance() {
        return new RestResult<>();
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public T getResData() {
        return resData;
    }

    public void setResData(T resData) {
        this.resData = resData;
    }

    @Override
    public String toString() {
        return "RestResult{" +
                "flag=" + flag +
                ", errCode='" + errCode + '\'' +
                ", resData=" + resData +
                '}';
    }
}

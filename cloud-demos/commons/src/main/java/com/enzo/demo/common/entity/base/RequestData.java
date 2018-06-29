package com.enzo.demo.common.entity.base;/**
 * Created by LENOVO on 2018/6/29.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author zhangyx
 * @desccription 请求数据
 * @date 2018-06-2018/6/29-16:56
 */
public class RequestData<T> {

    @JsonProperty("token")
    private String token;
    @JsonProperty("data")
    private T data;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

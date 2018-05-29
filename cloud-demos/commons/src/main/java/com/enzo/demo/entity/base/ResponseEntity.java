package com.enzo.demo.entity.base;/**
 * Created by LENOVO on 2018/5/29.
 */

import com.enzo.demo.enums.CodeAndMessageEnum;

/**
 * @author zhangyx
 * @desccription
 * @date 2018-05-2018/5/29-9:15
 */
public class ResponseEntity<T> {

    private Short code = 0;

    private String message = "SUCCESS";

    private T data;

    public Short getCode() {
        return code;
    }

    public void setCode(Short code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseEntity{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data.toString() +
                '}';
    }

    public ResponseEntity(Short code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseEntity(CodeAndMessageEnum info, T data) {
        this(info.getCode(), info.getMessage(), data);
    }

    public ResponseEntity(CodeAndMessageEnum info) {
        this(info, null);
    }
}

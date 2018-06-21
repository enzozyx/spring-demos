package com.enzo.demo.code.enums;/**
 * Created by LENOVO on 2018/6/12.
 */

/**
 * @author zhangyx
 * @desccription
 * @date 2018-06-2018/6/12-20:53
 */
public enum ConstaintEnum {

    NOT_NULL("not_null"),
    MAX_LENGTH("max_length"),
    MIN_LENGTH("min_length"),
    DATE_FORMAT("data_format"),
    DATE_TIME_FORMAT("time_format");

    private String name;

    ConstaintEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

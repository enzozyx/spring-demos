package com.enzo.demo.common.code.enums;/**
 * Created by LENOVO on 2018/6/21.
 */

/**
 * @author zhangyx
 * @desccription mapper方法类型枚举
 * @date 2018-06-2018/6/21-11:35
 */
public enum  MapperMethodTypeEnum {

    SELECT("select"),
    INSERT("insert"),
    UPDATE("update"),
    DELETE("delete");


    private String name;

    MapperMethodTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

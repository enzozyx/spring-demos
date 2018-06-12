package com.enzo.demo.code.entity;/**
 * Created by LENOVO on 2018/6/12.
 */

import com.enzo.demo.code.enums.ConstaintEnum;

/**
 * @author zhangyx
 * @desccription 约束枚举
 * @date 2018-06-2018/6/12-20:48
 */
public class Constaint {

    private int length;
    private ConstaintEnum type;

    public Constaint(ConstaintEnum type) {
        this.type = type;
    }

    public Constaint(ConstaintEnum type, int length) {
        this(type);
        // TODO: 2018/6/12 依据type 设置约束描述信息
        setLength(length);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public ConstaintEnum getType() {
        return type;
    }

    public void setType(ConstaintEnum type) {
        this.type = type;
    }
}

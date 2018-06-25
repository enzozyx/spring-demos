package com.enzo.demo.common.code.entity;/**
 * Created by LENOVO on 2018/6/21.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author zhangyx
 * @desccription 参数描述
 * @date 2018-06-2018/6/21-10:28
 */
public class ParamDesc {

    /**
     * 参数名称
     */
    @JsonProperty("name")
    private String name;
    /**
     * ibatis 参数别名
     */
    @JsonProperty("iabtis_name")
    private String ibatisName;
    /**
     * 数据类型
     */
    @JsonProperty("type")
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIbatisName() {
        return ibatisName;
    }

    public void setIbatisName(String ibatisName) {
        this.ibatisName = ibatisName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ParamDesc(String name, String ibatisName, String type) {
        this.name = name;
        this.ibatisName = ibatisName;
        this.type = type;
    }

    public ParamDesc(String name, String type) {
        this.name = name;
        this.type = type;
    }
}

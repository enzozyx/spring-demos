package com.enzo.demo.common.code.entity;/**
 * Created by LENOVO on 2018/6/21.
 */

import com.enzo.demo.common.code.enums.MapperMethodTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyx
 * @desccription 数据接口描述
 * @date 2018-06-2018/6/21-10:26
 */
public class MethodDesc {
    /**
     * 方法名
     */
    @JsonProperty("name")
    private String name;
    /**
     * 方法描述
     */
    @JsonProperty("desc")
    private String desc;
    /**
     * 返回类型 默认 void
     */
    @JsonProperty("return_type")
    private String returnType = "void";
    /**
     * 参数列表
     */
    @JsonProperty("params")
    private List<ParamDesc> params;
    /**
     * 方法类型
     */
    @JsonProperty("type")
    private String type;
    /**
     * mapper描述
     */
    @JsonProperty("parse")
    private String parse;
    /**
     * 方法内容
     */
    @JsonProperty("content")
    private String content;
    /**
     * 需要事务控制
      */
    @JsonProperty("need_transaction")
    private Boolean needTransaction = false;

    public Boolean getNeedTransaction() {
        return needTransaction;
    }

    public void setNeedTransaction(Boolean needTransaction) {
        this.needTransaction = needTransaction;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getParse() {
        return parse;
    }

    public void setParse(String parse) {
        this.parse = parse;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public List<ParamDesc> getParams() {
        if(params == null){
            params = new ArrayList<ParamDesc>();
        }
        return params;
    }

    public void setParams(List<ParamDesc> params) {
        this.params = params;
    }

    public void addParam(ParamDesc param) {
        getParams().add(param);
    }

    public MethodDesc(String name, String desc, MapperMethodTypeEnum type) {
        this.name = name;
        this.desc = desc;
        this.type = type.getName();
    }

    public MethodDesc(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
}

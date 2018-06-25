package com.enzo.demo.common.code.entity;/**
 * Created by LENOVO on 2018/6/21.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyx
 * @desccription 数据接口层描述
 * @date 2018-06-2018/6/21-10:25
 */
public class DaoDesc {
    /**
     * 实体
     */
    @JsonProperty("domain")
    private DomainDesc domain;
    /**
     * 数据接口方法
     */
    @JsonProperty("dao_methods")
    private List<MethodDesc> methods;

    public DomainDesc getDomain() {
        return domain;
    }

    public void setDomain(DomainDesc domain) {
        this.domain = domain;
    }

    public List<MethodDesc> getMethods() {
        if(methods == null){
            methods = new ArrayList<MethodDesc>();
        }
        return methods;
    }

    public void setMethods(List<MethodDesc> methods) {
        this.methods = methods;
    }

    public DaoDesc(DomainDesc domain) {
        this.domain = domain;
    }

    public void addMethod(MethodDesc method) {
        getMethods().add(method);
    }
}

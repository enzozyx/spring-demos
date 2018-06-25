package com.enzo.demo.common.code.entity;/**
 * Created by LENOVO on 2018/6/21.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyx
 * @desccription 服务描述
 * @date 2018-06-2018/6/21-14:57
 */
public class ServiceDesc {

    @JsonProperty("domain")
    private DomainDesc domain;
    @JsonProperty("desc")
    private String desc;
    @JsonProperty("methods")
    private List<MethodDesc> methods;

    public ServiceDesc(DomainDesc domain, String desc) {
        this.domain = domain;
        this.desc = desc;
    }

    public DomainDesc getDomain() {
        return domain;
    }

    public void setDomain(DomainDesc domain) {
        this.domain = domain;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public void addMethod(MethodDesc method) {
        getMethods().add(method);
    }


}

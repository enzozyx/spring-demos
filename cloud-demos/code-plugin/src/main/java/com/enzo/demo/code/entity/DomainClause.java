package com.enzo.demo.code.entity;/**
 * Created by LENOVO on 2018/6/29.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Set;

/**
 * @author zhangyx
 * @desccription
 * @date 2018-06-2018/6/29-17:00
 */
public class DomainClause {
    /**
     * 需要查询的属性
     */
    @JsonProperty("query_properties")
    private Set<String> queryProperties;
    /**
     * 查询条件
     */
    @JsonProperty("clauses")
    private Set<String> clauses;
    /**
     * 不要前缀的方法名
     */
    @JsonProperty("name")
    private String name;
    /**
     * 包名
     */
    @JsonProperty("pacakge_name")
    private String packageName;

    public Set<String> getQueryProperties() {
        return queryProperties;
    }

    public void setQueryProperties(Set<String> queryProperties) {
        this.queryProperties = queryProperties;
    }

    public Set<String> getClauses() {
        return clauses;
    }

    public void setClauses(Set<String> clauses) {
        this.clauses = clauses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}

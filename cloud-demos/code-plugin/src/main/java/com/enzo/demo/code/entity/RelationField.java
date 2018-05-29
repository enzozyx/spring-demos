package com.enzo.demo.code.entity;/**
 * Created by LENOVO on 2018/5/29.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author zhangyx
 * @desccription
 * @date 2018-05-2018/5/29-10:33
 */
public class RelationField {

    @JsonProperty("order")
    private Short order;
    @JsonProperty("name")
    private String name;
    @JsonProperty("jdbc_type")
    private String jdbcType;
    @JsonProperty("length")
    private Integer length;
    @JsonProperty("var_length")
    private Integer varLength;
    @JsonProperty("not_null")
    private Boolean notNull;
    @JsonProperty("comment")
    private String comment;

    public Short getOrder() {
        return order;
    }

    public void setOrder(Short order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getVarLength() {
        return varLength;
    }

    public void setVarLength(Integer varLength) {
        this.varLength = varLength;
    }

    public Boolean getNotNull() {
        return notNull;
    }

    public void setNotNull(Boolean notNull) {
        this.notNull = notNull;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "RelationField{" +
                "order=" + order +
                ", name='" + name + '\'' +
                ", jdbcType='" + jdbcType + '\'' +
                ", length=" + length +
                ", varLength=" + varLength +
                ", notNull=" + notNull +
                ", comment='" + comment + '\'' +
                '}';
    }
}

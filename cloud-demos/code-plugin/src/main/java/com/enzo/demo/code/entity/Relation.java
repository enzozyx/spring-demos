package com.enzo.demo.code.entity;/**
 * Created by LENOVO on 2018/5/28.
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author zhangyx
 * @desccription 关系表
 * @date 2018-05-2018/5/28-18:41
 */
public class Relation {

    @JsonProperty("name")
    private String name;

    @JsonProperty("schema")
    private String schema;
    @JsonProperty("space")
    private String space;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("fields")
    private List<RelationField> fields;
    @JsonProperty("domain")
    private String domian;
    @JsonProperty("packageName")
    private String packageName;
    @JsonProperty("page_clause")
    private List<RelationField> pageClause;

    public String getDomian() {
        return domian;
    }

    public void setDomian(String domian) {
        this.domian = domian;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public List<RelationField> getPageClause() {
        return pageClause;
    }

    public void setPageClause(List<RelationField> pageClause) {
        this.pageClause = pageClause;
    }

    public List<RelationField> getFields() {
        return fields;
    }

    public void setFields(List<RelationField> fields) {
        this.fields = fields;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    public Relation(String schema, String name) {
        this.name = name;
        this.schema = schema;
    }

    public Relation() {
    }
}

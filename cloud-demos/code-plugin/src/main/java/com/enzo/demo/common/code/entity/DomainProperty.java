package com.enzo.demo.common.code.entity;/**
 * Created by LENOVO on 2018/6/12.
 */

import com.enzo.demo.common.code.enums.DatabaseTypeEnum;
import com.enzo.demo.common.code.utils.JdbcJavaTypeMatcher;
import com.enzo.demo.common.code.utils.NameStringUtils;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author zhangyx
 * @desccription 实体属性描述信息
 * @date 2018-06-2018/6/12-19:36
 */
public class DomainProperty {
    /**
     * 属性名
     */
    @JsonProperty("name")
    private String name;
    /**
     * 属性关联字段
     */
    @JsonProperty("field")
    private RelationField field;
    /**
     * java 数据类型 [java.lang.* ; java.util.* ]
     */
    @JsonProperty("type")
    private String type;
    /**
     * JDBC 数据类型别名
     */
    @JsonProperty("type_alias")
    private String typeAlias;
    /**
     * 约束信息
     */
    @JsonProperty("constains")
    private List<Constaint> constaints;
    /**
     * getter
     */
    @JsonProperty("getter")
    private String getter;
    /**
     * setter
     */
    @JsonProperty("setter")
    private String setter;

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getSetter() {
        return setter;
    }

    public void setSetter(String setter) {
        this.setter = setter;
    }

    public String getTypeAlias() {
        return typeAlias;
    }

    public void setTypeAlias(String typeAlias) {
        this.typeAlias = typeAlias;
    }

    public List<Constaint> getConstaints() {
        return constaints;
    }

    public void setConstaints(List<Constaint> constaints) {
        this.constaints = constaints;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
    * @author zhangyx
    * @description 依据关系字段 构造实体属性信息
    * @date 2018/6/12 20:12
    * @todo
    * @param 
    * @return 
    * @exception 
    */
    public DomainProperty(RelationField field) {
        setField(field);
        // TODO: 2018/6/12 依据关系表中字段描述初始化实体属性 
        initPropery();
    }

    /**
    * @author zhangyx
    * @description 依据关系表中字段描述初始化实体属性
    * @date 2018/6/12 20:14
    * @todo
    * @param 
    * @return 
    * @exception 
    */
    private void initPropery() {
        if(field == null) return;
        // TODO: 2018/6/12 获取属性名:
        setName(NameStringUtils.getCamelName(field.getName()));
        // TODO: 2018/6/21 配置getter setter
        setGetter("get"+ NameStringUtils.getNormalName(getName()));
        setSetter("set"+ NameStringUtils.getNormalName(getName()));
        // TODO: 2018/6/12 获取属性的Java: 类型
        setType(JdbcJavaTypeMatcher.matchJavaType(DatabaseTypeEnum.POSTGRESQL, field.getJdbcType()));
        setTypeAlias(JdbcJavaTypeMatcher.matchMybatisJdbcType(DatabaseTypeEnum.POSTGRESQL, field.getJdbcType()));
        // TODO: 2018/6/12 处理约束信息: 非空、长度、date的格式化
        setConstaints(field.getConstaints());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RelationField getField() {
        return field;
    }

    public void setField(RelationField field) {
        this.field = field;
    }
}

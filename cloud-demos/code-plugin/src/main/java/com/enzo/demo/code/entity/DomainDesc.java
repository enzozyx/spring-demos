package com.enzo.demo.code.entity;/**
 * Created by LENOVO on 2018/6/12.
 */

import com.enzo.demo.code.utils.NameStringUtils;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhangyx
 * @desccription 实体对象
 * @date 2018-06-2018/6/12-19:33
 */
public class DomainDesc {
    /**
     * 实体关联关系表
     */
    @JsonProperty("relation")
    private Relation relation;
    /**
     * 实体名 (首字母大写，驼峰命名)
     */
    @JsonProperty("name")
    private String name;
    /**
     * 所属包名
     */
    @JsonProperty("package_name")
    private String packageName;
    /**
     * 实体属性
     */
    @JsonProperty("properties")
    private List<DomainProperty> properties;
    /**
     * 创建日期
     */
    @JsonProperty("date")
    private Date date;

    public DomainDesc(Relation relation) {
        this.relation = relation;
        // TODO: 2018/6/12 配置默认属性
        initDomain();
    }

    /**
    * @author zhangyx
    * @description 依据关系表信息 初始化默认 实体属性
    * @date 2018/6/12 19:57
    * @todo
    * @param
    * @return
    * @exception
    */
    private void initDomain() {
        // TODO: 2018/6/21 设定日期
        setDate(new Date());
        // TODO: 2018/6/21 设置默认包名
        setPackageName("com.huajie.bim.demo");
        // TODO: 2018/6/12 通过关系名 配置实体名
        setDomainNameFromRelation();
        // TODO: 2018/6/12 依据关系表中的字段信息 配置实体属性
        setPropertiesBiRelationFields();
    }

    /**
    * @author zhangyx
    * @description 依据关系表中的字段信息 配置实体属性
    * @date 2018/6/12 20:09
    * @todo
    * @param
    * @return
    * @exception
    */
    private void setPropertiesBiRelationFields() {
        if(relation != null && relation.getFields() != null && relation.getFields().size() > 0){
            properties = getInitedProperties();
            for(RelationField field: relation.getFields()){
                DomainProperty property = new DomainProperty(field);
                properties.add(property);
            }
        }
    }

    private List<DomainProperty> getInitedProperties() {
        if(properties != null){
            properties.clear();
        }else {
            properties = new ArrayList<DomainProperty>();
        }
        return properties;
    }

    /**
    * @author zhangyx
    * @description 通过关系名 配置实体名
    * @date 2018/6/12 19:58
    * @todo
    * @param
    * @return
    * @exception
    */
    private void setDomainNameFromRelation() {
        if(relation != null && relation.getName() != null){
            String relName = relation.getName();
            // TODO: 2018/6/12 去除 "t_" "T_" 前缀
            if(relName.startsWith("t_") || relName.startsWith("T_")) relName = relName.substring(2);
            relName = NameStringUtils.getNormalName(relName);
            setName(relName);
        }
    }

    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
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

    public List<DomainProperty> getProperties() {
        return properties;
    }

    public void setProperties(List<DomainProperty> properties) {
        this.properties = properties;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

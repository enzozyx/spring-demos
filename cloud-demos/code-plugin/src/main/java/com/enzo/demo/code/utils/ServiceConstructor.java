package com.enzo.demo.code.utils;/**
 * Created by LENOVO on 2018/6/21.
 */

import com.enzo.demo.code.entity.DomainDesc;
import com.enzo.demo.code.entity.MethodDesc;
import com.enzo.demo.code.entity.ParamDesc;
import com.enzo.demo.code.entity.ServiceDesc;

/**
 * @author zhangyx
 * @desccription 服务构造器
 * @date 2018-06-2018/6/21-14:57
 */
public class ServiceConstructor {


    public static ServiceDesc construct(DomainDesc domain) {
        ServiceDesc service = new ServiceDesc(domain, "服务描述");
        MethodDesc queryDetail = buildQueryDetalMethod(domain);
        service.addMethod(queryDetail);
        MethodDesc insert = buildInsertMethod(domain);
        service.addMethod(insert);
        MethodDesc insertSelective = buildInsertSelectiveMethod(domain);
        service.addMethod(insertSelective);
        MethodDesc update = buildUpdateMethod(domain);
        service.addMethod(update);
        MethodDesc delete = buildDeleteMethod(domain);
        service.addMethod(delete);
        return service;
    }

    private static MethodDesc buildDeleteMethod(DomainDesc domain) {
        MethodDesc method = new MethodDesc("delete", "删除记录");
        method.addParam(new ParamDesc("id", "Integer"));
        method.addParam(new ParamDesc("userId", "Integer"));
        method.setReturnType(domain.getName());
        method.setContent(getDeleteContent(domain));
        method.setNeedTransaction(true);
        return method;
    }

    private static String getDeleteContent(DomainDesc domain) {
        String entityName = NameStringUtils.getCamelName(domain.getName());
        StringBuffer sb = new StringBuffer();
        sb.append(domain.getName() + " "+ entityName +" = this.queryDetail(id); \n");
        sb.append("        this.dao.delete(id)" +  ";\n");
        sb.append("        return " + NameStringUtils.getCamelName(domain.getName()) + ";");
        return sb.toString();
    }

    private static MethodDesc buildUpdateMethod(DomainDesc domain) {
        MethodDesc method = new MethodDesc("update", "更新记录");
        method.addParam(new ParamDesc(NameStringUtils.getCamelName(domain.getName()), domain.getName()));
        method.addParam(new ParamDesc("userId", "Integer"));
        method.setReturnType(domain.getName());
        method.setContent(getUpdateContent(domain));
        method.setNeedTransaction(true);
        return method;
    }

    private static String getUpdateContent(DomainDesc domain) {
        String entityName = NameStringUtils.getCamelName(domain.getName());
        StringBuffer sb = new StringBuffer();
        sb.append(entityName +".setUpdateBy(userId);\n");
        sb.append("        " + entityName +".setUpdated(new Date());\n");
        sb.append("        this.dao.update("+ entityName +")" +  ";\n");
        sb.append("        return this.queryDetail(" + entityName + ".getId());");
        return sb.toString();
    }

    private static MethodDesc buildInsertSelectiveMethod(DomainDesc domain) {
        MethodDesc method = new MethodDesc("addSelective", "添加记录");
        method.addParam(new ParamDesc(NameStringUtils.getCamelName(domain.getName()), domain.getName()));
        method.addParam(new ParamDesc("userId", "Integer"));
        method.setReturnType(domain.getName());
        method.setContent(getInsertSelectiveContent(domain));
        method.setNeedTransaction(true);
        return method;
    }

    private static String getInsertContent(DomainDesc domain) {
        String entityName = NameStringUtils.getCamelName(domain.getName());
        StringBuffer sb = new StringBuffer();
        sb.append(entityName +".setCreateBy(userId);\n");
        sb.append("        " + entityName +".setCreated(new Date());\n");
        sb.append("        " + entityName +".setId(idGenerator.getNextId(NoRuleMapCode.UNKNOW_ID_SQUECE));\n");
        sb.append("        this.dao.insert("+ entityName +")" +  ";\n");
        sb.append("        return this.queryDetail(" + entityName + ".getId());");
        return sb.toString();
    }

    private static MethodDesc buildInsertMethod(DomainDesc domain) {
        MethodDesc method = new MethodDesc("add", "添加记录");
        method.addParam(new ParamDesc(NameStringUtils.getCamelName(domain.getName()), domain.getName()));
        method.addParam(new ParamDesc("userId", "Integer"));
        method.setReturnType(domain.getName());
        method.setContent(getInsertContent(domain));
        method.setNeedTransaction(true);
        return method;
    }

    private static String getInsertSelectiveContent(DomainDesc domain) {
        String entityName = NameStringUtils.getCamelName(domain.getName());
        StringBuffer sb = new StringBuffer();
        sb.append(entityName +".setCreateBy(userId);\n");
        sb.append("        " + entityName +".setCreated(new Date());\n");
        sb.append("        " + entityName +".setId(idGenerator.getNextId(NoRuleMapCode.UNKNOW_ID_SQUECE));\n");
        sb.append("        this.dao.insertSelective("+ entityName +")" +  ";\n");
        sb.append("        return this.queryDetail(" + entityName + ".getId());");
        return sb.toString();
    }

    /**
    * @author zhangyx
    * @description 构件查询详情记录方法
    * @date 2018/6/21 15:04
    * @todo
    * @param
    * @return
    * @exception
    */
    private static MethodDesc buildQueryDetalMethod(DomainDesc domain) {
        MethodDesc method = new MethodDesc("queryDetail", "查询详情");
        method.addParam(new ParamDesc("id", "Integer"));
        method.setReturnType(domain.getName());
        method.setContent(getQueryDetailContent(domain));
        return method;
    }

    private static String getQueryDetailContent(DomainDesc domain) {
        StringBuffer sb = new StringBuffer();
        sb.append("return this.dao.selectByPrimaryKey(id);");
        return sb.toString();
    }
}

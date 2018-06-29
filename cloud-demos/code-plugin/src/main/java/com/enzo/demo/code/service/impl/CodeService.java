package com.enzo.demo.code.service.impl;/**
 * Created by LENOVO on 2018/6/12.
 */

import com.enzo.demo.code.entity.*;
import com.enzo.demo.code.exception.SchemaException;
import com.enzo.demo.code.generator.helper.FreemarkerHelper;
import com.enzo.demo.code.service.ICodeService;
import com.enzo.demo.code.service.ISchemaService;
import com.enzo.demo.code.utils.DaoConstructor;
import com.enzo.demo.code.utils.ServiceConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author zhangyx
 * @desccription 代码生成相关服务
 * @date 2018-06-2018/6/12-19:43
 */
@Service
public class CodeService implements ICodeService {

    @Autowired
    private ISchemaService schemaService;
    @Autowired
    private FreemarkerHelper tmpHelper;

    @Override
    public DomainDesc queryRelationDefaultDomainDesc(String schema, String relationName, String packageName) throws SchemaException, IOException {
        Relation relation = this.schemaService.queryRelation(schema, relationName);
        DomainDesc domain = new DomainDesc(relation);
        domain.setPackageName(packageName);
        DaoDesc daoDesc = DaoConstructor.construct(domain);
        ServiceDesc serviceDesc = ServiceConstructor.construct(domain);
        domain.addFile("domian", (tmpHelper.getDomainFile(domain).getString()));
        domain.addFile("dao", (tmpHelper.getDaoFile(daoDesc).getString()));
        domain.addFile("mapper", (tmpHelper.getMapperFile(daoDesc).getString()));
        domain.addFile("i-service", (tmpHelper.getIserviceFile(serviceDesc).getString()));
        domain.addFile("service", (tmpHelper.getServiceFile(serviceDesc).getString()));
        return domain;
    }

    @Override
    public DomainDesc queryDomianQueryList(String schema, String relationName, DomainClause data) throws SchemaException {
        Relation relation = this.schemaService.queryRelation(schema, relationName);
        DomainDesc domain = new DomainDesc(relation);
        Assert.isTrue(data != null && data.getPackageName() != null && data.getQueryProperties() != null && data.getClauses() != null
                && data.getClauses().size() > 0 && data.getQueryProperties().size() > 0, "请求数据不完整");
        domain.setPackageName(data.getPackageName());
        for(DomainProperty property: domain.getProperties()){
            String name = property.getName();
            if(data.getQueryProperties().contains(name)) property.setQuery(true);
            if(data.getClauses().contains(name)) property.setClause(true);
        }
        Map<String, String> queryListDesc = tmpHelper.getQueryListDesc(domain);
        domain.getFiles().putAll(queryListDesc);
        return domain;
    }
}

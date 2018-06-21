package com.enzo.demo.code.service.impl;/**
 * Created by LENOVO on 2018/6/12.
 */

import com.enzo.demo.code.entity.DaoDesc;
import com.enzo.demo.code.entity.DomainDesc;
import com.enzo.demo.code.entity.Relation;
import com.enzo.demo.code.entity.ServiceDesc;
import com.enzo.demo.code.exception.SchemaException;
import com.enzo.demo.code.generator.helper.FreemarkerHelper;
import com.enzo.demo.code.service.ICodeService;
import com.enzo.demo.code.service.ISchemaService;
import com.enzo.demo.code.utils.DaoConstructor;
import com.enzo.demo.code.utils.ServiceConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * @author zhangyx
 * @desccription 代码生成相关服务
 * @date 2018-06-2018/6/12-19:43
 */
@Service
public class CodeService implements ICodeService{

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
        File entityFile = tmpHelper.getDomainFile(domain);
        File daoFile = tmpHelper.getDaoFile(daoDesc);
        File mapperFile = tmpHelper.getMapperFile(daoDesc);
        File iserviceFile = tmpHelper.getIserviceFile(serviceDesc);
        File serviceFile = tmpHelper.getServiceFile(serviceDesc);
        return domain;
    }
}

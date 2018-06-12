package com.enzo.demo.code.service.impl;/**
 * Created by LENOVO on 2018/6/12.
 */

import com.enzo.demo.code.entity.DomainDesc;
import com.enzo.demo.code.entity.Relation;
import com.enzo.demo.code.exception.SchemaException;
import com.enzo.demo.code.service.ICodeService;
import com.enzo.demo.code.service.ISchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangyx
 * @desccription 代码生成相关服务
 * @date 2018-06-2018/6/12-19:43
 */
@Service
public class CodeService implements ICodeService{

    @Autowired
    private ISchemaService schemaService;

    @Override
    public DomainDesc queryRelationDefaultDomainDesc(String schema, String relationName) throws SchemaException {
        Relation relation = this.schemaService.queryRelation(schema, relationName);
        DomainDesc domain = new DomainDesc(relation);
        return null;
    }
}

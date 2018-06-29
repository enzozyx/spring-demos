package com.enzo.demo.code.service.impl;/**
 * Created by LENOVO on 2018/5/28.
 */

import com.enzo.demo.code.dao.RelationDao;
import com.enzo.demo.code.entity.RelationField;
import com.enzo.demo.code.entity.Relation;
import com.enzo.demo.code.exception.SchemaException;
import com.enzo.demo.code.service.ISchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangyx
 * @desccription
 * @date 2018-05-2018/5/28-18:44
 */
@Service("postgresqlService")
public class PGRelationService implements ISchemaService {

    @Autowired
    private RelationDao dao;
    @Override
    public List<Relation> queryRelations(String schema) throws SchemaException {
        if(schema != null && !schema.isEmpty()){
            return this.dao.selectSchemaRelations(schema);
        }
        throw new SchemaException(SchemaException.EXCEPTION_MESSAGE_INCORRECT_SCHEMA_NAME, SchemaException.EXCEPTION_MINOR_CODE_INCORRECT_SCHEMA_NAME);
    }

    @Override
    public Relation queryRelation(String schema, String name) throws SchemaException {
        Relation relation = new Relation(schema, name);
        if(schema != null && !schema.isEmpty() && name != null && !name.isEmpty()){
            List<RelationField> fields = this.dao.selectRelationFields(schema, name);
            relation.setFields(fields);
            return relation;
        }
        throw new SchemaException(SchemaException.EXCEPTION_MESSAGE_INCORRECT_SCHEMA_NAME_OR_RELATION_NAME, SchemaException.EXCEPTION_MINOR_CODE_INCORRECT_SCHEMA_NAME_OR_RELATION_NAME);
    }
}

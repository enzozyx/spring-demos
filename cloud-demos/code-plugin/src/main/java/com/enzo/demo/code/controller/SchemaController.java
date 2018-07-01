package com.enzo.demo.code.controller;
/**
 * Created by LENOVO on 2018/5/29.
 */

import com.enzo.demo.code.entity.Relation;
import com.enzo.demo.code.exception.SchemaException;
import com.enzo.demo.code.service.ISchemaService;
import com.enzo.demo.common.enums.CodeAndMessageEnum;
import com.enzo.demo.common.entity.base.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhangyx
 * @desccription
 * @date 2018-05-2018/5/29-9:05
 */
@RestController
@RequestMapping(value = "/schema")
public class SchemaController {

    @Autowired
    @Qualifier("postgresqlService")
    private ISchemaService service;

    /**
    * @author zhangyx
    * @description 查询schema上的所有关系表
    * @date 2018/5/29 9:31
    * @todo
    * @param name schema名
    * @return
    * @exception
    */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<Relation>> queryAllRelations(@PathVariable String name){
        List<Relation> relations = null;
        ResponseEntity<List<Relation>> response = null;
        try {
            relations = this.service.queryRelations(name);
            response = new ResponseEntity(CodeAndMessageEnum.SUCCESS, relations);
        } catch (SchemaException e) {
            e.printStackTrace();
            response = new ResponseEntity<List<Relation>>(e.getCodeAndMessage());
        }
        return response;
    }

    /**
    * @author zhangyx
    * @description 查询指定schema.relation 的详细信息
    * @date 2018/5/29 9:31
    * @todo
    * @param schema schema 名称
    * @param name 关系名
    * @return
    * @exception
    */
    @RequestMapping(value = "/{schema}/{name}", method = RequestMethod.GET)
    public ResponseEntity<Relation> queryRelation(@PathVariable String schema, @PathVariable String name){
        Relation relation = null;
        ResponseEntity<Relation> response = null;
        try {
            relation = this.service.queryRelation(schema, name);
            response = new ResponseEntity<Relation>(CodeAndMessageEnum.SUCCESS, relation);
        } catch (SchemaException e) {
            e.printStackTrace();
            response = new ResponseEntity<Relation>(e.getCodeAndMessage());
        }
        return response;
    }
}



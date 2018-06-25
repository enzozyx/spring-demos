package com.enzo.demo.common.code.service;/**
 * Created by LENOVO on 2018/5/28.
 */

import com.enzo.demo.common.code.entity.Relation;
import com.enzo.demo.common.code.exception.SchemaException;

import java.util.List;

/**
 * @author zhangyx
 * @desccription 关系数据库服务
 * @date 2018-05-2018/5/28-18:40
 */
public interface ISchemaService {

    /**
    * @author zhangyx
    * @description 查询schema下所有关系表信息
    * @date 2018/5/28 18:42
    * @todo
    * @param schema schema名
    * @return 
    * @exception 
    */
    public List<Relation> queryRelations(String schema) throws SchemaException;
    /**
     * @author zhangyx
     * @description
     * @date 2018/5/28 18:43
     * @todo
     * @param schema schema名
     * @param  name 关系表名
     * @return
     * @exception
     */
    public Relation queryRelation(String schema, String name) throws SchemaException;
}

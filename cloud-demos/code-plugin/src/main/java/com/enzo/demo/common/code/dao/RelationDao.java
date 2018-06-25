package com.enzo.demo.common.code.dao;/**
 * Created by LENOVO on 2018/5/28.
 */

import com.enzo.demo.common.code.entity.Relation;
import com.enzo.demo.common.code.entity.RelationField;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhangyx
 * @desccription
 * @date 2018-05-2018/5/28-18:45
 */
public interface RelationDao {
    
    /**
    * @author zhangyx
    * @description 查询schema下所有的关系表
    * @date 2018/5/29 9:47
    * @todo
    * @param 
    * @return 
    * @exception 
    */
    List<Relation> selectSchemaRelations(@Param("schema") String schema);

    /**
    * @author zhangyx
    * @description 查询关系表信息
    * @date 2018/5/29 10:17
    * @todo
    * @param schema schema 名
    * @param name 关系名
    * @return
    * @exception 
    */
    List<RelationField> selectRelationFields(@Param("schema") String schema, @Param("name") String name);
}

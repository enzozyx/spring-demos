package com.enzo.demo.code.service;/**
 * Created by LENOVO on 2018/6/12.
 */

import com.enzo.demo.code.entity.DomainClause;
import com.enzo.demo.code.entity.DomainDesc;
import com.enzo.demo.code.exception.SchemaException;

import java.io.IOException;

/**
 * @author zhangyx
 * @desccription 代码服务
 * @date 2018-06-2018/6/12-19:41
 */
public interface ICodeService {

    /**
    * @author zhangyx
    * @description 依据schema、关系名获取系统自动生成的实体描述信息
    * @date 2018/6/12 19:41
    * @todo
    * @param schema
    * @param relation
    * @param packageName
     * @return
    * @exception
    */
    public DomainDesc queryRelationDefaultDomainDesc(String schema, String relation, String packageName) throws SchemaException, IOException;
    /**
    * @author zhangyx
    * @description 查询列表代码生成
    * @date 2018/6/29 17:08
    * @todo
    * @param
    * @return
    * @exception
    */
    DomainDesc queryDomianQueryList(String schema, String relation, DomainClause data) throws SchemaException;
}

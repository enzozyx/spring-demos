package com.enzo.demo.code.service;/**
 * Created by LENOVO on 2018/6/12.
 */

import com.enzo.demo.code.entity.DomainDesc;
import com.enzo.demo.code.exception.SchemaException;

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
    * @return
    * @exception
    */
    public DomainDesc queryRelationDefaultDomainDesc(String schema, String relation) throws SchemaException;
}

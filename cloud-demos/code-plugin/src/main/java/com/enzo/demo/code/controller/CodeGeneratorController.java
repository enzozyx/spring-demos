package com.enzo.demo.code.controller;/**
 * Created by LENOVO on 2018/6/12.
 */

import com.enzo.demo.code.entity.DomainClause;
import com.enzo.demo.code.entity.DomainDesc;
import com.enzo.demo.code.exception.SchemaException;
import com.enzo.demo.code.service.ICodeService;
import com.enzo.demo.common.entity.base.RequestData;
import com.enzo.demo.common.enums.CodeAndMessageEnum;
import com.enzo.demo.common.entity.base.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author zhangyx
 * @desccription 代码生成rest服务
 * @date 2018-06-2018/6/12-19:32
 */
@RestController
@RequestMapping("/code")
public class CodeGeneratorController {


    @Autowired
    private ICodeService codeService;


    /**
    * @author zhangyx
    * @description 查询指定table 默认的entity dao mapper service 实现
    * @date 2018/6/29 dao
    * @todo
    * @param
    * @return
    * @exception
    */
    @RequestMapping(value = "/default/{schema}/{relation}", method = RequestMethod.GET)
    public ResponseEntity<DomainDesc> queryDefaultDomainByRelation(@PathVariable String schema,
                                                                   @PathVariable String relation,
                                                                   @RequestParam String packageName) throws SchemaException, IOException {
        DomainDesc domain = this.codeService.queryRelationDefaultDomainDesc(schema, relation,packageName);
        return new ResponseEntity<DomainDesc>(CodeAndMessageEnum.SUCCESS, domain);
    }

    @RequestMapping(value = "/query/list/{schema}/{relation}", method = RequestMethod.POST)
    public ResponseEntity<DomainDesc> parseQueryList(@PathVariable String schema,
                                                     @PathVariable String relation,
                                                     @RequestBody RequestData<DomainClause> requestData) throws SchemaException {
        DomainDesc domain = this.codeService.queryDomianQueryList(schema, relation, requestData.getData());
        return new ResponseEntity<DomainDesc>(CodeAndMessageEnum.SUCCESS, domain);
    }


}

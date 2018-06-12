package com.enzo.demo.code.controller;/**
 * Created by LENOVO on 2018/6/12.
 */

import com.enzo.demo.code.entity.DomainDesc;
import com.enzo.demo.code.exception.SchemaException;
import com.enzo.demo.code.service.ICodeService;
import com.enzo.demo.entity.base.ResponseEntity;
import com.enzo.demo.enums.CodeAndMessageEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


    @RequestMapping(value = "/domain/default", method = RequestMethod.GET)
    public ResponseEntity<DomainDesc> queryDefaultDomainByRelation(@RequestParam String schema, @RequestParam String relation) throws SchemaException {
        DomainDesc domain = this.codeService.queryRelationDefaultDomainDesc(schema, relation);
        return new ResponseEntity<DomainDesc>(CodeAndMessageEnum.SUCCESS, domain);
    }
}

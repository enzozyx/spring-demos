package ${domain.packageName}.service.impl;
/**
 * Created by enzo on ${domain.date?string("yyyy-MM-dd HH:mm:ss")}.
 */

import ${domain.packageName}.entity.${domain.name};
import ${domain.packageName}.dao.${domain.name}Dao;
import ${domain.packageName}.service.I${domain.name}Service;

import java.util.*;
import java.lang.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.huajie.bim.common.service.IUIdGenerator;
import com.huajie.bim.common.config.NoRuleMapCode;

/**
 * @author enzo
 * @desccription ${desc!}
 * @date ${domain.date?string("yyyy-MM-dd HH:mm:ss")}
 */
@Service
public class ${domain.name}Service implements I${domain.name}Service{

    private static Logger log = LoggerFactory.getLogger(${domain.name}Service.class);
    @Autowired
    private ${domain.name}Dao dao;
    @Autowired
    private IUIdGenerator idGenerator;

    <#list methods as m>
    /**
    * @author enzo
    * @description ${m.desc!}
    * @date ${domain.date?string("yyyy-MM-dd HH:mm:ss")}
    * @todo
    <#if m.params??>
    <#list m.params as p>
    * @param ${p.name} ${p.type}
    </#list>
    </#if>
    * @return
    * @exception
    */
    <#if m.needTransaction==true>@Transactional</#if>
    public ${m.returnType} ${m.name}(<#if m.params??><#list m.params as p> ${p.type} ${p.name}<#if p_has_next>,</#if></#list></#if>){
        <#if m.content??>${m.content}<#else>return null;</#if>
    }
    </#list>
}
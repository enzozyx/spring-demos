package ${domain.packageName}.service;
/**
 * Created by enzo on ${domain.date?string("yyyy-MM-dd HH:mm:ss")}.
 */

import ${domain.packageName}.entity.${domain.name};

import java.util.*;
import java.lang.*;

/**
 * @author enzo
 * @desccription ${desc!}
 * @date ${domain.date?string("yyyy-MM-dd HH:mm:ss")}
 */
public interface I${domain.name}Service {

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
    public ${m.returnType} ${m.name}(<#if m.params??><#list m.params as p> ${p.type} ${p.name}<#if p_has_next>,</#if></#list></#if>);
    </#list>
}
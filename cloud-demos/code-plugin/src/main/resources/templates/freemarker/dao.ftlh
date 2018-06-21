package ${domain.packageName}.dao;
/**
 * Created by enzo code plugin ${domain.date?string("yyyy-MM-dd HH:mm:ss")}
 */

import java.lang.*;
import java.util.*;
import ${domain.packageName}.entity.${domain.name};
import org.apache.ibatis.annotations.Param;

/**
 * @author enzo
 * @desccription
 * @date ${domain.date?string("yyyy-MM-dd HH:mm:ss")}
 */
public interface ${domain.name}Dao {

    <#list methods as m>
    /**
    * @author enzo
    * @description ${m.desc!}
    * @date ${domain.date?string("yyyy-MM-dd HH:mm:ss")}
    * @todo ${m.desc!}
    * @param
    * @return
    * @exception
    */
    public ${m.returnType} ${m.name}(<#if m.params??><#list m.params as p><#if p.ibatisName??>@Param("${p.ibatisName}") </#if>${p.type} ${p.name}<#if p_has_next></#if></#list></#if>);
    </#list>
}
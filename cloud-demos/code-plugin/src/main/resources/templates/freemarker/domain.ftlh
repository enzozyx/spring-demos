package ${packageName}.entity;
/**
 * Created by enzo code plugin ${date?string("yyyy-MM-dd HH:mm:ss")}
 */

import java.lang.*;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author enzo
 * @desccription
 * @date ${date?string("yyyy-MM-dd HH:mm:ss")}
 */
public class ${name}  implements Serializable{

    private static final long serialVersionUID = -1L;

    private Logger log = LoggerFactory.getLogger(${name}.class);

    <#list properties as p>
    /**
    * ${p.field.comment!}
    */
    @JsonProperty("${p.field.name}")
    private ${p.type} ${p.name};
    </#list>

    <#list properties as p>

    public void ${p.setter}(${p.type} ${p.name}){
        this.${p.name} = ${p.name};
    }
    <#if p.field.jdbcType =="timestamp">@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")</#if>
    <#if p.field.jdbcType =="date">@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")</#if>
    public ${p.type} ${p.getter}(){
        return this.${p.name};
    }
    </#list>

    <#list properties as p>
        <#if p.constaints??>
            <#list p.constaints as c>
                <#if c.type == "not_null">
    /**
    * ${p.name} 非空校验
    */
    public ${name} ${p.name}NotNull() throws Exception {
        if(this.${p.name} != null){
            return this;
        }
        log.warn("${name}`s property ${p.name} is null");
        throw new Exception("property ${p.name} can`t be null");
    }
                </#if>
             </#list>
        </#if>
    </#list>
}

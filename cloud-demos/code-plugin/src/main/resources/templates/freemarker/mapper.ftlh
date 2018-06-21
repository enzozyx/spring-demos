<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${domain.packageName}.dao.${domain.name}Dao">

    <resultMap id="${domain.name}Map" type="${domain.packageName}.entity.${domain.name}">
        <#list domain.properties as p>
        <#if p.name=="id">
        <id column="${p.field.name}" property="${p.name}" jcbdType="${p.typeAlias}"/>
        <#else>
        <result column="${p.field.name}" property="${p.name}" jcbdType="${p.typeAlias}"/>
        </#if>
        </#list>
    </resultMap>

    <sql id="${domain.name}Field">
        <#list domain.properties as p>
        ${p.field.name}<#if p_has_next >,</#if>
        </#list>
    </sql>

    <sql id="InsertNotNullField">
        <#list domain.properties as p>
        <#if p.field.notNull==true>${p.field.name}<#if p_has_next >,</#if></#if>
        </#list>
    </sql>

    <sql id="InsertNotNullVals">
        <#list domain.properties as p>
        <#if p.field.notNull==true><#if p.name=="created">now()<#else>${r'#{'}${p.name}${r'}'}</#if><#if p_has_next >,</#if></#if>
        </#list>
    </sql>

    <sql id="InsertField">
        <trim suffixOverrides=",">
        <#list domain.properties as p>
        <#if p.name=="created">created,<#else><if test="${p.name} != null"> ${p.field.name},</if></#if>
        </#list>
        </trim>
    </sql>

    <sql id="InsertVals">
        <trim suffixOverrides=",">
        <#list domain.properties as p>
        <#if p.name="created">now(),<#else><if test="${p.name} != null">${r'#{'}${p.name}${r'}'},</if></#if>
        </#list>
        </trim>
    </sql>

    <sql id="UpdateField">
        <set>
            <#list domain.properties as p>
            <#if p.name="updated">updated = now(),<#else><if test="${p.name} != null">${p.field.name} = ${r'#{'}${p.name}${r'}'},</if></#if>
            </#list>
        </set>
    </sql>

    <#list methods as m>

    <#if m.desc??><!-- ${m.desc!} --></#if>
    ${m.parse!}
    </#list>

</mapper>
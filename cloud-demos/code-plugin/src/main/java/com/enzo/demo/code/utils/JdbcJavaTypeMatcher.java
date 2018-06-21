package com.enzo.demo.code.utils;/**
 * Created by LENOVO on 2018/6/12.
 */

import com.enzo.demo.code.enums.DatabaseTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyx
 * @desccription 数据类型映射工具
 * @date 2018-06-2018/6/12-20:28
 */
public class JdbcJavaTypeMatcher {

    private static Logger log = LoggerFactory.getLogger(JdbcJavaTypeMatcher.class);

    private static Map<String, String> pgTypeMap = new HashMap<String, String>(){{
        put("timestamp", "Date");
        put("int4", "Integer");
        put("int2", "Short");
        put("varchar", "String");
        put("date", "Date");
    }};

    private static Map<String, String> pgTypeAliasMap = new HashMap<String, String>(){{
        put("timestamp", "TIMAESTAMP");
        put("int4", "INTEGER");
        put("int2", "SMALLINT");
        put("varchar", "VARCHAR");
        put("date", "DATE");
    }};

    /**
    * @author zhangyx
    * @description 依据数据库类型与jdbc Type 匹配合适的Java type类型
    * @date 2018/6/12 20:33
    * @todo
    * @param dbType 数据库类型
    * @param jdbcType 数据库对应jdbc 类型
    * @return
    * @exception
    */
    public static String matchJavaType(DatabaseTypeEnum dbType , String jdbcType){
        String type = "String";//默认String
        if(dbType == DatabaseTypeEnum.POSTGRESQL){
            if(pgTypeMap.containsKey(jdbcType)){
                type = pgTypeMap.get(jdbcType);
            }else{
                log.warn("无法识别的jdbc 类型: " + jdbcType);
            }
        }else {
            log.warn("暂不支持的数据库类型" + dbType);
        }
        return type;
    }

    public static String matchMybatisJdbcType(DatabaseTypeEnum dbType , String jdbcType){
        String typeAlias = "VARCHAR";//默认String
        if(dbType == DatabaseTypeEnum.POSTGRESQL){
            if(pgTypeAliasMap.containsKey(jdbcType)){
                typeAlias = pgTypeAliasMap.get(jdbcType);
            }else{
                log.warn("无法识别的jdbc 类型: " + jdbcType);
            }
        }else {
            log.warn("暂不支持的数据库类型" + dbType);
        }
        return typeAlias;
    }
}

package com.enzo.demo.code.utils;/**
 * Created by LENOVO on 2018/6/12.
 */

/**
 * @author zhangyx
 * @desccription
 * @date 2018-06-2018/6/12-20:15
 */
public class NameStringUtils {

    /**
    * @author zhangyx
    * @description 获取标注实体名 首字母大写、下划线及后面字符转大写
    * @date 2018/6/12 20:19
    * @todo
    * @param 
    * @return 
    * @exception 
    */
    public static String getNormalName(String origin){
        if(origin != null && origin.length() > 0) {
            origin = getCamelName(origin);
            // TODO: 2018/6/12 首字母大写
            origin = origin.substring(0, 1).toUpperCase() + origin.substring(1);
        }
        return origin;
    }

    /**
    * @author zhangyx
    * @description 获取驼峰名
    * @date 2018/6/12 20:28
    * @todo
    * @param 
    * @return 
    * @exception 
    */
    public static String getCamelName(String origin){
        if(origin != null && origin.length() > 0) {
            // TODO: 2018/6/12 如果是下划线，则转驼峰
            while(origin.indexOf("_") > 0){
                int index = origin.indexOf("_");
                char c = origin.charAt(index);
                if(c >= 'A' && c <= 'Z'){
                    c += 32;
                }
                origin = origin.substring(0, index) + c + origin.substring(index + 1);
            }
        }
        return origin;
    }
}

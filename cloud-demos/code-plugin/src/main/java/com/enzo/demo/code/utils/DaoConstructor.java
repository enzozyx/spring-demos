package com.enzo.demo.code.utils;/**
 * Created by LENOVO on 2018/6/21.
 */

import com.enzo.demo.code.entity.DaoDesc;
import com.enzo.demo.code.entity.MethodDesc;
import com.enzo.demo.code.entity.DomainDesc;
import com.enzo.demo.code.entity.ParamDesc;
import com.enzo.demo.code.enums.MapperMethodTypeEnum;

/**
 * @author zhangyx
 * @desccription dao方法构件工具
 * @date 2018-06-2018/6/21-10:31
 */
public class DaoConstructor {

    public static DaoDesc construct(DomainDesc domain){
        DaoDesc daoDesc = new DaoDesc(domain);
        // TODO: 2018/6/21 构造方法
        //1. 依据主键查询记录
        MethodDesc selectMethod = new MethodDesc("selectByPrimaryKey", "依据主键查询详情", MapperMethodTypeEnum.SELECT);
        selectMethod.setReturnType(domain.getName());
        selectMethod.addParam(new ParamDesc("id", "id", "Integer"));
        buildSelectByPrimaryKeyParse(selectMethod, domain);
        daoDesc.addMethod(selectMethod);
        //2. 依据非空约束构件插入方法
        MethodDesc insertMethod = new MethodDesc("insert", "新增记录(只导入必填字段)", MapperMethodTypeEnum.INSERT);
        insertMethod.setReturnType("Integer");
        insertMethod.addParam(new ParamDesc(NameStringUtils.getCamelName(domain.getName()), null, domain.getName()));
        buildInserParse(insertMethod, domain);
        daoDesc.addMethod(insertMethod);
        //3. 所有字段可选插入
        MethodDesc insertSelectiveMethod = new MethodDesc("insertSelective", "新增记录(导入填写字段)", MapperMethodTypeEnum.INSERT);
        insertSelectiveMethod.setReturnType("Integer");
        insertSelectiveMethod.addParam(new ParamDesc(NameStringUtils.getCamelName(domain.getName()), null, domain.getName()));
        buildInserSelectiveParse(insertSelectiveMethod, domain);
        daoDesc.addMethod(insertSelectiveMethod);
        //4. 依据ID所有字段可选更新
        MethodDesc updateMethod = new MethodDesc("update", "依据ID更新填写字段", MapperMethodTypeEnum.UPDATE);
        updateMethod.setReturnType("Integer");
        updateMethod.addParam(new ParamDesc(NameStringUtils.getCamelName(domain.getName()), null, domain.getName()));
        buildUpdateParse(updateMethod, domain);
        daoDesc.addMethod(updateMethod);
        //5. 依据id删除记录
        MethodDesc deleteMethod = new MethodDesc("delete", "依据ID删除记录", MapperMethodTypeEnum.DELETE);
        deleteMethod.setReturnType("Integer");
        deleteMethod.addParam(new ParamDesc("id", "id", "Integer"));
        daoDesc.addMethod(deleteMethod);
        buildDeleteParse(deleteMethod, domain);
        return daoDesc;
    }

    /**
    * @author zhangyx
    * @description 构造删除短语
    * @date 2018/6/21 14:29
    * @todo
    * @param
    * @return
    * @exception
    */
    private static void buildDeleteParse(MethodDesc method, DomainDesc domain) {
        StringBuffer sb = new StringBuffer();
        sb.append("<delete id=\"" + method.getName() + "\" parameterType=\"java.lang.Integer\"> \n");
        sb.append("    delete from " + domain.getRelation().getSchema() + "." + domain.getRelation().getName() + "\n");
        sb.append("    where id = #{id} \n");
        sb.append("    </delete>");
        method.setParse(sb.toString());
    }

    /**
    * @author zhangyx
    * @description 构造更新短语
    * @date 2018/6/21 14:18
    * @todo
    * @param
    * @return
    * @exception
    */
    private static void buildUpdateParse(MethodDesc method, DomainDesc domain) {
        StringBuffer sb = new StringBuffer();
        sb.append("<update id=\"" + method.getName() + "\" parameterType=\""+ domain.getPackageName() + ".entity." + domain.getName() +"\"> \n");
        sb.append("    update " + domain.getRelation().getSchema() + "." + domain.getRelation().getName());
        sb.append(" <include refid=\"UpdateField\"/> \n");
        sb.append("    where id = #{id} \n");
        sb.append("    </update>");
        method.setParse(sb.toString());
    }

    /**
    * @author zhangyx
    * @description 构件插入短语
    * @date 2018/6/21 11:54
    * @todo
    * @param 
    * @return 
    * @exception 
    */
    private static void buildInserParse(MethodDesc method, DomainDesc domain) {
        StringBuffer sb = new StringBuffer();
        sb.append("<insert id=\"" + method.getName() + "\" parameterType=\""+ domain.getPackageName() + ".entity." + domain.getName() +"\"> \n");
        sb.append("    insert into " + domain.getRelation().getSchema() + "." + domain.getRelation().getName() + "(");
        sb.append("<include refid=\"InsertNotNullField\"/> ");
        sb.append(") \n");
        sb.append("    values (");
        sb.append("<include refid=\"InsertNotNullVals\"/> )\n");
        sb.append("    </insert>");
        method.setParse(sb.toString());
    }

    /**
     * @author zhangyx
     * @description 构件插入短语
     * @date 2018/6/21 11:54
     * @todo
     * @param
     * @return
     * @exception
     */
    private static void buildInserSelectiveParse(MethodDesc method, DomainDesc domain) {
        StringBuffer sb = new StringBuffer();
        sb.append("<insert id=\"" + method.getName() + "\" parameterType=\""+ domain.getPackageName() + ".entity." + domain.getName() +"\"> \n");
        sb.append("    insert into " + domain.getRelation().getSchema() + "." + domain.getRelation().getName() + "(");
        sb.append("<include refid=\"InsertField\"/> ");
        sb.append(") \n");
        sb.append("    values (");
        sb.append("<include refid=\"InsertVals\"/> )\n");
        sb.append("    </insert>");
        method.setParse(sb.toString());
    }

    /**
    * @author zhangyx
    * @description 构件查询语句
    * @date 2018/6/21 11:45
    * @todo
    * @param
    * @return
    * @exception
    */
    private static void buildSelectByPrimaryKeyParse(MethodDesc method, DomainDesc domain) {
        StringBuffer sb = new StringBuffer();
        sb.append("<select id=\"" + method.getName() + "\" parameterType=\"java.lang.Integer\" resultMap=\""+ domain.getName() +"Map\"> \n");
        sb.append("    select ");
        sb.append("<include refid=\""+ domain.getName() + "Field\"/> ");
        sb.append("from ");
        sb.append(domain.getRelation().getSchema() + "." + domain.getRelation().getName() + " \n");
        sb.append("    where id = #{id} \n");
        sb.append("    </select>");
        method.setParse(sb.toString());
    }

}

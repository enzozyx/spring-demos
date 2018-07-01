package com.enzo.demo.springcloud.server.user.dao;
/**
 * Created by enzo code plugin 2018-06-25 18:37:21
 */

import java.lang.*;

import com.enzo.demo.springcloud.server.user.entity.UserAuthorize;
import org.apache.ibatis.annotations.Param;

/**
 * @author enzo
 * @desccription
 * @date 2018-06-25 18:37:21
 */
public interface UserAuthorizeDao {

    /**
    * @author enzo
    * @description 依据主键查询详情
    * @date 2018-06-25 18:37:21
    * @todo 依据主键查询详情
    * @param
    * @return
    * @exception
    */
    public UserAuthorize selectByPrimaryKey(@Param("id") Integer id);
    /**
    * @author enzo
    * @description 新增记录(只导入必填字段)
    * @date 2018-06-25 18:37:21
    * @todo 新增记录(只导入必填字段)
    * @param
    * @return
    * @exception
    */
    public Integer insert(UserAuthorize userAuthorize);
    /**
    * @author enzo
    * @description 新增记录(导入填写字段)
    * @date 2018-06-25 18:37:21
    * @todo 新增记录(导入填写字段)
    * @param
    * @return
    * @exception
    */
    public Integer insertSelective(UserAuthorize userAuthorize);
    /**
    * @author enzo
    * @description 依据ID更新填写字段
    * @date 2018-06-25 18:37:21
    * @todo 依据ID更新填写字段
    * @param
    * @return
    * @exception
    */
    public Integer update(UserAuthorize userAuthorize);
    /**
    * @author enzo
    * @description 依据ID删除记录
    * @date 2018-06-25 18:37:21
    * @todo 依据ID删除记录
    * @param
    * @return
    * @exception
    */
    public Integer delete(@Param("id") Integer id);
    /**
    * @author zhangyx
    * @description 依据用户名查询用户账户信息
    * @date 2018/6/25 19:02
    * @todo
    * @param username
    * @return
    * @exception
    */
    UserAuthorize selectAuthorizeByUsername(@Param("username") String username);
}
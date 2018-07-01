package com.enzo.demo.springcloud.server.user.service;
/**
 * Created by enzo on 2018-06-25 18:37:21.
 */


import com.enzo.demo.springcloud.server.user.entity.UserAuthorize;

import java.lang.*;

/**
 * @author enzo
 * @desccription 服务描述
 * @date 2018-06-25 18:37:21
 */
public interface IUserAuthorizeService {

    /**
    * @author enzo
    * @description 查询详情
    * @date 2018-06-25 18:37:21
    * @todo
    * @param id Integer
    * @return
    * @exception
    */
    public UserAuthorize queryDetail(Integer id);
    /**
    * @author enzo
    * @description 添加记录
    * @date 2018-06-25 18:37:21
    * @todo
    * @param userAuthorize UserAuthorize
    * @param userId Integer
    * @return
    * @exception
    */
    public UserAuthorize add(UserAuthorize userAuthorize, Integer userId);
    /**
    * @author enzo
    * @description 添加记录
    * @date 2018-06-25 18:37:21
    * @todo
    * @param userAuthorize UserAuthorize
    * @param userId Integer
    * @return
    * @exception
    */
    public UserAuthorize addSelective(UserAuthorize userAuthorize, Integer userId);
    /**
    * @author enzo
    * @description 更新记录
    * @date 2018-06-25 18:37:21
    * @todo
    * @param userAuthorize UserAuthorize
    * @param userId Integer
    * @return
    * @exception
    */
    public UserAuthorize update(UserAuthorize userAuthorize, Integer userId);
    /**
    * @author enzo
    * @description 删除记录
    * @date 2018-06-25 18:37:21
    * @todo
    * @param id Integer
    * @param userId Integer
    * @return
    * @exception
    */
    public UserAuthorize delete(Integer id, Integer userId);
    /**
    * @author zhangyx
    * @description 用户登陆
    * @date 2018/6/25 18:59
    * @todo
     * 1. 用户提交用户名于密码，验证通过后返回token
    * @param
    * @return
    * @exception
    */
    String login(UserAuthorize userAuthorize);
}
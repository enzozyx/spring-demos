package com.enzo.demo.springcloud.server.user.service;/**
 * Created by LENOVO on 2018/5/22.
 */

import com.enzo.demo.entity.sys.User;

/**
 * @author zhangyx
 * @desccription 用户服务
 * @date 2018-05-2018/5/22-12:01
 */
public interface IUserService {

    /**
    * @author zhangyx
    * @description 通过用户名查询用户信息
    * @date 2018/5/22 14:19
    * @todo
    * @param username 用户名
    * @return
    * @exception
    */
    User queryUserByName(String username) throws Exception;
}

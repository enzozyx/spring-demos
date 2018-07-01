package com.enzo.demo.springcloud.server.user.controller;/**
 * Created by LENOVO on 2018/5/22.
 */

import com.enzo.demo.springcloud.server.user.entity.UserAuthorize;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

/**
 * @author zhangyx
 * @desccription 用户控制
 * @date 2018-05-2018/5/22-12:02
 */
public interface IUserController {

    /**
    * @author zhangyx
    * @description 登陆
    * @date 2018/6/25 18:57
    * @todo
    * @param
    * @return
    * @exception
    */
    public ResponseEntity<String> login(HttpEntity<UserAuthorize> userAuthorize);
    /**
    * @author zhangyx
    * @description 注册用户
    * @date 2018/6/25 18:57
    * @todo
    * @param
    * @return
    * @exception
    */
    public ResponseEntity<UserAuthorize> register(HttpEntity<UserAuthorize> userAuthorize);
}

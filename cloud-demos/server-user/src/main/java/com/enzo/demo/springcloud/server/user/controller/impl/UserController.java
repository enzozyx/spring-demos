package com.enzo.demo.springcloud.server.user.controller.impl;/**
 * Created by LENOVO on 2018/5/22.
 */

import com.enzo.demo.entity.sys.User;
import com.enzo.demo.springcloud.server.user.controller.IUserController;
import com.enzo.demo.springcloud.server.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangyx
 * @desccription 用户controller
 * @date 2018-05-2018/5/22-12:03
 */
@RestController
public class UserController implements IUserController{

    @Autowired
    private IUserService service;

    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public User getUserInfo(@PathVariable String username) throws Exception {
        return this.service.queryUserByName(username);
    }
}

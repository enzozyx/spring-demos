package com.enzo.demo.springcloud.server.user.controller.impl;/**
 * Created by LENOVO on 2018/5/22.
 */

import com.enzo.demo.springcloud.server.user.entity.UserAuthorize;
import com.enzo.demo.springcloud.server.user.service.IUserAuthorizeService;
import com.enzo.demo.springcloud.server.user.controller.IUserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangyx
 * @desccription 用户controller
 * @date 2018-05-2018/5/22-12:03
 */
@RestController
@RequestMapping("/user")
public class UserController implements IUserController {


    @Autowired
    private IUserAuthorizeService authorizeService;


    @Override
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(HttpEntity<UserAuthorize> userAuthorize) {
        String token = this.authorizeService.login(userAuthorize.getBody());
        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<UserAuthorize> register(HttpEntity<UserAuthorize> data) {
        UserAuthorize authoroze = this.authorizeService.add(data.getBody(), 1);
        return new ResponseEntity<UserAuthorize>(authoroze, HttpStatus.OK);
    }
}

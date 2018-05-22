package com.enzo.demo.springcloud.server.user.service.impl;/**
 * Created by LENOVO on 2018/5/22.
 */

import com.enzo.demo.entity.sys.User;
import com.enzo.demo.springcloud.server.user.dao.UserDao;
import com.enzo.demo.springcloud.server.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangyx
 * @desccription 用户服务
 * @date 2018-05-2018/5/22-12:01
 */
@Service
public class UserService implements IUserService{

    @Autowired
    private UserDao dao;

    @Override
    public User queryUserByName(String username) throws Exception {
        List<User> users = this.dao.selectUserByName(username);
        if(users == null || (users != null && users.size() == 0)){
            throw new Exception("no asign user info that username is " + username);
        }else if(users.size() > 1){
            throw new Exception("there are multi user in database that username is " + username);
        }
        return users.get(0);
    }
}

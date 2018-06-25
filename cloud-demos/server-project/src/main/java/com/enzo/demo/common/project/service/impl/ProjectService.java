package com.enzo.demo.common.project.service.impl;/**
 * Created by LENOVO on 2018/5/22.
 */

import com.enzo.demo.common.entity.sys.User;
import com.enzo.demo.common.project.service.IProjectService;
import com.enzo.demo.common.project.service.providers.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangyx
 * @desccription
 * @date 2018-05-2018/5/22-15:45
 */
@Service
public class ProjectService implements IProjectService {

    @Autowired
    private UserService userService;

    @Override
    public User test(String name) {
        return this.userService.queryUserByName(name);
    }
}

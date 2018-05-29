package com.enzo.demo.project.controller;/**
 * Created by LENOVO on 2018/5/22.
 */

import com.enzo.demo.entity.sys.User;
import com.enzo.demo.project.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangyx
 * @desccription 项目
 * @date 2018-05-2018/5/22-15:43
 */
@RestController
public class ProjectController {
    @Autowired
    private IProjectService service;

    @RequestMapping(value = "project/{name}", method = RequestMethod.GET)
    public User test(@PathVariable String name){
        return this.service.test(name);
    }
}

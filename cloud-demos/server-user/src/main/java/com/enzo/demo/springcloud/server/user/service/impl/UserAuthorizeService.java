package com.enzo.demo.springcloud.server.user.service.impl;
/**
 * Created by enzo on 2018-06-25 18:37:21.
 */

import com.enzo.demo.common.constants.NoRuleMapCode;
import com.enzo.demo.springcloud.server.user.dao.UserAuthorizeDao;
import com.enzo.demo.springcloud.server.user.entity.UserAuthorize;
import com.enzo.demo.springcloud.server.user.service.IUserAuthorizeService;
import com.enzo.demo.common.service.IUIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import java.lang.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author enzo
 * @desccription 服务描述
 * @date 2018-06-25 18:37:21
 */
@Service
public class UserAuthorizeService implements IUserAuthorizeService {

    private static Logger log = LoggerFactory.getLogger(UserAuthorizeService.class);
    @Autowired
    private UserAuthorizeDao dao;
    @Autowired
    private IUIdGenerator<Integer> idGenerator;

    /**
    * @author enzo
    * @description 查询详情
    * @date 2018-06-25 18:37:21
    * @todo
    * @param id Integer
    * @return
    * @exception
    */
    
    public UserAuthorize queryDetail(Integer id){
        return this.dao.selectByPrimaryKey(id);
    }
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
    @Transactional
    public UserAuthorize add( UserAuthorize userAuthorize, Integer userId){
        userAuthorize.setCreateBy(userId);
        userAuthorize.setCreated(new Date());
        userAuthorize.setId(idGenerator.getNextId(NoRuleMapCode.UNKNOW_ID_SQUECE));
        this.dao.insert(userAuthorize);
        return this.queryDetail(userAuthorize.getId());
    }
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
    @Transactional
    public UserAuthorize addSelective( UserAuthorize userAuthorize, Integer userId){
        userAuthorize.setCreateBy(userId);
        userAuthorize.setCreated(new Date());
        userAuthorize.setId(idGenerator.getNextId(NoRuleMapCode.UNKNOW_ID_SQUECE));
        this.dao.insertSelective(userAuthorize);
        return this.queryDetail(userAuthorize.getId());
    }
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
    @Transactional
    public UserAuthorize update( UserAuthorize userAuthorize, Integer userId){
        userAuthorize.setUpdateBy(userId);
        userAuthorize.setUpdated(new Date());
        this.dao.update(userAuthorize);
        return this.queryDetail(userAuthorize.getId());
    }
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
    @Transactional
    public UserAuthorize delete( Integer id, Integer userId){
        UserAuthorize userAuthorize = this.queryDetail(id); 
        this.dao.delete(id);
        return userAuthorize;
    }

    @Override
    public String login(UserAuthorize userAuthorize) {
        UserAuthorize sysUserAuthorize = this.dao.selectAuthorizeByUsername(userAuthorize.getUsername());
        if(sysUserAuthorize != null && userAuthorize.getPassword().equals(sysUserAuthorize.getPassword())){
            return "TOKEN123456";
        }
        return null;
    }
}
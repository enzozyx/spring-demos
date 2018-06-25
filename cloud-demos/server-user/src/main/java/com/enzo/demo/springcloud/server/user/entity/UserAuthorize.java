package com.enzo.demo.springcloud.server.user.entity;
/**
 * Created by enzo code plugin 2018-06-25 18:37:21
 */

import java.lang.*;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author enzo
 * @desccription
 * @date 2018-06-25 18:37:21
 */
public class UserAuthorize {

    private Logger log = LoggerFactory.getLogger(UserAuthorize.class);

    /**
    * 主键ID
    */
    @JsonProperty("id")
    private Integer id;
    /**
    * 用户登陆名
    */
    @JsonProperty("username")
    private String username;
    /**
    * 用户密码
    */
    @JsonProperty("password")
    private String password;
    /**
    * 创建日期
    */
    @JsonProperty("created")
    private Date created;
    /**
    * 创建人ID
    */
    @JsonProperty("create_by")
    private Integer createBy;
    /**
    * 更新时间
    */
    @JsonProperty("updated")
    private Date updated;
    /**
    * 更新人ID
    */
    @JsonProperty("update_by")
    private Integer updateBy;
    /**
    * 账号状态 [0-未激活,1-激活,2-禁用]
    */
    @JsonProperty("state")
    private Short state;


    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setCreated(Date created){
        this.created = created;
    }

    public Date getCreated(){
        return this.created;
    }

    public void setCreateBy(Integer createBy){
        this.createBy = createBy;
    }

    public Integer getCreateBy(){
        return this.createBy;
    }

    public void setUpdated(Date updated){
        this.updated = updated;
    }

    public Date getUpdated(){
        return this.updated;
    }

    public void setUpdateBy(Integer updateBy){
        this.updateBy = updateBy;
    }

    public Integer getUpdateBy(){
        return this.updateBy;
    }

    public void setState(Short state){
        this.state = state;
    }

    public Short getState(){
        return this.state;
    }

    /**
    * id 非空校验
    */
    public UserAuthorize idNotNull() throws Exception {
        if(this.id != null){
            return this;
        }
        log.warn("UserAuthorize`s property id is null");
        throw new Exception("property id can`t be null");
    }
    /**
    * username 非空校验
    */
    public UserAuthorize usernameNotNull() throws Exception {
        if(this.username != null){
            return this;
        }
        log.warn("UserAuthorize`s property username is null");
        throw new Exception("property username can`t be null");
    }
    /**
    * password 非空校验
    */
    public UserAuthorize passwordNotNull() throws Exception {
        if(this.password != null){
            return this;
        }
        log.warn("UserAuthorize`s property password is null");
        throw new Exception("property password can`t be null");
    }
    /**
    * created 非空校验
    */
    public UserAuthorize createdNotNull() throws Exception {
        if(this.created != null){
            return this;
        }
        log.warn("UserAuthorize`s property created is null");
        throw new Exception("property created can`t be null");
    }
    /**
    * createBy 非空校验
    */
    public UserAuthorize createByNotNull() throws Exception {
        if(this.createBy != null){
            return this;
        }
        log.warn("UserAuthorize`s property createBy is null");
        throw new Exception("property createBy can`t be null");
    }
    /**
    * updated 非空校验
    */
    public UserAuthorize updatedNotNull() throws Exception {
        if(this.updated != null){
            return this;
        }
        log.warn("UserAuthorize`s property updated is null");
        throw new Exception("property updated can`t be null");
    }
    /**
    * state 非空校验
    */
    public UserAuthorize stateNotNull() throws Exception {
        if(this.state != null){
            return this;
        }
        log.warn("UserAuthorize`s property state is null");
        throw new Exception("property state can`t be null");
    }
}

package com.enzo.demo.springcloud.server.user.dao;/**
 * Created by LENOVO on 2018/5/22.
 */

import com.enzo.demo.entity.sys.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangyx
 * @desccription 用户持久
 * @date 2018-05-2018/5/22-12:02
 */
@Repository
public interface UserDao {

    /**
    * @author zhangyx
    * @description 依据用户名查询用户信息
    * @date 2018/5/22 14:25
    * @todo
    * @param username 用户名
    * @return
    * @exception
    */
    List<User> selectUserByName(@Param("username") String username);

}

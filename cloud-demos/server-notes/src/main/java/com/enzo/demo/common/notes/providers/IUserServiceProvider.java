package com.enzo.demo.common.notes.providers;/**
 * Created by LENOVO on 2018/5/28.
 */

import com.enzo.demo.common.entity.sys.User;
import com.enzo.demo.common.notes.providers.hystric.UserServiceHyStric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zhangyx
 * @desccription
 * @date 2018-05-2018/5/28-14:35
 */
@FeignClient(value = "server-user", fallback = UserServiceHyStric.class)
public interface IUserServiceProvider {

    @RequestMapping(value = "/user/{username}",method = RequestMethod.GET)
    User queryUser(@PathVariable(value = "username") String username);

}

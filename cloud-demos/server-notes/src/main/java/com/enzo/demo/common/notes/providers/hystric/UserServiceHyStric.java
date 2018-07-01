package com.enzo.demo.common.notes.providers.hystric;/**
 * Created by LENOVO on 2018/5/28.
 */

import com.enzo.demo.common.entity.sys.User;
import com.enzo.demo.common.notes.providers.IUserServiceProvider;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhangyx
 * @desccription
 * @date 2018-05-2018/5/28-16:06
 */
@Component
public class UserServiceHyStric implements IUserServiceProvider{
    @Override
    public User queryUser(@PathVariable(value = "username") String username) {
        return new User();
    }
}

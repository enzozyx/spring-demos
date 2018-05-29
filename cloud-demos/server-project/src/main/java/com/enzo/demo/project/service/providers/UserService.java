package com.enzo.demo.project.service.providers;/**
 * Created by LENOVO on 2018/5/22.
 */

import com.enzo.demo.entity.sys.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhangyx
 * @desccription 用户rest服务提供
 * @date 2018-05-2018/5/22-15:39
 */
@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "queryUserError")
    public User queryUserByName(String name){
        return restTemplate.getForObject("http://SERVER-USER/user/" + name , User.class);
    }

    public User queryUserError(String name){
        return null;
    }
}

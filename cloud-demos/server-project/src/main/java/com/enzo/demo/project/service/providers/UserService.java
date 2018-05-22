package com.enzo.demo.project.service.providers;/**
 * Created by LENOVO on 2018/5/22.
 */

import com.enzo.demo.entity.sys.User;
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

    public User queryUserByName(String name){
        return restTemplate.getForObject("http://SERVICE-USER/user/" + name , User.class);
    }
}

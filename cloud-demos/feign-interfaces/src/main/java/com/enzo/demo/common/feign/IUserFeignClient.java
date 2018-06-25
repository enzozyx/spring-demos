package com.enzo.demo.common.feign;/**
 * Created by LENOVO on 2018/6/25.
 */

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangyx
 * @desccription 用户feign
 * @date 2018-06-2018/6/25-17:03
 */
@FeignClient(value = "server-user")
public interface IUserFeignClient {

//    @RequestMapping()

}

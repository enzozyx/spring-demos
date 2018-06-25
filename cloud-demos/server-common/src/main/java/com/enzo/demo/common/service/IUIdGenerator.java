package com.enzo.demo.common.service;/**
 * Created by LENOVO on 2018/6/25.
 */

/**
 * @author zhangyx
 * @desccription ID 序列生成服务
 * @date 2018-06-2018/6/25-18:42
 */
public interface IUIdGenerator<P> {

    P getNextId(String code);
}

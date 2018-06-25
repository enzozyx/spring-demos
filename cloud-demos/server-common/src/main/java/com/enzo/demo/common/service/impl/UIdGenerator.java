package com.enzo.demo.common.service.impl;/**
 * Created by LENOVO on 2018/6/25.
 */

import com.enzo.demo.common.service.IUIdGenerator;
import org.springframework.stereotype.Service;

/**
 * @author zhangyx
 * @desccription ID 生成
 * @date 2018-06-2018/6/25-18:43
 */
@Service
public class UIdGenerator implements IUIdGenerator<Integer> {

    @Override
    public Integer getNextId(String code) {
        return 1;
    }
}

package com.joy.lottery.dao;

import org.springframework.stereotype.Component;

/**
 * Created by zhangjingbo on 14-10-22.
 */
@Component("testDao")
public class TestDao {

    public String test() {
        return "hello dao";
    }
}

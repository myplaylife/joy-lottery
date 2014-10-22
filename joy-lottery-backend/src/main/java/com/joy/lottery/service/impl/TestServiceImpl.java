package com.joy.lottery.service.impl;

import com.joy.lottery.dao.TestDao;
import com.joy.lottery.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangjingbo on 14-10-22.
 */
@Service("testService")
public class TestServiceImpl implements TestService{

    @Autowired
    private TestDao testDao;

    @Override
    public String test() {
        return "hello service:" + testDao.test();
    }
}

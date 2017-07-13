package com.mafh.service;

import com.mafh.dao.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by mafh on 2017/6/30 0030.13:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;
    @Test
    public void finOne() throws Exception {
        Girl girl = girlService.finOne(2);
        Assert.assertEquals(new Integer(12),girl.getAge());
    }

}
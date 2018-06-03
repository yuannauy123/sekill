package com.seckill.dao;

import com.seckill.entity.SuccessKilled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Autowired
    private SuccessKilledDao successKilledDao;
    @Test
    public void insertSuccessKilled() {
        long seckillId=1001L;
        long userId=1L;
        int i;
        int insertCount=successKilledDao.insertSuccessKilled(seckillId,userId);
        System.out.println("insertCount="+insertCount);
    }

    @Test
    public void queryByIdWithSeckill() {
        SuccessKilled successKilled=successKilledDao.queryByIdWithSeckill(1001L,1L);
        System.out.println(successKilled);
    }
}
package com.seckill.service;

import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.entity.Seckill;
import com.seckill.exception.RepeatKillException;
import com.seckill.exception.SeckillCloseException;
import com.seckill.service.Impl.SeckillServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    private final Logger logger=LoggerFactory.getLogger(this.getClass());
    @Autowired
    @Qualifier(value = "pri")
    private SeckillService seckillService;

    @Test
    public void getSeckillList() {
        List<Seckill> list=seckillService.getSeckillList();
        logger.info("list={}",list);
    }

    @Test
    public void getById() {

        Seckill seckill=seckillService.getById(1000);
        logger.info("list={}",seckill);
    }

    @Test
    public void SeckillUrltest() {
        long SeckillId=1002;
        Exposer exposer=seckillService.exportSeckillUrl(SeckillId);
        if(exposer.isExposed()){
            logger.info("exposer={}",exposer);
            String md5=exposer.getMd5();
            try{
                SeckillExecution seckillExecutions=seckillService.executeSeckill(SeckillId,5,md5);
                logger.info("result={}",seckillExecutions);
            }catch (SeckillCloseException e1){
                logger.warn(e1.getMessage());
            }catch (RepeatKillException e2){
                logger.warn(e2.getMessage());
            }
        }else{
            logger.warn("exposer={}",exposer);
        }

    }

    @Test
    public void executeSeckill() {
        SeckillExecution seckillExecution=seckillService.executeSeckill(1000,2,"5fcffd39b20bd38a6f6333707522eb48");
        logger.info("result={}",seckillExecution);
    }
}
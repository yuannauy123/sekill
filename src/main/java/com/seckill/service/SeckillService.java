package com.seckill.service;

import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.entity.Seckill;
import com.seckill.exception.RepeatKillException;
import com.seckill.exception.SeckillCloseException;
import com.seckill.exception.SeckillException;

import java.util.List;

/**
* 业务接口：站在“使用者”角度设计接口
 * 三个方面：方法定义的力度，参数，返回类型（return 类型/异常）
*/
public interface SeckillService {

    /**
     * 查询所有的秒杀记录
    * @return
    */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
    * @return
    */
    Seckill getById(long SeckillId);

    /**
     * 秒杀开始时输出秒杀接口地址，否则输出系统时间和秒杀时间
    * @return
    */
    Exposer exportSeckillUrl(long SeckillId);

    /**
     * 执行秒杀操作
    * @return
    */
    SeckillExecution executeSeckill(long seckillId, long userId, String md5) throws SeckillException,SeckillCloseException,RepeatKillException;

}

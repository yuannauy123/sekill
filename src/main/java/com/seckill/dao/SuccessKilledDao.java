package com.seckill.dao;

import com.seckill.entity.SuccessKilled;
import org.apache.ibatis.annotations.Param;

public interface SuccessKilledDao {

    /**
     * 插入购买明细,可过滤重复
    * @return
    */
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userId") long userId);

    /**
     * 根据id查询SuccessKilled并携带Seckill对象
    * @return
    */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId,@Param("userId") long userId);

}

package com.seckill.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: seckill
 * @description:
 * @author: LeonYuan
 * @create: 2018-05-05 08:34
 **/
@Component
public class SuccessKilled {

    private long seckillId;

    private long userId;

    private short state;

    private Date seckillTime;

   // private Seckill seckill;


    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public Date getSeckillTime() {
        return seckillTime;
    }

    public void setSeckillTime(Date seckillTime) {
        this.seckillTime = seckillTime;
    }

   /* public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }*/

    @Override
    public String toString() {
        return "SucessKilled{" +
                "seckillId=" + seckillId +
                ", userId=" + userId +
                ", state=" + state +
                ", seckillTime=" + seckillTime +
                //", seckill=" + seckill +
                '}';
    }
}

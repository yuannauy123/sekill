package com.seckill.exception;

/**
 * @program: seckill
 * @description: 秒杀异常基类
 * @author: LeonYuan
 * @create: 2018-05-15 15:35
 **/
public class SeckillException extends RuntimeException{
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}

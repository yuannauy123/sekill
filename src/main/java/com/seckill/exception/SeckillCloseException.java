package com.seckill.exception;

/**
 * @program: seckill
 * @description: 秒杀关闭异常
 * @author: LeonYuan
 * @create: 2018-05-15 15:33
 **/
public class SeckillCloseException extends SeckillException{

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.seckill.exception;

/**
 * @program: seckill
 * @description: 重复秒杀异常（运行期异常）
 * @author: LeonYuan
 * @create: 2018-05-15 15:31
 **/
public class RepeatKillException extends SeckillException{

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}

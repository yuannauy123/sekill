package com.seckill.dao.enums;

/**
 * @program: seckill
 * @description:使用枚举表示常量字典
 * @author: LeonYuan
 * @create: 2018-05-15 17:58
 **/
public enum SeckillStateEnum {
    SUCCESS(1,"秒杀成功"),
    END(2,"秒杀结束"),
    REPEAT_SECKILL(-1,"重复秒杀"),
    REWRITE(-2,"数据篡改");

    private int state;

    private String stateInfo;

    SeckillStateEnum(int state, String stateInfo) {
        this.state=state;
        this.stateInfo=stateInfo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public static SeckillStateEnum stateOf(int index){
        for (SeckillStateEnum seckillStateEnum:values()){
            if(seckillStateEnum.getState()==index){
                return seckillStateEnum;
            }
        }

        return null;
    }
}

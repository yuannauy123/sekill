package com.seckill.service;

/**
 * @program: seckill
 * @description:
 * @author: LeonYuan
 * @create: 2018-05-22 14:21
 **/
public class test {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        System.out.println(start);
        long sum=0l;
        for(int i=0;i<Integer.MAX_VALUE;i++){
            sum+=i;
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}

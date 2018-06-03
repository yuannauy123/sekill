package com.seckill.service.Impl;

import com.seckill.dao.SeckillDao;
import com.seckill.dao.SuccessKilledDao;
import com.seckill.dao.enums.SeckillStateEnum;
import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.entity.Seckill;
import com.seckill.entity.SuccessKilled;
import com.seckill.exception.RepeatKillException;
import com.seckill.exception.SeckillCloseException;
import com.seckill.exception.SeckillException;
import com.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import java.util.Date;
import java.util.List;


/**
 * @program: seckill
 * @description:
 * @author: LeonYuan
 * @create: 2018-05-15 15:42
 **/
@Service("pri")
public class SeckillServiceImpl implements SeckillService {

    private Logger logger=LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillDao seckillDao;

    @Autowired
    private SuccessKilledDao successKilledDao;

    private final String slat="adjlasjfalks%^**&^&*^*&^*&**&56+44def9r273799877r59485&(*";

    @Override
    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0,6);
    }

    @Override
    public Seckill getById(long SeckillId) {
        return seckillDao.queryByid(SeckillId);
    }

    @Override
    public Exposer exportSeckillUrl(long SeckillId) {
        Seckill seckill=seckillDao.queryByid(SeckillId);
        if(seckill==null){
            return new Exposer(false,SeckillId);
        }
        Date startTime=seckill.getStartTime();
        Date endTime=seckill.getEndTime();
        Date nowTime=new Date();

        if(nowTime.getTime()<startTime.getTime()||nowTime.getTime()>endTime.getTime()){
            return new Exposer(false,SeckillId,startTime.getTime(),endTime.getTime());
        }
        String md5=getMD5(SeckillId);
        return new Exposer(true,md5,SeckillId);
    }

    private String getMD5(long seckillId){
        String base=seckillId+"/"+slat;
        String md5=DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    @Override
    @Transactional
    public SeckillExecution executeSeckill(long seckillId, long userId, String md5) throws SeckillException, SeckillCloseException, RepeatKillException {
        if(md5==null||!md5.equals(getMD5(seckillId))){
            throw  new SeckillException("seckill data rewrite");
        }
        Date nowTime=new Date();
        int updateCount=seckillDao.reduceNumber(seckillId,nowTime);
        try{
            if(updateCount<=0){
                throw  new SeckillCloseException("seckill is closed");
            }else{
                int insertCount=successKilledDao.insertSuccessKilled(seckillId,userId);
                if(insertCount<=0){
                    throw new RepeatKillException("repeat kill");
                }else {
                    SuccessKilled successKilled=successKilledDao.queryByIdWithSeckill(seckillId,userId);

                    return new SeckillExecution(seckillId,SeckillStateEnum.SUCCESS,successKilled);
                }
            }
        }catch (SeckillCloseException e1){
            throw e1;
        }catch (RepeatKillException e2){
            throw e2;
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new SeckillException("seckill inner error:"+e.getMessage());
        }


    }
}

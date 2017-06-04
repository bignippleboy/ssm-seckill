package org.seckill.dto;

import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStatEnum;

/**
 * User: huangken
 * Date: 2/6/17
 * Time: 下午4:35
 * 秒杀执行结果
 */
public class SeckillResultDTO {
    private long seckillId;

    private int state;

    private String stateInfo;

    private SuccessKilled successKilled;

    /**
     * 秒杀成功返回所有信息
     * @param seckillId
     * @param statEnum
     * @param successKilled
     */
    public SeckillResultDTO(long seckillId, SeckillStatEnum statEnum, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
        this.successKilled = successKilled;
    }

    /**
     * 秒杀失败
     * @param seckillId
     * @param statEnum
     */
    public SeckillResultDTO(long seckillId, SeckillStatEnum statEnum) {
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
    }

    public long getSeckillId() {
        return seckillId;
    }

    public SeckillResultDTO setSeckillId(long seckillId) {
        this.seckillId = seckillId;
        return this;
    }

    public int getState() {
        return state;
    }

    public SeckillResultDTO setState(int state) {
        this.state = state;
        return this;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public SeckillResultDTO setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
        return this;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public SeckillResultDTO setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
        return this;
    }
}

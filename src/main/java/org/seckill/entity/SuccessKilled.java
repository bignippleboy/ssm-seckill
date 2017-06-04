package org.seckill.entity;

import java.util.Date;

/**
 * User: huangken
 * Date: 2/6/17
 * Time: 上午11:15
 */
public class SuccessKilled {
    private long secKillId;
    private long userPhone;
    private short state;
    private Date creatTime;

    //变通
    //多对一
    private Seckill seckill;

    public long getSecKillId() {
        return secKillId;
    }

    public SuccessKilled setSecKillId(long secKillId) {
        this.secKillId = secKillId;
        return this;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public SuccessKilled setUserPhone(long userPhone) {
        this.userPhone = userPhone;
        return this;
    }

    public short getState() {
        return state;
    }

    public SuccessKilled setState(short state) {
        this.state = state;
        return this;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public SuccessKilled setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
        return this;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public SuccessKilled setSeckill(Seckill seckill) {
        this.seckill = seckill;
        return this;
    }

    @Override
    public String toString() {
        return "SuccessKilled{" +
                "secKillId=" + secKillId +
                ", userPhone=" + userPhone +
                ", state=" + state +
                ", creatTime=" + creatTime +
                '}';
    }
}

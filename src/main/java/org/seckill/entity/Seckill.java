package org.seckill.entity;

import java.util.Date;

/**
 * User: huangken
 * Date: 2/6/17
 * Time: 上午11:12
 */
public class Seckill {
    private long seckillId;
    private String name;
    private int number;
    private Date startTime;
    private Date endTime;
    private Date createTime;

    public long getSeckillId() {
        return seckillId;
    }

    public Seckill setSeckillId(long seckillId) {
        this.seckillId = seckillId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Seckill setName(String name) {
        this.name = name;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public Seckill setNumber(int number) {
        this.number = number;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Seckill setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Seckill setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Seckill setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    @Override
    public String toString() {
        return "Seckill{" +
                "seckillId=" + seckillId +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createTime=" + createTime +
                '}';
    }
}

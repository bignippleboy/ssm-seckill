package org.seckill.dto;

/**
 * User: huangken
 * Date: 2/6/17
 * Time: 下午4:29
 * 暴露秒杀地址DTO
 */
public class UrlExposerDTO {
    private boolean exposed;

    private String md5;

    private long seckillId;

    private long now;

    private long start;

    private long end;

    public UrlExposerDTO(boolean exposed, String md5, long seckillId) {
        this.exposed = exposed;
        this.md5 = md5;
        this.seckillId = seckillId;
    }

    public UrlExposerDTO(boolean exposed, long seckillId, long start, long now, long end) {
        this.start = start;
        this.now = now;
        this.end = end;
    }

    public UrlExposerDTO(boolean exposed, long seckillId) {
        this.exposed = exposed;
        this.seckillId = seckillId;
    }

    public boolean isExposed() {
        return exposed;
    }

    public UrlExposerDTO setExposed(boolean exposed) {
        this.exposed = exposed;
        return this;
    }

    public String getMd5() {
        return md5;
    }

    public UrlExposerDTO setMd5(String md5) {
        this.md5 = md5;
        return this;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public UrlExposerDTO setSeckillId(long seckillId) {
        this.seckillId = seckillId;
        return this;
    }

    public long getNow() {
        return now;
    }

    public UrlExposerDTO setNow(long now) {
        this.now = now;
        return this;
    }

    public long getStart() {
        return start;
    }

    public UrlExposerDTO setStart(long start) {
        this.start = start;
        return this;
    }

    public long getEnd() {
        return end;
    }

    public UrlExposerDTO setEnd(long end) {
        this.end = end;
        return this;
    }

    @Override
    public String toString() {
        return "UrlExposerDTO{" +
                "exposed=" + exposed +
                ", md5='" + md5 + '\'' +
                ", seckillId=" + seckillId +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}

package org.seckill.service;

import org.seckill.dto.SeckillResultDTO;
import org.seckill.dto.UrlExposerDTO;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

/**
 * User: huangken
 * Date: 2/6/17
 * Time: 下午4:22
 */
public interface SeckillService {
    List<Seckill> getSeckillList();

    Seckill getSeckillById(long seckillId);

    /**
     * 秒杀已开启则输出秒杀接口地址，
     * 否则输出系统时间和秒杀时间
     */
    UrlExposerDTO exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillResultDTO executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, SeckillCloseException, RepeatKillException;
}

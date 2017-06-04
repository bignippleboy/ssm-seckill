package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.SeckillResultDTO;
import org.seckill.dto.UrlExposerDTO;
import org.seckill.entity.Seckill;
import org.seckill.exception.SeckillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * User: huangken
 * Date: 2/6/17
 * Time: 下午6:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-service.xml",
        "classpath:spring/spring-dao.xml"})
public class SeckillServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void testGetSeckillList() throws Exception {
        List<Seckill> seckills = seckillService.getSeckillList();
        logger.info("list={}", seckills);
    }

    @Test
    public void testGetSeckillById() throws Exception {
        long id = 1000L;
        Seckill seckill = seckillService.getSeckillById(id);
        logger.info("seckill={}", seckill);
    }

    @Test
    public void testExportSeckillUrl() throws Exception {
        long id = 1000L;
        UrlExposerDTO urlExposerDTO = seckillService.exportSeckillUrl(id);
        logger.info("urlExposerDTO={}", urlExposerDTO);
    }

    @Test
    public void testExecuteSeckill() throws Exception {
        long id = 1000L;
        long phone = 13720113453L;
        String md5 = "cfc9207118ce780a79ba98362b4cdf12";
        SeckillResultDTO seckillResultDTO = null;
        try {
            seckillResultDTO = seckillService.executeSeckill(id, phone, md5);
            logger.info("result={}", seckillResultDTO);
        } catch (SeckillException e) {
            logger.error(e.getMessage(), e);
        }
        logger.info("seckillResultDTO={}", seckillResultDTO);
    }
}
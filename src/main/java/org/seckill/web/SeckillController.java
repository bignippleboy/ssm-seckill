package org.seckill.web;

import org.seckill.dto.SeckillResultDTO;
import org.seckill.dto.SeckillResultVO;
import org.seckill.dto.UrlExposerDTO;
import org.seckill.entity.Seckill;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * User: huangken
 * Date: 2/6/17
 * Time: 下午10:45
 */
@Controller
@RequestMapping("/seckill") //url://模块/资源/{id}/细分
public class SeckillController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Seckill> list = seckillService.getSeckillList();

        model.addAttribute("list", list);

        return "list";
    }

    @RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model) {
        if (seckillId == null)
            return "redirect:/seckill/list";

        Seckill seckill = seckillService.getSeckillById(seckillId);
        if (seckill == null)
            return "forward:/seckill/list";

        model.addAttribute("seckill", seckill);

        return "detail";
    }

    @RequestMapping(value = "/{seckillId}/exposer",
            method = RequestMethod.POST,
            //避免json的中文问题
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResultVO<UrlExposerDTO> exposer(@PathVariable("seckillId") Long seckillId) {

        SeckillResultVO<UrlExposerDTO> result = null;
        try {
            UrlExposerDTO exposer = seckillService.exportSeckillUrl(seckillId);
            result = new SeckillResultVO<UrlExposerDTO>(true, exposer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new SeckillResultVO<UrlExposerDTO>(false, e.getMessage());
        }

        return result;
    }

    @RequestMapping(value = "/{seckillId}/{md5}/executeSeckill",
        method = RequestMethod.POST,
        produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResultVO<SeckillResultDTO> executeSeckill(@PathVariable("seckillId") Long seckillId,
                                                            @PathVariable("md5") String md5,
                                                            @CookieValue(value = "userPhone", required = false) Long phone) {

        //springmvc valid
        if (phone == null)
            return new SeckillResultVO<SeckillResultDTO>(false, "未注册");

        SeckillResultVO<SeckillResultDTO> result = null;
        try {
            SeckillResultDTO execution =
                    seckillService.executeSeckill(seckillId, phone, md5);
            result = new SeckillResultVO<SeckillResultDTO>(true, execution);
        } catch (RepeatKillException e) {
            SeckillResultDTO seckillResultDTO = new SeckillResultDTO(seckillId, SeckillStatEnum.REPEAT_KILL);
            result = new SeckillResultVO<SeckillResultDTO>(true, seckillResultDTO);
        } catch (SeckillCloseException e) {
            SeckillResultDTO seckillResultDTO = new SeckillResultDTO(seckillId, SeckillStatEnum.END);
            result = new SeckillResultVO<SeckillResultDTO>(true, seckillResultDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            SeckillResultDTO seckillResultDTO = new SeckillResultDTO(seckillId, SeckillStatEnum.INNER_ERROR);
            result = new SeckillResultVO<SeckillResultDTO>(true, e.getMessage());
        }

        return result;
    }

    @RequestMapping(value = "/time/now", method = RequestMethod.GET)
    @ResponseBody
    public SeckillResultVO<Long> time() {
        Date now = new Date();
        return new SeckillResultVO(true, now.getTime());
    }
}

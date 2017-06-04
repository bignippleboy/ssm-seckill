package org.seckill.exception;

/**
 * User: huangken
 * Date: 2/6/17
 * Time: 下午5:04
 * 重复秒杀异常(运行时异常)
 */
public class RepeatKillException extends SeckillException {

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}

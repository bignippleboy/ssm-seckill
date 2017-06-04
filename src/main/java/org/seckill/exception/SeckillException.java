package org.seckill.exception;

/**
 * User: huangken
 * Date: 2/6/17
 * Time: 下午5:06
 */
public class SeckillException extends RuntimeException {
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}

package org.seckill.exception;

/**
 * User: huangken
 * Date: 2/6/17
 * Time: 下午5:06
 */
public class SeckillCloseException extends SeckillException {
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}

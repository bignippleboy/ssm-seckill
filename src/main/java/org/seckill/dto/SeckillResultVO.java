package org.seckill.dto;

/**
 * User: huangken
 * Date: 2/6/17
 * Time: 下午11:10
 * 封装json结果
 */
public class SeckillResultVO<T> {
    private boolean success;

    private T data;

    private String error;

    public SeckillResultVO(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public SeckillResultVO(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public SeckillResultVO setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public T getData() {
        return data;
    }

    public SeckillResultVO setData(T data) {
        this.data = data;
        return this;
    }

    public String getError() {
        return error;
    }

    public SeckillResultVO setError(String error) {
        this.error = error;
        return this;
    }
}

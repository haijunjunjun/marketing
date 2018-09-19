package com.example.demo.util;

import lombok.Data;

/**
 * @Author MrD on 2018/7/6.
 * 数据返回
 */
@Data
public class DataResponseV1<T> {
    private String message;
    private int retCode;
    private T data;

    public DataResponseV1() {
    }

    private DataResponseV1(T data) {
        this.retCode = 0;
        this.message = "成功";
        this.data = data;
    }

    private DataResponseV1(CodeResponse cm) {
        if (cm == null) {
            return;
        }
        this.retCode = cm.getRetCode();
        this.message = cm.getMessage();
    }

    /**
     * 成功时候的调用
     *
     * @return
     */
    public static <T> DataResponseV1<T> success(T data) {
        return new DataResponseV1<T>(data);
    }

    /**
     * 成功，不需要传入参数
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> DataResponseV1<T> success() {
        return (DataResponseV1<T>) success("");
    }

    /**
     * 失败时候的调用
     *
     * @return
     */
    public static <T> DataResponseV1<T> error(CodeResponse cm) {
        return new DataResponseV1<T>(cm);
    }

    /**
     * 失败时候的调用,扩展消息参数
     *
     * @param cm
     * @param msg
     * @return
     */
    public static <T> DataResponseV1<T> error(CodeResponse cm, String msg) {
        cm.setMessage(cm.getMessage() + "--" + msg);
        return new DataResponseV1<T>(cm);
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public int getRetCode() {
        return retCode;
    }
}

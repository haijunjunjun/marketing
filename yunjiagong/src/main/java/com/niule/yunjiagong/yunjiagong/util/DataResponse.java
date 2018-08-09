package com.niule.yunjiagong.yunjiagong.util;

import lombok.Data;

/**
 * @Author MrD on 2018/7/6.
 * 数据返回
 */
@Data
public class DataResponse<T> {
    private String message;
    private int retCode;
    private T data;

    public DataResponse() {
    }

    private DataResponse(T data) {
        this.retCode = 0;
        this.message = "成功";
        this.data = data;
    }

    private DataResponse(CodeResponse cm) {
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
    public static <T> DataResponse<T> success(T data) {
        return new DataResponse<T>(data);
    }

    /**
     * 成功，不需要传入参数
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> DataResponse<T> success() {
        return (DataResponse<T>) success("");
    }

    /**
     * 失败时候的调用
     *
     * @return
     */
    public static <T> DataResponse<T> error(CodeResponse cm) {
        return new DataResponse<T>(cm);
    }

    /**
     * 失败时候的调用,扩展消息参数
     *
     * @param cm
     * @param msg
     * @return
     */
    public static <T> DataResponse<T> error(CodeResponse cm, String msg) {
        cm.setMessage(cm.getMessage() + "--" + msg);
        return new DataResponse<T>(cm);
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

package com.pinyougou.model;

/**
 *
 **/
public class WebAppResult {

    private boolean success;
    private boolean flag;
    private String  message;

    public WebAppResult(boolean success, String message) {
        super();
        this.success = success;
        this.flag = success;
        this.message = message;
    }

    public static WebAppResult ok() {
        return new WebAppResult(true, "操作成功");
    }

    public static WebAppResult build(boolean success, String message) {
        return new WebAppResult(success, message);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
package com.pinyougou.model;

import java.io.Serializable;

public class ServiceResult<T> implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3765720967319047788L;

    private T                 result;
    private PageResult<T>     pagerInfo;
    private boolean           success          = true;
    private String            message          = "";
    private String            code             = "";

    /**
     * 服务是否执行成功。
     * @return
     */
    public boolean getSuccess() {
        return success;
    }

    /**
     * 服务是否执行成功。
     * @param isSuccess
     */
    public void setSuccess(boolean isSuccess) {
        this.success = isSuccess;
    }

    /**
     * 设置服务执行结果。
     * @param result
     */
    public void setResult(T result) {
        this.result = result;
    }

    /**
     * 服务执行过程发生异常时设置错误信息。
     * 该方法会将【success-服务是否执行成功】设置为false。
     * @param code 返回给客户端的消息代码。
     * @param message 返回给客户端的消息描述。
     */
    public void setError(String code, String message) {
        this.code = code;
        this.message = message;
        this.success = false;
    }

    /**
     * 返回给客户端的消息代码。
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * 获取服务执行结果。
     * @return
     */
    public T getResult() {
        return result;
    }

    /**
     * 获取服务返回的描述消息。
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置服务返回的描述消息。
     * @param value
     */
    public void setMessage(String value) {
        this.message = value;
    }

    public PageResult<T> getPagerInfo() {
        return pagerInfo;
    }

    public void setPagerInfo(PageResult<T> pagerInfo) {
        this.pagerInfo = pagerInfo;
    }

    @Override
    public String toString() {
        return "[result=" + result + ", message=" + message + ", success=" + success + ", code=" + code + "]";
    }

}

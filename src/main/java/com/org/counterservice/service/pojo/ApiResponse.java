package com.org.counterservice.service.pojo;

public class ApiResponse {

    private String errorMsg;
    private int errorCode;
    private String description;
    private Object outPutObject;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getOutPutObject() {
        return outPutObject;
    }

    public void setOutPutObject(Object outPutObject) {
        this.outPutObject = outPutObject;
    }

    public ApiResponse(String errorMsg, int errorCode, String desc) {
        super();
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
        this.description = desc;
    }

    @Override
    public String toString() {
        return "ApiResponse [errorMsg=" + errorMsg + ", errorCode=" + errorCode + ", desc=" + description + "]";
    }

}

package com.flightui.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean success;

    private int status;

    private String errorMessage;


 public BaseResponse()
 {

 }

    public BaseResponse(boolean success, int status) {
        this.success = success;
        this.status = status;
    }


    public BaseResponse(boolean success, int status, String errorMessage) {
        this.success = success;
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


}

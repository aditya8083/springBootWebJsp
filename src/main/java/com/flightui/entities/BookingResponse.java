package com.flightui.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by avinashkumar on 08/01/2018 AD.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingResponse {

    private static final long serialVersionUID = 1;

    private Transactions transactions;

    public Transactions getTransactions() {
        return transactions;
    }

    public void setTransactions(Transactions transactions) {
        this.transactions = transactions;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private boolean success;

    private int status;

    private String errorMessage;

    public BookingResponse()
    {

    }

    public BookingResponse(boolean success, int status , Transactions transactions) {
        this.transactions = transactions;
        this.success = success;
        this.status = status;
    }

    public BookingResponse(boolean success, int status ) {
        this.success = success;
        this.status = status;
    }
}

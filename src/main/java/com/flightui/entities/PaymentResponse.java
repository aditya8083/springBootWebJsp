package com.flightui.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by avinashkumar on 26/12/2017 AD.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentResponse extends BaseResponse{

    private static final long serialVersionUID = 1;

    Transactions transactions;

    public PaymentResponse(boolean success, int value, String s) {
        super(success,value,s);
    }

    public Transactions getTransactions() {
        return transactions;
    }

    public void setTransactions(Transactions transactions) {
        this.transactions = transactions;
    }

    public PaymentResponse(boolean success, int status, Transactions transactions) {
        super(success, status);
        this.transactions = transactions;
    }

    public PaymentResponse()
    {

    }
}



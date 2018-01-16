package com.flightui.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * Created by avinashkumar on 15/12/2017 AD.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transactions implements Serializable{

    private static final long serialVersionUID = 1L;

    private String amount;
    private String transactionDate;
    private Long customerId;
    private List<ExtData> extData ;
    private String paymentId;
    private String paymentStatus;
    private String paymentMethod;
    private String paymentEngine;
    private String internetBankingId;
    private String walletId;
    private String orderSource;


    private Transactions(Builder builder) {
        setAmount(builder.amount);
        setTransactionDate(builder.transactionDate);
        setCustomerId(builder.customerId);
        setExtData(builder.extData);
        setPaymentId(builder.paymentId);
        setPaymentStatus(builder.paymentStatus);
        setPaymentMethod(builder.paymentMethod);
        setPaymentEngine(builder.paymentEngine);
        setInternetBankingId(builder.internetBankingId);
        setWalletId(builder.walletId);
        setOrderSource(builder.orderSource);
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<ExtData> getExtData() {
        return extData;
    }

    public void setExtData(List<ExtData> extData) {
        this.extData = extData;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentEngine() {
        return paymentEngine;
    }

    public void setPaymentEngine(String paymentEngine) {
        this.paymentEngine = paymentEngine;
    }

    public String getInternetBankingId() {
        return internetBankingId;
    }

    public void setInternetBankingId(String internetBankingId) {
        this.internetBankingId = internetBankingId;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }




public Transactions()
{

}


    public static final class Builder {
        private String amount;
        private String transactionDate;
        private Long customerId;
        private List<ExtData> extData;
        private String paymentId;
        private String paymentStatus;
        private String paymentMethod;
        private String paymentEngine;
        private String internetBankingId;
        private String walletId;
        private String orderSource;

        public Builder() {
        }

        public Builder amount(String val) {
            amount = val;
            return this;
        }

        public Builder transactionDate(String val) {
            transactionDate = val;
            return this;
        }

        public Builder customerId(Long val) {
            customerId = val;
            return this;
        }

        public Builder extData(List<ExtData> val) {
            extData = val;
            return this;
        }

        public Builder paymentId(String val) {
            paymentId = val;
            return this;
        }

        public Builder paymentStatus(String val) {
            paymentStatus = val;
            return this;
        }

        public Builder paymentMethod(String val) {
            paymentMethod = val;
            return this;
        }

        public Builder paymentEngine(String val) {
            paymentEngine = val;
            return this;
        }

        public Builder internetBankingId(String val) {
            internetBankingId = val;
            return this;
        }

        public Builder walletId(String val) {
            walletId = val;
            return this;
        }

        public Builder orderSource(String val) {
            orderSource = val;
            return this;
        }

        public Transactions build() {
            return new Transactions(this);
        }
    }
}

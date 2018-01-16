package com.flightui.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 * Created by avinashkumar on 05/01/2018 AD.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentRequest implements Serializable {

    private static final long serialVersionUID = 1;

    private String amount;
    private String transactionDate;
    private Long customerId;
    private List<ExtData> extData;
    private String orderSource;
    private CardPaymentRequest cardPaymentRequest;
    private Long netBankingId;
    private Long walletId;



    public CardPaymentRequest getCardPaymentRequest() {
        return cardPaymentRequest;
    }

    public void setCardPaymentRequest(CardPaymentRequest cardPaymentRequest) {
        this.cardPaymentRequest = cardPaymentRequest;
    }

    public Long getNetBankingId() {
        return netBankingId;
    }

    public void setNetBankingId(Long netBankingId) {
        this.netBankingId = netBankingId;
    }

    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }

    public PaymentRequest() {}

    public PaymentRequest(String amount, String transactionDate, Long customerId, List<ExtData> extData, String orderSource, CardPaymentRequest cardPaymentRequest, Long netBankingId, Long walletId) {
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.customerId = customerId;
        this.extData = extData;
        this.orderSource = orderSource;
        this.cardPaymentRequest = cardPaymentRequest;
        this.netBankingId = netBankingId;
        this.walletId = walletId;
    }

    private PaymentRequest(Builder builder) {
        setAmount(builder.amount);
        setTransactionDate(builder.transactionDate);
        setExtData(builder.extData);
        setOrderSource(builder.orderSource);
        setCardPaymentRequest(builder.cardPaymentRequest);
        setNetBankingId(builder.netBankingId);
        setWalletId(builder.walletId);
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

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }


    public static final class Builder {
        private String amount;
        private String transactionDate;
        private List<ExtData> extData;
        private String orderSource;
        private CardPaymentRequest cardPaymentRequest;
        private Long netBankingId;
        private Long walletId;

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

        public Builder extData(List<ExtData> val) {
            extData = val;
            return this;
        }

        public Builder orderSource(String val) {
            orderSource = val;
            return this;
        }

        public Builder cardPaymentRequest(CardPaymentRequest val) {
            cardPaymentRequest = val;
            return this;
        }

        public Builder netBankingId(Long val) {
            netBankingId = val;
            return this;
        }

        public Builder walletId(Long val) {
            walletId = val;
            return this;
        }

        public PaymentRequest build() {
            return new PaymentRequest(this);
        }
    }
}

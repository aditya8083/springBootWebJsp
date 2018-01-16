package com.flightui.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by avinashkumar on 26/12/2017 AD.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaveCardDetailsRequest implements Serializable{

    private static final long serialVersionUID = 1;


    @NotNull
    private Long userId;
    @NotNull
    private String cardNumber;
    @NotNull
    private String nameOnCard;
    @NotNull
    private String expDate;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public SaveCardDetailsRequest(Long userId, String cardNumber, String nameOnCard, String expDate) {
        this.userId = userId;
        this.cardNumber = cardNumber;
        this.nameOnCard = nameOnCard;
        this.expDate = expDate;
    }

    public Long getuserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public static Builder newBuilder() {
        return new Builder();
    }

    public SaveCardDetailsRequest() {}


    private SaveCardDetailsRequest(SaveCardDetailsRequest.Builder builder) {
        cardNumber = builder.cardNumber;
        nameOnCard = builder.nameOnCard;
        expDate=builder.expDate;
        userId=builder.userId;
    }

    public static final class Builder {
        @NotNull
        private String cardNumber;
        @NotNull
        private String nameOnCard;
        @NotNull
        private String expDate;
        @NotNull
        private Long userId;

        private Builder() {
        }

        public SaveCardDetailsRequest.Builder withCardNumber(String val) {
            cardNumber = val;
            return this;
        }

        public SaveCardDetailsRequest.Builder withNameOnCard(String val) {
            nameOnCard = val;
            return this;
        }

        public SaveCardDetailsRequest.Builder withExpDate(String val) {
            expDate = val;
            return this;
        }
        public SaveCardDetailsRequest.Builder withUserId(Long val) {
            userId = val;
            return this;
        }
        public SaveCardDetailsRequest build() {
            return new SaveCardDetailsRequest(this);
        }

    }

}

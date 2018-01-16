package com.flightui.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by avinashkumar on 26/12/2017 AD.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardPaymentRequest implements Serializable{

    private static final long serialVersionUID = 1;

    @NotNull
    private String cardNumber;
    @NotNull
    private String nameOnCard;
    @NotNull
    private String expDate;
    @NotNull
    private int cvv;

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

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }


    public CardPaymentRequest(String cardNumber, String nameOnCard, String expDate, int cvv) {
        this.cardNumber = cardNumber;
        this.nameOnCard = nameOnCard;
        this.expDate = expDate;
        this.cvv = cvv;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public CardPaymentRequest() {}


    private CardPaymentRequest(CardPaymentRequest.Builder builder) {
        cardNumber = builder.cardNumber;
        nameOnCard = builder.nameOnCard;
        expDate=builder.expDate;
        cvv=builder.cvv;
    }

    public static final class Builder {
        @NotNull
        private String cardNumber;
        @NotNull
        private String nameOnCard;
        @NotNull
        private String expDate;
        @NotNull
        private int cvv;

        private Builder() {
        }

        public CardPaymentRequest.Builder withCardNumber(String val) {
            cardNumber = val;
            return this;
        }

        public CardPaymentRequest.Builder withNameOnCard(String val) {
            nameOnCard = val;
            return this;
        }

        public CardPaymentRequest.Builder withExpDate(String val) {
            expDate = val;
            return this;
        }
        public CardPaymentRequest.Builder withCVV(int val) {
            cvv = val;
            return this;
        }
        public CardPaymentRequest build() {
            return new CardPaymentRequest(this);
        }

    }

}

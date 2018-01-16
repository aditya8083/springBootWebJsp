package com.flightui.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by avinashkumar on 02/01/2018 AD.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaveNetBankingURLRequest implements Serializable{

    private static final long serialVersionUID = 1;

    @NotNull
    private String bankName;
    @NotNull
    private String bankURL;

    private SaveNetBankingURLRequest(Builder builder) {
        setBankName(builder.bankName);
        setBankURL(builder.bankURL);
    }
    public SaveNetBankingURLRequest()
    {

    }

    public SaveNetBankingURLRequest(String bankName, String bankURL) {
        this.bankName = bankName;
        this.bankURL = bankURL;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankURL() {
        return bankURL;
    }

    public void setBankURL(String bankURL) {
        this.bankURL = bankURL;
    }


    public static final class Builder {
        private String bankName;
        private String bankURL;

        public Builder() {
        }

        public Builder bankName(String val) {
            bankName = val;
            return this;
        }

        public Builder bankURL(String val) {
            bankURL = val;
            return this;
        }

        public SaveNetBankingURLRequest build() {
            return new SaveNetBankingURLRequest(this);
        }
    }
}

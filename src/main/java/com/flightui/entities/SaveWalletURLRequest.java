package com.flightui.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by avinashkumar on 02/01/2018 AD.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaveWalletURLRequest implements Serializable{

    private static final long serialVersionUID = 1;

    @NotNull
    private String walletName;
    @NotNull
    private String walletURL;

    private SaveWalletURLRequest(Builder builder) {
        setWalletName(builder.walletName);
        setWalletURL(builder.walletURL);
    }

public SaveWalletURLRequest()
{

}

    public SaveWalletURLRequest(String walletName, String walletURL) {
        this.walletName = walletName;
        this.walletURL = walletURL;
    }

    public String getWalletName() {
        return walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    public String getWalletURL() {
        return walletURL;
    }

    public void setWalletURL(String walletURL) {
        this.walletURL = walletURL;
    }


    public static final class Builder {
        private String walletName;
        private String walletURL;

        public Builder() {
        }

        public Builder walletName(String val) {
            walletName = val;
            return this;
        }

        public Builder walletURL(String val) {
            walletURL = val;
            return this;
        }

        public SaveWalletURLRequest build() {
            return new SaveWalletURLRequest(this);
        }
    }
}

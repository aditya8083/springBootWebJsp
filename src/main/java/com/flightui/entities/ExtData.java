package com.flightui.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by avinashkumar on 03/01/2018 AD.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExtData implements Serializable{

    private static final long serialVersionUID = 1L;

    private String name;
    private String value;

    private ExtData(Builder builder) {
        setName(builder.name);
        setValue(builder.value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

public ExtData()
{

}

    public static final class Builder {
        private String name;
        private String value;

        public Builder() {
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder value(String val) {
            value = val;
            return this;
        }

        public ExtData build() {
            return new ExtData(this);
        }
    }
}

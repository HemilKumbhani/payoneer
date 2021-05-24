
package com.payoneerexercise1.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Payment {

    @SerializedName("reference")
    @Expose
    private String reference;
    @SerializedName("amount")
    @Expose
    private int amount;
    @SerializedName("currency")
    @Expose
    private String currency;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}

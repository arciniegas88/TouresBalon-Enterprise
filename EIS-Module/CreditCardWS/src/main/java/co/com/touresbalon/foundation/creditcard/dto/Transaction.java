/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.creditcard.dto;

import java.math.BigDecimal;

/**
 * @author nrodriguez
 */
public class Transaction {

    private String number;
    private BigDecimal amount;
    private String identificationType;
    private String numberIdentification;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getNumberIdentification() {
        return numberIdentification;
    }

    public void setNumberIdentification(String numberIdentification) {
        this.numberIdentification = numberIdentification;
    }

    @Override
    public String toString() {
        return "{" +
                "number='" + number + '\'' +
                ", amount=" + amount +
                ", identificationType='" + identificationType + '\'' +
                ", numberIdentification='" + numberIdentification + '\'' +
                '}';
    }
}

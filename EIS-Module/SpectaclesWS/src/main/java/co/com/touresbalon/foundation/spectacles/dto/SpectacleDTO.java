/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.spectacles.dto;

import java.math.BigInteger;

/**
 *
 * @author nrodriguez
 */
public class SpectacleDTO {
    
    
    private BigInteger idSpectacle;
    private BigInteger idTicket;
    private String descriptionSpectacle;
    private String state;

    public BigInteger getIdSpectacle() {
        return idSpectacle;
    }

    public void setIdSpectacle(BigInteger idSpectacle) {
        this.idSpectacle = idSpectacle;
    }

    public BigInteger getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(BigInteger idTicket) {
        this.idTicket = idTicket;
    }

    public String getDescriptionSpectacle() {
        return descriptionSpectacle;
    }

    public void setDescriptionSpectacle(String descriptionSpectacle) {
        this.descriptionSpectacle = descriptionSpectacle;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    
}

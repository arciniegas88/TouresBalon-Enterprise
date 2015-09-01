/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.spectacles.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author nrodriguez
 */
@Embeddable
public class SpectaclePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SPECTACLE")
    private BigInteger idSpectacle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TICKET")
    private BigInteger idTicket;

    public SpectaclePK() {
    }

    public SpectaclePK(BigInteger idSpectacle, BigInteger idTicket) {
        this.idSpectacle = idSpectacle;
        this.idTicket = idTicket;
    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSpectacle != null ? idSpectacle.hashCode() : 0);
        hash += (idTicket != null ? idTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpectaclePK)) {
            return false;
        }
        SpectaclePK other = (SpectaclePK) object;
        if ((this.idSpectacle == null && other.idSpectacle != null) || (this.idSpectacle != null && !this.idSpectacle.equals(other.idSpectacle))) {
            return false;
        }
        if ((this.idTicket == null && other.idTicket != null) || (this.idTicket != null && !this.idTicket.equals(other.idTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.touresbalon.foundation.spectacles.entity.SpectaclePK[ idSpectacle=" + idSpectacle + ", idTicket=" + idTicket + " ]";
    }
    
}

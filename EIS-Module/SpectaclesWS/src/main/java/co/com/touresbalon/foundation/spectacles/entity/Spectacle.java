/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.spectacles.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nrodriguez
 */
@Entity
@Table(name = "SPECTACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spectacle.findAll", query = "SELECT s FROM Spectacle s"),
    @NamedQuery(name = "Spectacle.findByIdSpectacle", query = "SELECT s FROM Spectacle s WHERE s.spectaclePK.idSpectacle = :idSpectacle"),
    @NamedQuery(name = "Spectacle.findByPK", query = "SELECT s FROM Spectacle s WHERE s.spectaclePK.idSpectacle = :idSpectacle AND s.spectaclePK.idTicket = :idTicket"),
    @NamedQuery(name = "Spectacle.findByBuySpectacle", query = "SELECT s FROM Spectacle s WHERE s.spectaclePK.idSpectacle = :idSpectacle AND s.spectaclePK.idTicket = :idTicket AND s.state = :state"),
    @NamedQuery(name = "Spectacle.findByIdTicket", query = "SELECT s FROM Spectacle s WHERE s.spectaclePK.idTicket = :idTicket"),
    @NamedQuery(name = "Spectacle.findByDescriptionSpectacle", query = "SELECT s FROM Spectacle s WHERE s.descriptionSpectacle = :descriptionSpectacle"),
    @NamedQuery(name = "Spectacle.findBySpectacleAndState", query = "SELECT s FROM Spectacle s WHERE s.spectaclePK.idSpectacle = :idSpectacle and s.state = :state"),
    @NamedQuery(name = "Spectacle.findByState", query = "SELECT s FROM Spectacle s WHERE s.state = :state")})
public class Spectacle implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SpectaclePK spectaclePK;
    @Size(max = 400)
    @Column(name = "DESCRIPTION_SPECTACLE")
    private String descriptionSpectacle;
    @Size(max = 1)
    @Column(name = "STATE")
    private String state;

    public Spectacle() {
    }

    public Spectacle(SpectaclePK spectaclePK) {
        this.spectaclePK = spectaclePK;
    }

    public Spectacle(BigInteger idSpectacle, BigInteger idTicket) {
        this.spectaclePK = new SpectaclePK(idSpectacle, idTicket);
    }

    public SpectaclePK getSpectaclePK() {
        return spectaclePK;
    }

    public void setSpectaclePK(SpectaclePK spectaclePK) {
        this.spectaclePK = spectaclePK;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spectaclePK != null ? spectaclePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spectacle)) {
            return false;
        }
        Spectacle other = (Spectacle) object;
        if ((this.spectaclePK == null && other.spectaclePK != null) || (this.spectaclePK != null && !this.spectaclePK.equals(other.spectaclePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.touresbalon.foundation.spectacles.entity.Spectacle[ spectaclePK=" + spectaclePK + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.spectacles.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;

/**
 *
 * @author nrodriguez
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketResponseDTO {

    @XmlElement(nillable=true)
    private BigInteger ticket;
    @XmlElement(nillable=true)
    private boolean transactionSuccess;

    public BigInteger getTicket() {
        return ticket;
    }

    public void setTicket(BigInteger ticket) {
        this.ticket = ticket;
    }

    public boolean isTransactionSuccess() {
        return transactionSuccess;
    }

    public void setTransactionSuccess(boolean transactionSuccess) {
        this.transactionSuccess = transactionSuccess;
    }
    
}

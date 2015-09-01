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
public class TicketResponseDTO {
    
    private BigInteger ticket;
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

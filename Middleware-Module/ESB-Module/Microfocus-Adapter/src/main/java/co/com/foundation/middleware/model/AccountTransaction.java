package co.com.foundation.middleware.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by garciniegas on 18/10/2015.
 */


@XmlRootElement(name = "AccountTransaction", namespace = "http://touresbalon.com.co/accounting/service/entity/1.0.0")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType( propOrder = {
        "TransactionNumber",
        "TransportProvider",
        "LodgingProvider",
        "WithdrawalAmount",
        "DepositAmount"
})
public class AccountTransaction {

    private String TransactionNumber;
    private String TransportProvider;
    private String LodgingProvider;
    private String WithdrawalAmount;
    private String DepositAmount;

    public String getTransactionNumber() {
        return TransactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        TransactionNumber = transactionNumber;
    }

    public String getTransportProvider() {
        return TransportProvider;
    }

    public void setTransportProvider(String transportProvider) {
        TransportProvider = transportProvider;
    }

    public String getLodgingProvider() {
        return LodgingProvider;
    }

    public void setLodgingProvider(String lodgingProvider) {
        LodgingProvider = lodgingProvider;
    }

    public String getWithdrawalAmount() {
        return WithdrawalAmount;
    }

    public void setWithdrawalAmount(String withdrawalAmount) {
        WithdrawalAmount = withdrawalAmount;
    }

    public String getDepositAmount() {
        return DepositAmount;
    }

    public void setDepositAmount(String depositAmount) {
        DepositAmount = depositAmount;
    }
}

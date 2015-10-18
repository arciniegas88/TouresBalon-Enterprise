package co.com.foundation.middleware.model;

import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;

/**
 * Created by garciniegas on 18/10/2015.
 */


@FixedLengthRecord(length = 70)
public class AccountTransactionCobol {

    @DataField(pos = 1, length=10,align = "L")
    private String TransactionId;
    @DataField(pos = 11, length=10,align = "L")
    private String TransactionNumber;
    @DataField(pos = 21, length=6,align = "L")
    private String TransactionYear;
    @DataField(pos = 27, length=4,align = "L")
    private String TransactionMonth;
    @DataField(pos = 31, length=4,align = "L")
    private String TransactionDay;
    @DataField(pos = 35, length=10,align = "L")
    private String AccountId;
    @DataField(pos = 45, length=10,align = "L")
    private String WithdrawalAmount;
    @DataField(pos = 55, length=10,align = "L")
    private String DepositAmount;

    public AccountTransactionCobol( AccountTransaction at ){

        TransactionId = at.getTransactionId();
        TransactionNumber = at.getTransactionNumber();
        TransactionYear = at.getTransactionYear();
        TransactionMonth = at.getTransactionMonth();
        TransactionDay = at.getTransactionDay();

        String transportCode = "1000";

        switch ( at.getTransportProvider() ){
            case "AA":{
                transportCode = "1254";
                break;
            }
            case "AVIANCA":{
                transportCode = "1234";
                break;
            }
            case "BOLIVARIANO":{
                transportCode = "1198";
                break;
            }
        }

        String lodigingCode = "2000";

        switch ( at.getLodgingProvider() ){
            case "HILTON":{
                transportCode = "2456";
                break;
            }
            case "CARLTON":{
                transportCode = "2349";
                break;
            }
        }

        AccountId = transportCode+lodigingCode;
        WithdrawalAmount = at.getWithdrawalAmount();
        DepositAmount = at.getDepositAmount();
    }

    public String getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(String transactionId) {
        TransactionId = transactionId;
    }

    public String getTransactionNumber() {
        return TransactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        TransactionNumber = transactionNumber;
    }

    public String getTransactionYear() {
        return TransactionYear;
    }

    public void setTransactionYear(String transactionYear) {
        TransactionYear = transactionYear;
    }

    public String getTransactionMonth() {
        return TransactionMonth;
    }

    public void setTransactionMonth(String transactionMonth) {
        TransactionMonth = transactionMonth;
    }

    public String getTransactionDay() {
        return TransactionDay;
    }

    public void setTransactionDay(String transactionDay) {
        TransactionDay = transactionDay;
    }

    public String getAccountId() {
        return AccountId;
    }

    public void setAccountId(String accountId) {
        AccountId = accountId;
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

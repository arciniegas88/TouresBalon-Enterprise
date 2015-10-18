package co.com.foundation.middleware.model;

import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.ByteArrayOutputStream;
import java.io.File;

/**
 * Created by garciniegas on 18/10/2015.
 */


@XmlRootElement(name = "AccountTransaction", namespace = "http://touresbalon.com.co/accounting/service/entity/1.0.0")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType( propOrder = {
        "TransactionId",
        "TransactionNumber",
        "TransactionYear",
        "TransactionMonth",
        "TransactionDay",
        "TransportProvider",
        "LodgingProvider",
        "WithdrawalAmount",
        "DepositAmount"
})
@FixedLengthRecord(length = 100)
public class AccountTransaction {

    @DataField(pos = 1, length=10)
    private String TransactionId;
    @DataField(pos = 11, length=10)
    private String TransactionNumber;
    @DataField(pos = 21, length=6)
    private String TransactionYear;
    @DataField(pos = 27, length=6)
    private String TransactionMonth;
    @DataField(pos = 33, length=6)
    private String TransactionDay;
    @DataField(pos = 39, length=20)
    private String TransportProvider;
    @DataField(pos = 59, length=20)
    private String LodgingProvider;
    @DataField(pos = 79, length=10)
    private String WithdrawalAmount;
    @DataField(pos = 89, length=10)
    private String DepositAmount;

    public static void main( String[] args )throws Exception{

        JAXBContext ctx = JAXBContext.newInstance(AccountTransaction.class);
        //Marshaller um = ctx.createMarshaller();
        AccountTransaction a = new AccountTransaction();
        a.setDepositAmount("100000");
        //um.marshal(a, System.out);

        Unmarshaller um = ctx.createUnmarshaller();
        a = (AccountTransaction) um.unmarshal( new File("C:/touresbalon/microfocus/payments.dat"));
        System.out.println( a.getLodgingProvider() );

        DataFormat bindy = new BindyCsvDataFormat(AccountTransaction.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

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

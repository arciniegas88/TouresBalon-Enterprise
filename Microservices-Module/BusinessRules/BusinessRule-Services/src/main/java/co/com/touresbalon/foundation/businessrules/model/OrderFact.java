package co.com.touresbalon.foundation.businessrules.model;

/**
 * Created by Jenny on 23/09/2015.
 */
public class OrderFact {

    private String userType;
    private Long orderAmount;

    // response --------------------------
    private boolean approval;


    public OrderFact() {
        super();
    }

    public OrderFact(String userType, Long orderAmount, boolean approval) {
        this.userType = userType;
        this.orderAmount = orderAmount;
        this.approval = approval;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Long getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
    }

    public boolean getApproval() {
        return approval;
    }

    public void setApproval(boolean approval) {
        this.approval = approval;
    }

    @Override
    public String toString() {
        return "SalenOrders{" +
                "userType='" + userType + '\'' +
                ", orderAmount=" + orderAmount +
                ", approval='" + approval + '\'' +
                '}';
    }
}

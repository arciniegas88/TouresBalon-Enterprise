package co.com.touresbalon.foundation.oms.domain.orderprocessing;

/**
 * Created by Jenny on 25/10/2015.
 */

public class CancelOrdersBPELRequest {

    private final String content;
    private Long orderId;

    public CancelOrdersBPELRequest(Long orderId) {
        this.orderId = orderId;

        content = "<ns:Cancel-Orders-BPELRequest xmlns:ns=\"http://touresbalon.com.co/orders/service/task/1.0.0\">"
                + "<ns:orderId xmlns:ns=\"http://touresbalon.com.co/orders/service/task/1.0.0\">" + orderId + "</ns:orderId>"
                + "</ns:Cancel-Orders-BPELRequest>";
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return content;
    }

}

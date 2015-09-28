package co.com.touresbalon.foundation.orders.entity;

/**
 * SalesOrderStatus - sales order status
 * Created by garciniegas on 27/09/2015.
 */

public enum SalesOrderStatus {

    // [enum fields] ---------------------

    IN_VALIDATION("EN VALIDACION"), IN_BOOKING("EN RESERVACION"), CLOSED("CERRADA"), REJECTED("RECHAZADA");

    private String label;

    // ---------------------------

    private SalesOrderStatus( String label ){
        this.label = label;
    }

    public String getLabel(){
        return label;
    }

}
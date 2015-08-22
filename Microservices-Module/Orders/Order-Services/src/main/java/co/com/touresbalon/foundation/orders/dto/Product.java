package co.com.touresbalon.foundation.orders.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Jenny Rodriguez on 22/08/15.
 */
@XmlRootElement
public class Product implements Serializable {

    private  Long idProduct;
    private  String nameProduct;

    public Product(){

    }

    public Product(Long idProduct, String nameProduct ) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

}

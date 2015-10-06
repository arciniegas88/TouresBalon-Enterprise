package co.com.touresbalon.foundation.oms.domain.products;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by garciniegas on 04/10/2015.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "collection")
public class ProductsWrapper {

    //@XmlElement(name = "product")
    private List<Product> product;


    public List<Product> getProduct() {

        if( product == null )
            product = new ArrayList<>();

        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}

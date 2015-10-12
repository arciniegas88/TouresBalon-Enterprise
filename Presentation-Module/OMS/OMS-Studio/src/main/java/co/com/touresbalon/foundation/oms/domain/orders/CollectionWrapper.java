package co.com.touresbalon.foundation.oms.domain.orders;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by garciniegas on 07/10/2015.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wrapper", propOrder = {
        "data"
})
public class CollectionWrapper {

    private List<String> data;

    public CollectionWrapper() {
    }

    public List<String> getData() {

        if( data == null)
            data = new ArrayList<>();

        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}

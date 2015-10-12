package co.com.touresbalon.foundation.orders.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by garciniegas on 07/10/2015.
 */

@XmlRootElement(name = "wrapper")
public class CollectionWrapper {

    private List<String> data;

    public CollectionWrapper() {
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}

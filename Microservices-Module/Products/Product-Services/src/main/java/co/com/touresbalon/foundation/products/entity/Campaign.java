package co.com.touresbalon.foundation.products.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Jenny Rodriguez on 17/08/15.
 */
@Entity
@Table(name = "campaign")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Campaign.findAll",
                query = "SELECT NEW co.com.touresbalon.foundation.products.entity.Campaign(c.name,c.imageRef, c.product.id)  FROM Campaign c",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")})
})
public class Campaign implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "effective_date_up")
    @Temporal(TemporalType.DATE)
    private Date effectiveDate;

    @Lob
    @Column(name = "image_ref")
    private byte[] imageRef;

    @JoinColumn(name = "product_id", referencedColumnName = "Id")
    @ManyToOne
    private Product product;

    public Campaign() {
    }

    public Campaign(String name, byte[] imageRef, Long productId) {
        this.name = name;
        this.imageRef = imageRef;
        product = new Product();
        product.setId(productId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public byte[] getImageRef() {
        return imageRef;
    }

    public void setImageRef(byte[] imageRef) {
        this.imageRef = imageRef;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

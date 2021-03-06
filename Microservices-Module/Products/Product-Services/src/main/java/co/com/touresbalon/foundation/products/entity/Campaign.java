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
                query = "SELECT NEW co.com.touresbalon.foundation.products.entity.Campaign(c.id, c.name,c.imageRef, c.product.id)  FROM Campaign c",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(name = "Campaign.findById",
                 query = "SELECT NEW co.com.touresbalon.foundation.products.entity.Campaign(c.id, c.name, c.effectiveDate,c.imageRef, c.product.id) FROM Campaign c WHERE c.id =:ID"),
        @NamedQuery(name = "Campaign.update", query = "UPDATE Campaign c " +
                           "SET c.name = :NAME, " +
                           "c.imageRef = :IMAGE_REF, " +
                           "c.effectiveDate = :EFFECTIVE_DATE    WHERE c.id = :ID "),
        @NamedQuery(name = "Campaign.delete", query = "DELETE FROM Campaign c WHERE c.id = :ID "),
        @NamedQuery(name = "Campaign.ByIdProduct",
                query = "SELECT NEW co.com.touresbalon.foundation.products.entity.Campaign (c.id, c.name, c.effectiveDate, c.product.id) FROM Campaign c  " +
                        "WHERE c.product.id  = :ID_PRODUCT")
})

@TableGenerator(name="CAMPAIGN_SEQ_GEN",table="virtual_sequences", pkColumnName="gen_key", valueColumnName="gen_value",
        pkColumnValue="CAMPAIGN_SEQ",allocationSize=1)
public class Campaign implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAMPAIGN_SEQ_GEN")
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

    public Campaign(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public Campaign(Long id ,String name, byte[] imageRef, Long productId) {
        this.id = id;
        this.name = name;
        this.imageRef = imageRef;
        product = new Product();
        product.setId(productId);
    }

    public Campaign(Long id, String name, Date effectiveDate, Long productId) {
        this.id = id;
        this.name = name;
        this.effectiveDate = effectiveDate;
        product = new Product();
        product.setId(productId);
    }

    public Campaign(Long id, String name, Date effectiveDate, byte[] imageRef, Long productId) {
        this.id = id;
        this.name = name;
        this.effectiveDate = effectiveDate;
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

package co.com.touresbalon.foundation.microservices.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * Created by harcalejo on 23/09/15.
 */
@Entity()
@XmlRootElement
public class Hotel {
    private Long hotelId;
    private String name;
    private String address;
    private String brand;
    private String city;
    private String country;
    private List<Room> roomsByHotelId;

    public Hotel() {

    }

    @Id
    @Column(name = "HOTEL_ID")
    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "BRAND")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        if (hotelId != null ? !hotelId.equals(hotel.hotelId) : hotel.hotelId != null) return false;
        if (name != null ? !name.equals(hotel.name) : hotel.name != null) return false;
        if (address != null ? !address.equals(hotel.address) : hotel.address != null) return false;
        if (brand != null ? !brand.equals(hotel.brand) : hotel.brand != null) return false;
        if (city != null ? !city.equals(hotel.city) : hotel.city != null) return false;
        return !(country != null ? !country.equals(hotel.country) : hotel.country != null);

    }

    @Override
    public int hashCode() {
        int result = hotelId != null ? hotelId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (brand != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "hotelByHotelId")
    @XmlTransient
    public List<Room> getRoomsByHotelId() {
        return roomsByHotelId;
    }

    public void setRoomsByHotelId(List<Room> roomsByHotelId) {
        this.roomsByHotelId = roomsByHotelId;
    }
}

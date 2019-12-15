package order.service.server.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "customer")
public class Customer extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String email;
    private String street;
    private Integer number;
    private String district;
    private String phone;

    public Customer() {
    }

    public Customer(String name, String email, String street, Integer number, String district, String phone) {
        this.name = name;
        this.email = email;
        this.street = street;
        this.number = number;
        this.district = district;
        this.phone = phone;
    }

    public Customer(String id, String name, String email, String street, Integer number, String district, String phone) {
        super(id);
        this.name = name;
        this.email = email;
        this.street = street;
        this.number = number;
        this.district = district;
        this.phone = phone;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(street, customer.street) &&
                Objects.equals(number, customer.number) &&
                Objects.equals(district, customer.district) &&
                Objects.equals(phone, customer.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, street, number, district, phone);
    }
}

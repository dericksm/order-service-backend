package order.service.server.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "order")
public class Order extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String type;
    private String brand;
    private String problem;
    private String preview;
    private Customer customer;
    private Status status;
    private Float price;

    public enum Status {DONE, IN_PROGRESS}

    public Order() {
    }

    public Order(String type, String brand, String problem, String preview, Customer customer, Status status, Float price) {

        this.type = type;
        this.brand = brand;
        this.problem = problem;
        this.preview = preview;
        this.customer = customer;
        this.status = status;
        this.price = price;
    }

    public Order(String id, String type, String brand, String problem, String preview, Customer customer, Status status, Float price) {
        super(id);
        this.type = type;
        this.brand = brand;
        this.problem = problem;
        this.preview = preview;
        this.customer = customer;
        this.status = status;
        this.price = price;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return
                Objects.equals(type, order.type) &&
                        Objects.equals(brand, order.brand) &&
                        Objects.equals(problem, order.problem) &&
                        Objects.equals(preview, order.preview) &&
                        Objects.equals(customer, order.customer) &&
                        status == order.status &&
                        Objects.equals(price, order.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, brand, problem, preview, customer, status, price);
    }
}

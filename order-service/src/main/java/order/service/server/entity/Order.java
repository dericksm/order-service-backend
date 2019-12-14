package order.service.server.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private Client client;
    private User user;
    private Equipment equipment;
    private Status status;
    private Float price;

    public enum Status { DONE, IN_PROGRESS, NEW }

    public Order() {
    }

    public Order(String id, Client client, User user, Equipment equipment, Status status, Float price) {
        this.id = id;
        this.client = client;
        this.user = user;
        this.equipment = equipment;
        this.status = status;
        this.price = price;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
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
        return Objects.equals(id, order.id) &&
                Objects.equals(client, order.client) &&
                Objects.equals(user, order.user) &&
                Objects.equals(equipment, order.equipment) &&
                status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, user, equipment, status);
    }
}

package order.service.server.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public abstract class AbstractEntity implements Serializable{
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

package order.service.server.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "equipment")
public class Equipment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String type;
    private String brand;
    private String problem;
    private String preview;

    public Equipment() {
    }

    public Equipment(String id, String name, String type, String brand, String problem, String preview) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.problem = problem;
        this.preview = preview;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return Objects.equals(id, equipment.id) &&
                Objects.equals(name, equipment.name) &&
                Objects.equals(type, equipment.type) &&
                Objects.equals(brand, equipment.brand) &&
                Objects.equals(problem, equipment.problem) &&
                Objects.equals(preview, equipment.preview);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, brand, problem, preview);
    }
}

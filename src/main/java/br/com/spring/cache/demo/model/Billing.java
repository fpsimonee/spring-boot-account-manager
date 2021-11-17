package br.com.spring.cache.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "billings")
public class Billing implements Serializable {

    @Id
    private ObjectId _id;
    private String id;

    private String value;
    private String description;
    private String createdAt;

    public Billing(String id,String value, String description, String createdAt) {
        this.id = id;
        this.value = value;
        this.description = description;
        this.createdAt = createdAt;
    }

    public ObjectId get_Id() {
        return _id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void merge(Billing source) {
        if(source.getValue() != null) {
            this.value = source.getValue();
        }

        if(source.getDescription() != null) {
            this.description = source.getDescription();
        }
    }
}

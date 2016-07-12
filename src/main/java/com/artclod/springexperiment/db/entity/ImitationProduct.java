package com.artclod.springexperiment.db.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "imitation_product")
public class ImitationProduct {

    @Id
    @Type(type = "pg-uuid")
    @Column(unique = true, nullable = false)
    private UUID id;

    @Column(name = "description")
    private String description;

    public ImitationProduct() {

    }

    public ImitationProduct(String description) {
        this.id = UUID.randomUUID();
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImitationProduct that = (ImitationProduct) o;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}

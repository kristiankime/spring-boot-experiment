package com.artclod.springexperiment.db.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "imitation_product")
public class ImitationProduct {
    private static final String ORIGINAL_ID = "original_id";

    @Id
    @Type(type = "pg-uuid")
    @Column(unique = true, nullable = false)
    private UUID id;

    @Column(name = "description")
    private String description;

    @Type(type = "pg-uuid")
    @Column(name = ORIGINAL_ID)
    private UUID originalId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = ORIGINAL_ID, insertable = false, updatable = false)
    private OriginalProduct originalProduct;

    public ImitationProduct() {

    }

    public ImitationProduct(String description, UUID originalId) {
        this.id = UUID.randomUUID();
        this.description = description;
        this.originalId = originalId;
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

    public UUID getOriginalId() {
        return originalId;
    }

    public void setOriginalId(UUID originalId) {
        this.originalId = originalId;
    }

    public OriginalProduct getOriginalProduct() {
        return originalProduct;
    }

    public void setOriginalProduct(OriginalProduct originalProduct) {
        this.originalProduct = originalProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImitationProduct that = (ImitationProduct) o;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return originalId != null ? originalId.equals(that.originalId) : that.originalId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (originalId != null ? originalId.hashCode() : 0);
        return result;
    }

}

package com.verhext.sharkmeapi.models;

import java.util.Objects;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "boxAssign", forceQuote = true)
public class BoxAssignModel {
    @PrimaryKey
    private UUID id;
    @Column(forceQuote = true)
    private UUID boxId;
    @Column(forceQuote = true)
    private UUID userId;

    public BoxAssignModel() {
    }

    public BoxAssignModel(UUID id, UUID boxId, UUID userId) {
        this.id = id;
        this.boxId = boxId;
        this.userId = userId;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getBoxId() {
        return this.boxId;
    }

    public void setBoxId(UUID boxId) {
        this.boxId = boxId;
    }

    public UUID getUserId() {
        return this.userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public BoxAssignModel id(UUID id) {
        this.id = id;
        return this;
    }

    public BoxAssignModel boxId(UUID boxId) {
        this.boxId = boxId;
        return this;
    }

    public BoxAssignModel userId(UUID userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BoxAssignModel)) {
            return false;
        }
        BoxAssignModel boxAssignModel = (BoxAssignModel) o;
        return Objects.equals(id, boxAssignModel.id) && Objects.equals(boxId, boxAssignModel.boxId)
                && Objects.equals(userId, boxAssignModel.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, boxId, userId);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", boxId='" + getBoxId() + "'" + ", userId='" + getUserId() + "'" + "}";
    }
}
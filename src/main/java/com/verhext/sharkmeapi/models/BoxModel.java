package com.verhext.sharkmeapi.models;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "box")
public class BoxModel {

    @PrimaryKey
    private UUID id;
    private String name;
    private String description;
    @Column(forceQuote = true)
    private boolean systemBox;
    private List<String> flags;
    @Column(forceQuote = true)
    private java.time.Instant createdAt;
    private String color;

    public BoxModel() {
    }

    public BoxModel(UUID id, String name, String description, boolean systemBox, List<String> flags,
            java.time.Instant createdAt, String color) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.systemBox = systemBox;
        this.flags = flags;
        this.createdAt = createdAt;
        this.color = color;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSystemBox() {
        return this.systemBox;
    }

    public boolean getSystemBox() {
        return this.systemBox;
    }

    public void setSystemBox(boolean systemBox) {
        this.systemBox = systemBox;
    }

    public List<String> getFlags() {
        return this.flags;
    }

    public void setFlags(List<String> flags) {
        this.flags = flags;
    }

    public java.time.Instant getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(java.time.Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BoxModel id(UUID id) {
        this.id = id;
        return this;
    }

    public BoxModel name(String name) {
        this.name = name;
        return this;
    }

    public BoxModel description(String description) {
        this.description = description;
        return this;
    }

    public BoxModel systemBox(boolean systemBox) {
        this.systemBox = systemBox;
        return this;
    }

    public BoxModel flags(List<String> flags) {
        this.flags = flags;
        return this;
    }

    public BoxModel createdAt(java.time.Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public BoxModel color(String color) {
        this.color = color;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BoxModel)) {
            return false;
        }
        BoxModel boxModel = (BoxModel) o;
        return Objects.equals(id, boxModel.id) && Objects.equals(name, boxModel.name)
                && Objects.equals(description, boxModel.description) && systemBox == boxModel.systemBox
                && Objects.equals(flags, boxModel.flags) && Objects.equals(createdAt, boxModel.createdAt)
                && Objects.equals(color, boxModel.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, systemBox, flags, createdAt, color);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", description='" + getDescription() + "'"
                + ", systemBox='" + isSystemBox() + "'" + ", flags='" + getFlags() + "'" + ", createdAt='"
                + getCreatedAt() + "'" + ", color='" + getColor() + "'" + "}";
    }

}
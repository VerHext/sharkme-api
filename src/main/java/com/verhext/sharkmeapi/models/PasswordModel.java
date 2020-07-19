package com.verhext.sharkmeapi.models;

import java.util.Objects;

public class PasswordModel {
    private String password;

    public PasswordModel() {
    }

    public PasswordModel(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PasswordModel password(String password) {
        this.password = password;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PasswordModel)) {
            return false;
        }
        PasswordModel passwordModel = (PasswordModel) o;
        return Objects.equals(password, passwordModel.password);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(password);
    }

    @Override
    public String toString() {
        return "{" + " password='" + getPassword() + "'" + "}";
    }
}
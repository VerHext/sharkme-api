package com.verhext.sharkmeapi.models;

import java.util.Objects;

public class EmailModel {
    private String Email;

    public EmailModel() {
    }

    public EmailModel(String Email) {
        this.Email = Email;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public EmailModel Email(String Email) {
        this.Email = Email;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof EmailModel)) {
            return false;
        }
        EmailModel emailModel = (EmailModel) o;
        return Objects.equals(Email, emailModel.Email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Email);
    }

    @Override
    public String toString() {
        return "{" + " Email='" + getEmail() + "'" + "}";
    }
}
package com.verhext.sharkmeapi.models;

import java.util.Objects;
import java.util.UUID;

public class UserModel {
    private UUID id;
    private String email;
    private String username;
    private String fname;
    private String lname;
    private boolean isPro;

    public UserModel() {
    }

    public UserModel(UUID id, String email, String username, String fname, String lname, boolean isPro) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.fname = fname;
        this.lname = lname;
        this.isPro = isPro;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return this.lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public boolean isIsPro() {
        return this.isPro;
    }

    public boolean getIsPro() {
        return this.isPro;
    }

    public void setIsPro(boolean isPro) {
        this.isPro = isPro;
    }

    public UserModel id(UUID id) {
        this.id = id;
        return this;
    }

    public UserModel email(String email) {
        this.email = email;
        return this;
    }

    public UserModel username(String username) {
        this.username = username;
        return this;
    }

    public UserModel fname(String fname) {
        this.fname = fname;
        return this;
    }

    public UserModel lname(String lname) {
        this.lname = lname;
        return this;
    }

    public UserModel isPro(boolean isPro) {
        this.isPro = isPro;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserModel)) {
            return false;
        }
        UserModel userModel = (UserModel) o;
        return Objects.equals(id, userModel.id) && Objects.equals(email, userModel.email)
                && Objects.equals(username, userModel.username) && Objects.equals(fname, userModel.fname)
                && Objects.equals(lname, userModel.lname) && isPro == userModel.isPro;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, username, fname, lname, isPro);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", email='" + getEmail() + "'" + ", username='" + getUsername() + "'"
                + ", fname='" + getFname() + "'" + ", lname='" + getLname() + "'" + ", isPro='" + isIsPro() + "'" + "}";
    }

}
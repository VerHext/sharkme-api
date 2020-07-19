package com.verhext.sharkmeapi.models;

import java.util.Objects;

public class NameModel {
    private String fname;
    private String lname;

    public NameModel() {
    }

    public NameModel(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
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

    public NameModel fname(String fname) {
        this.fname = fname;
        return this;
    }

    public NameModel lname(String lname) {
        this.lname = lname;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof NameModel)) {
            return false;
        }
        NameModel nameModel = (NameModel) o;
        return Objects.equals(fname, nameModel.fname) && Objects.equals(lname, nameModel.lname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fname, lname);
    }

    @Override
    public String toString() {
        return "{" + " fname='" + getFname() + "'" + ", lname='" + getLname() + "'" + "}";
    }
}
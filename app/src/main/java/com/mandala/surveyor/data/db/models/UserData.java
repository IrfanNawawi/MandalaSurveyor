package com.mandala.surveyor.data.db.models;

import com.google.gson.annotations.SerializedName;

public class UserData {
    @SerializedName("id")
    private int id;
    @SerializedName("nik")
    private String nik;
    @SerializedName("password")
    private String password;
    @SerializedName("status")
    private int status;

    public UserData(int id, String nik, String password, int status) {
        this.id = id;
        this.nik = nik;
        this.password = password;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", nik='" + nik + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

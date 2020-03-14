package com.mandala.surveyor.data.db.response;

import com.google.gson.annotations.SerializedName;
import com.mandala.surveyor.data.db.models.UserData;

import java.util.List;

public class UserResponse {
    @SerializedName("status")
    private String status;

    @SerializedName("msg")
    private List<UserData> user;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<UserData> getUser() {
        return user;
    }

    public void setUser(List<UserData> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "status='" + status + '\'' +
                ", user=" + user +
                '}';
    }
}

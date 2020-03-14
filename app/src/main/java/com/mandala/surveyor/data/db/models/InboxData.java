package com.mandala.surveyor.data.db.models;

public class InboxData {
    private int flag;
    private String date;

    public InboxData(int flag, String date) {
        this.flag = flag;
        this.date = date;
    }

    public int getFlag() {
        return flag;
    }

    public String getDate() {
        return date;
    }
}

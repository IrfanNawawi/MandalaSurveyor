package com.mandala.surveyor.data.db.response;

import com.mandala.surveyor.data.db.models.Penugasan;

import java.util.List;

public class PenugasanResponse {
    private List<Penugasan> penugasanList;

    public List<Penugasan> getPenugasanList() {
        return penugasanList;
    }

    public void setPenugasanList(List<Penugasan> penugasanList) {
        this.penugasanList = penugasanList;
    }
}

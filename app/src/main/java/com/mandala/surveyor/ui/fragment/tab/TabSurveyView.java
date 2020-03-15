package com.mandala.surveyor.ui.fragment.tab;

import com.mandala.surveyor.data.db.models.Penugasan;

import java.util.List;

public interface TabSurveyView {
    void onSuccess(List<Penugasan> result);

    void onError(String message);
}

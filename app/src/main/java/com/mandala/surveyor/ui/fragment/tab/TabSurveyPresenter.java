package com.mandala.surveyor.ui.fragment.tab;

import android.util.Log;

import com.mandala.surveyor.data.db.models.Penugasan;
import com.mandala.surveyor.data.db.response.PenugasanResponse;
import com.mandala.surveyor.data.network.ApiInterface;
import com.mandala.surveyor.data.network.ApiServices;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabSurveyPresenter {
    TabSurveyView tabSurveyView;
    ApiServices services;
    List<Penugasan> penugasanList = new ArrayList<>();

    public TabSurveyPresenter(TabSurveyView tabSurveyView) {
        this.tabSurveyView = tabSurveyView;
    }

    public void getListPenugasan(){
        services = ApiInterface.getService();
        Call<PenugasanResponse> call = services.getPenugasan();
        call.enqueue(new Callback<PenugasanResponse>() {
            @Override
            public void onResponse(Call<PenugasanResponse> call, Response<PenugasanResponse> response) {
                Log.d("RESULT", response.toString());
                List<Penugasan> item = response.body().getPenugasanList();
                penugasanList.addAll(item);
                tabSurveyView.onSuccess(penugasanList);
            }

            @Override
            public void onFailure(Call<PenugasanResponse> call, Throwable t) {
                tabSurveyView.onError("No Data");
                Log.d("RESULT", t.toString());
            }
        });
    }
}

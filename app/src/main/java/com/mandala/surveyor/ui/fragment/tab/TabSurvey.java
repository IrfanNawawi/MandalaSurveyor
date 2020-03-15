package com.mandala.surveyor.ui.fragment.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mandala.surveyor.R;
import com.mandala.surveyor.data.db.models.Penugasan;
import com.mandala.surveyor.data.db.models.SurveyData;
import com.mandala.surveyor.ui.adapter.AdapterSurvey;
import com.mandala.surveyor.utils.RecyclerViewUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TabSurvey extends Fragment implements TabSurveyView{

    Unbinder unbinder;
    AdapterSurvey adapterSurvey;
    RecyclerViewUtil recyclerViewUtil;
    TabSurveyPresenter presenter;

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_survey, container, false);
        unbinder = ButterKnife.bind(this, v);
        presenter = new TabSurveyPresenter(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);

        recyclerViewUtil = new RecyclerViewUtil(getActivity(), R.dimen.recycler_margin);
        mRecyclerView.addItemDecoration(recyclerViewUtil);

        return v;
    }

//    private List<SurveyData> getRecyclerData() {
//        List<SurveyData> recyclerList = new ArrayList<>();
//        recyclerList.add(new SurveyData(0, "10", "5181663991681", "John Doe A", "Otomotive", "Jl. H.Mamad Bekasi", "Kalibata", "Pancoran", "Bekasi", "Bekasi", "089989786764", "089989786764", "Baru", "AISI", "Honda", "Mobil", "Honda Jazz"));
//        recyclerList.add(new SurveyData(1, "10", "5181663991682", "John Doe B", "Otomotive", "Jl. H.Samali Ujung II Pasar Minggu", "Kalibata", "Pancoran", "Jakarta Selatan", "DKI Jakarta", "089989786764", "089989786764", "Baru", "AISI", "Yamaha", "Motor", "Yamaha Aerox"));
//        recyclerList.add(new SurveyData(1, "10", "5181663991683", "John Doe C", "Micro", "Jl. H.Samali Ujung II Pasar Minggu", "Kalibata", "Pancoran", "Jakarta Selatan", "DKI Jakarta", "089989786764", "089989786764", "Baru", "AISI", "Cepot", "Beras", "Beras Pera"));
//        recyclerList.add(new SurveyData(0, "10", "5181663991684", "John Doe D", "Electronic", "Jl. Ujung Menteng", "Menteng", "Pancoran", "Jakarta Pusat", "DKI Jakarta", "089989786764", "089989786764", "Baru", "AISI", "LG", "Handphone", "V20 ThinQ"));
//
//        return recyclerList;
//    }

    @Override
    public void onSuccess(List<Penugasan> result) {
        adapterSurvey = new AdapterSurvey(result, getActivity());
        mRecyclerView.setAdapter(adapterSurvey);
    }

    @Override
    public void onError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}

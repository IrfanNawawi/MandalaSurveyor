package com.mandala.surveyor.ui.activity.takstator;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.mandala.surveyor.R;
import com.mandala.surveyor.data.db.models.SurveyData;
import com.mandala.surveyor.ui.adapter.AdapterTakstator;
import com.mandala.surveyor.utils.RecyclerViewUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TakstatorActivity extends AppCompatActivity {

    AdapterTakstator adapterTakstator;
    RecyclerViewUtil recyclerViewUtil;

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takstator);
        ButterKnife.bind(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setHasFixedSize(true);

        recyclerViewUtil = new RecyclerViewUtil(this, R.dimen.recycler_margin);
        mRecyclerView.addItemDecoration(recyclerViewUtil);

        adapterTakstator = new AdapterTakstator(getRecyclerData(), getApplicationContext());
        mRecyclerView.setAdapter(adapterTakstator);
    }

    private List<SurveyData> getRecyclerData() {
        List<SurveyData> recyclerList = new ArrayList<>();
        recyclerList.add(new SurveyData(0, "10", "5181663991681", "John Doe A", "Otomotive", "Jl. H.Mamad Bekasi", "Kalibata", "Pancoran", "Bekasi", "Bekasi", "089989786764", "089989786764", "Baru", "AISI", "Honda", "Mobil", "Honda Jazz"));
        recyclerList.add(new SurveyData(1, "10", "5181663991682", "John Doe B", "Otomotive", "Jl. H.Samali Ujung II Pasar Minggu", "Kalibata", "Pancoran", "Jakarta Selatan", "DKI Jakarta", "089989786764", "089989786764", "Baru", "AISI", "Yamaha", "Motor", "Yamaha Aerox"));
        recyclerList.add(new SurveyData(1, "10", "5181663991683", "John Doe C", "Micro", "Jl. H.Samali Ujung II Pasar Minggu", "Kalibata", "Pancoran", "Jakarta Selatan", "DKI Jakarta", "089989786764", "089989786764", "Baru", "AISI", "Cepot", "Beras", "Beras Pera"));
        recyclerList.add(new SurveyData(0, "10", "5181663991684", "John Doe D", "Electronic", "Jl. Ujung Menteng", "Menteng", "Pancoran", "Jakarta Pusat", "DKI Jakarta", "089989786764", "089989786764", "Baru", "AISI", "LG", "Handphone", "V20 ThinQ"));

        return recyclerList;
    }
}

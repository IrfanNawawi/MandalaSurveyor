package com.mandala.surveyor.ui.activity.history;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.mandala.surveyor.R;
import com.mandala.surveyor.data.db.models.HistoryAbsenData;
import com.mandala.surveyor.ui.adapter.AdapterHistoryAbsen;
import com.mandala.surveyor.utils.RecyclerViewUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryAbsen extends AppCompatActivity {

    AdapterHistoryAbsen adapterHistoryAbsen;
    RecyclerViewUtil recyclerViewUtil;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_absen);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("History Absen");

        mRecyclerView.setLayoutManager(new LinearLayoutManager(HistoryAbsen.this));
        mRecyclerView.setHasFixedSize(true);

        recyclerViewUtil = new RecyclerViewUtil(HistoryAbsen.this, R.dimen.recycler_margin);
        mRecyclerView.addItemDecoration(recyclerViewUtil);

        adapterHistoryAbsen = new AdapterHistoryAbsen(getRecyclerData(), this);
        mRecyclerView.setAdapter(adapterHistoryAbsen);
    }

    private List<HistoryAbsenData> getRecyclerData() {
        List<HistoryAbsenData> recyclerList = new ArrayList<>();
        recyclerList.add(new HistoryAbsenData(R.drawable.ic_img_photo, "Absen Masuk", "John Doe", "1234567890", "Jakarta Selatan", "Surveyor", "07/07/2019 08:30", 1));
        recyclerList.add(new HistoryAbsenData(R.drawable.ic_img_photo, "Absen Telat", "John Doe", "1234567890", "Jakarta Selatan", "Surveyor", "07/07/2019 08:30", 2));
        recyclerList.add(new HistoryAbsenData(R.drawable.ic_img_photo, "Absen Pulang", "John Doe", "1234567890", "Jakarta Selatan", "Surveyor", "07/07/2019 08:30", 3));
        recyclerList.add(new HistoryAbsenData(R.drawable.ic_img_photo, "Absen Masuk", "John Doe", "1234567890", "Jakarta Selatan", "Surveyor", "07/07/2019 08:30", 1));
        recyclerList.add(new HistoryAbsenData(R.drawable.ic_img_photo, "Absen Telat", "John Doe", "1234567890", "Jakarta Selatan", "Surveyor", "07/07/2019 08:30", 2));

        return recyclerList;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        finish();
    }
}

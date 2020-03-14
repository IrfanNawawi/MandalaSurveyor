package com.mandala.surveyor.ui.activity.kelengkapandata;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.mandala.surveyor.R;
import com.mandala.surveyor.data.db.models.KelengkapanData;
import com.mandala.surveyor.ui.adapter.AdapterKelengkapanData;
import com.mandala.surveyor.utils.RecyclerViewUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;


public class KelengkapanDataActivity extends AppCompatActivity {

    AdapterKelengkapanData adapterKelengkapanData;
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
        setContentView(R.layout.activity_kelengkapan_data);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Kelengkapan Data");

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        recyclerViewUtil = new RecyclerViewUtil(this, R.dimen.recycler_margin);
        mRecyclerView.addItemDecoration(recyclerViewUtil);

        adapterKelengkapanData = new AdapterKelengkapanData(getRecyclerData(), this);
        mRecyclerView.setAdapter(adapterKelengkapanData);
    }

    private List<KelengkapanData> getRecyclerData() {
        List<KelengkapanData> recyclerList = new ArrayList<>();
        recyclerList.add(new KelengkapanData("1234567890", "29 Feb 2019", "John Doe", "Electronic", "Jalan H Sulam No.32, Gang Sempit, Kota Santri, Jakarta Selatan"));
        recyclerList.add(new KelengkapanData("1234567890", "29 Feb 2019", "John Doe", "Electronic", "Jalan H Sulam No.32, Gang Sempit, Kota Santri, Jakarta Selatan"));
        recyclerList.add(new KelengkapanData("1234567890", "29 Feb 2019", "John Doe", "Electronic", "Jalan H Sulam No.32, Gang Sempit, Kota Santri, Jakarta Selatan"));

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

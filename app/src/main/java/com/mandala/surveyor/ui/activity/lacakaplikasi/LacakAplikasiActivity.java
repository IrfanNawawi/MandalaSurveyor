package com.mandala.surveyor.ui.activity.lacakaplikasi;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.mandala.surveyor.R;
import com.mandala.surveyor.data.db.models.LacakAplikasiData;
import com.mandala.surveyor.ui.adapter.AdapterLacakAplikasi;
import com.mandala.surveyor.utils.RecyclerViewUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;


public class LacakAplikasiActivity extends AppCompatActivity {

    AdapterLacakAplikasi adapterLacakAplikasi;
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
        setContentView(R.layout.activity_lacak_aplikasi);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Lacak Aplikasi");

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        recyclerViewUtil = new RecyclerViewUtil(this, R.dimen.recycler_margin);
        mRecyclerView.addItemDecoration(recyclerViewUtil);

        adapterLacakAplikasi = new AdapterLacakAplikasi(getRecyclerData(), this);
        mRecyclerView.setAdapter(adapterLacakAplikasi);
    }

    private List<LacakAplikasiData> getRecyclerData() {
        List<LacakAplikasiData> recyclerList = new ArrayList<>();
        recyclerList.add(new LacakAplikasiData("29 Feb 2019", "12345678910", "John Doe", "Electronic", "Jalan H Sulam No.32, Gang Sempit, Kota Santri, Jakarta Selatan", 0));
        recyclerList.add(new LacakAplikasiData("29 Feb 2019", "12345678910", "John Doe", "Electronic", "Jalan H Sulam No.32, Gang Sempit, Kota Santri, Jakarta Selatan", 1));
        recyclerList.add(new LacakAplikasiData("29 Feb 2019", "12345678910", "John Doe", "Electronic", "Jalan H Sulam No.32, Gang Sempit, Kota Santri, Jakarta Selatan", 3));
        recyclerList.add(new LacakAplikasiData("29 Feb 2019", "12345678910", "John Doe", "Electronic", "Jalan H Sulam No.32, Gang Sempit, Kota Santri, Jakarta Selatan", 2));

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

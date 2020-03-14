package com.mandala.surveyor.ui.activity.kelengkapandata;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.mandala.surveyor.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;


public class KelengkapanDataDetail extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.no_booking)
    TextView noBooking;
    @BindView(R.id.tgl_booking)
    TextView tglBooking;
    @BindView(R.id.nama)
    TextView nama;
    @BindView(R.id.kategori)
    TextView kategori;
    @BindView(R.id.alamat)
    TextView alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_kelengkapan_data);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Kelengkapan Data");
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

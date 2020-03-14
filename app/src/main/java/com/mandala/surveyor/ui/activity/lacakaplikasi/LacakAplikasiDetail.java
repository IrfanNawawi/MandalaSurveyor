package com.mandala.surveyor.ui.activity.lacakaplikasi;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mandala.surveyor.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;


public class LacakAplikasiDetail extends AppCompatActivity {

    @BindView(R.id.badge_status)
    View badgeStatus;
    @BindView(R.id.no_aplikasi)
    TextView noAplikasi;
    @BindView(R.id.nama)
    TextView nama;
    @BindView(R.id.kategori)
    TextView kategori;
    @BindView(R.id.alamat)
    TextView alamat;
    @BindView(R.id.tgl_terima)
    TextView tglTerima;
    @BindView(R.id.survey)
    TextView survey;
    @BindView(R.id.selesai)
    TextView selesai;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_lacak_aplikasi);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Lacak Aplikasi");
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

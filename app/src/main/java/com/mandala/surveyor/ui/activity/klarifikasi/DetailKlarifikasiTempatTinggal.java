package com.mandala.surveyor.ui.activity.klarifikasi;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.mandala.surveyor.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailKlarifikasiTempatTinggal extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_kategori)
    TextView tvKategori;
    @BindView(R.id.view_daya_listrik)
    LinearLayout viewDayaListrik;
    @BindView(R.id.view_tempat_tinggal_micro)
    LinearLayout viewTempatTinggalMicro;
    @BindView(R.id.spinner_kepemilikan_tempat_tinggal)
    Spinner spinnerKepemilikanTempatTinggal;
    @BindView(R.id.spinner_lama_tinggal)
    Spinner spinnerLamaTinggal;
    @BindView(R.id.spinner_daya_listrik)
    Spinner spinnerDayaListrik;
    @BindView(R.id.spinner_kondisi_bangunan_rumah)
    Spinner spinnerKondisiBangunanRumah;
    @BindView(R.id.spinner_nilai_asset_kepemilikan)
    Spinner spinnerNilaiAssatKepemilikan;
    @BindView(R.id.btn_save)
    Button btnSave;
    private ArrayAdapter<String> adapterNullForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_klarifikasi_tempat_tinggal);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Klarifikasi Tempat Tinggal");

        adapterNullForm = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item) {
            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View v = super.getDropDownView(position, convertView, parent);
                return v;
            }
        };
        adapterNullForm.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterNullForm.add("---");
        spinnerKepemilikanTempatTinggal.setAdapter(adapterNullForm);
        spinnerLamaTinggal.setAdapter(adapterNullForm);
        spinnerDayaListrik.setAdapter(adapterNullForm);
        spinnerKondisiBangunanRumah.setAdapter(adapterNullForm);
        spinnerNilaiAssatKepemilikan.setAdapter(adapterNullForm);

        initViewVisibleForm();
    }

    private void initViewVisibleForm() {
        String kategory = getIntent().getStringExtra("CATEGORY");
        tvKategori.setText(kategory);

        if (kategory.equals("Micro")) {
            viewDayaListrik.setVisibility(View.GONE);
            viewTempatTinggalMicro.setVisibility(View.VISIBLE);
        }
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

    @OnClick({
            R.id.btn_save
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_save:

                break;
        }
    }
}

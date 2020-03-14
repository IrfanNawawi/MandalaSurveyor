package com.mandala.surveyor.ui.activity.klarifikasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;

import com.mandala.surveyor.R;
import com.mandala.surveyor.ui.activity.taksasi.DetailDataJaminan;
import com.mandala.surveyor.ui.activity.taksasi.DetailTaksasiBody;
import com.mandala.surveyor.ui.activity.taksasi.DetailTaksasiExterior;
import com.mandala.surveyor.ui.activity.taksasi.DetailTaksasiFoto;
import com.mandala.surveyor.ui.activity.taksasi.DetailTaksasiKaroseri;
import com.mandala.surveyor.ui.activity.taksasi.DetailTaksasiKelistrikan;
import com.mandala.surveyor.ui.activity.taksasi.DetailTaksasiMesin;
import com.mandala.surveyor.ui.activity.taksasi.DetailTaksasiRangka;
import com.mandala.surveyor.ui.activity.taksasi.DetailTaksasiSparepart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.view.View.GONE;

public class DetailTaksasi extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.view_taksasi_mobil)
    LinearLayout viewTaksasiMobil;
    @BindView(R.id.view_taksasi_motor)
    LinearLayout viewTaksasiMotor;
    @BindView(R.id.view_kelistrikan)
    LinearLayout viewKelistrikan;
    @BindView(R.id.btn_body)
    LinearLayout btnBody;
    @BindView(R.id.btn_mesin)
    LinearLayout btnMesin;
    @BindView(R.id.btn_rangka)
    LinearLayout btnRangka;
    @BindView(R.id.btn_kelistrikan)
    LinearLayout btnKelistrikan;
    @BindView(R.id.btn_exterior)
    LinearLayout btnExterior;
    @BindView(R.id.btn_karoseri)
    LinearLayout btnKaroseri;
    @BindView(R.id.btn_sparepart)
    LinearLayout btnSparepart;
    @BindView(R.id.btn_lainnya)
    LinearLayout btnLainnya;
    @BindView(R.id.btn_foto_kendaraan)
    LinearLayout btnFotoKendaraan;
    @BindView(R.id.btn_save)
    Button btnSave;
    private ArrayAdapter<String> adapterNullForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_taksasi);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Taksasi");

        initViewVisibleForm();
    }

    private void initViewVisibleForm() {
        String typeTaksasi = getIntent().getStringExtra("TYPE");

        if (typeTaksasi.equals("Mobil")) {
            viewTaksasiMobil.setVisibility(View.VISIBLE);
            viewTaksasiMotor.setVisibility(GONE);
        } else if (typeTaksasi.equals("Motor")) {
            viewTaksasiMotor.setVisibility(View.VISIBLE);
            viewTaksasiMobil.setVisibility(GONE);
            viewKelistrikan.setVisibility(View.VISIBLE);

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
            R.id.btn_body,
            R.id.btn_rangka,
            R.id.btn_mesin,
            R.id.btn_kelistrikan,
            R.id.btn_exterior,
            R.id.btn_karoseri,
            R.id.btn_sparepart,
            R.id.btn_lainnya,
            R.id.btn_foto_kendaraan,
            R.id.btn_save
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_body:
                startActivity(new Intent(getApplicationContext(), DetailTaksasiBody.class));
                break;
            case R.id.btn_rangka:
                startActivity(new Intent(getApplicationContext(), DetailTaksasiRangka.class));
                break;
            case R.id.btn_mesin:
                startActivity(new Intent(getApplicationContext(), DetailTaksasiMesin.class));
                break;
            case R.id.btn_kelistrikan:
                startActivity(new Intent(getApplicationContext(), DetailTaksasiKelistrikan.class));
                break;
            case R.id.btn_exterior:
                startActivity(new Intent(getApplicationContext(), DetailTaksasiExterior.class));
                break;
            case R.id.btn_karoseri:
                startActivity(new Intent(getApplicationContext(), DetailTaksasiKaroseri.class));
                break;
            case R.id.btn_sparepart:
                startActivity(new Intent(getApplicationContext(), DetailTaksasiSparepart.class));
                break;
            case R.id.btn_lainnya:
                startActivity(new Intent(getApplicationContext(), DetailDataJaminan.class));
                break;
            case R.id.btn_foto_kendaraan:
                startActivity(new Intent(getApplicationContext(), DetailTaksasiFoto.class));
                break;
            case R.id.btn_save:

                break;
        }
    }
}

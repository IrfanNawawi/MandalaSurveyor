package com.mandala.surveyor.ui.activity.dokumen;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mandala.surveyor.R;

import java.io.File;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DokumenPenghasilan extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    //Get Value
    @BindView(R.id.tv_kategori)
    TextView tvKategori;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.tv_foto_sku)
    TextView tvFotoSKU;
    //View Visible
    @BindView(R.id.view_karyawan_motor)
    LinearLayout viewKaryawanMotor;
    @BindView(R.id.view_karyawan_mobil)
    LinearLayout viewKaryawanMobil;
    @BindView(R.id.view_wiraswasta_motor)
    LinearLayout viewWiraswastaMotor;
    //Foto Slip
    @BindView(R.id.btn_foto_slip)
    RelativeLayout btnFotoSlip;
    @BindView(R.id.img_foto_slip)
    ImageView imgFotoSlip;
    @BindView(R.id.place_foto_slip)
    LinearLayout placeFotoSlip;
    //Foto SKU
    @BindView(R.id.btn_foto_sku)
    RelativeLayout btnFotoSku;
    @BindView(R.id.img_foto_sku)
    ImageView imgFotoSku;
    @BindView(R.id.place_foto_sku)
    LinearLayout placeFotoSku;
    //Foto Rekening Koran
    @BindView(R.id.btn_foto_rek_koran)
    RelativeLayout btnFotoRekKoran;
    @BindView(R.id.img_foto_rek_koran)
    ImageView imgFotoRekKoran;
    @BindView(R.id.place_foto_rek_koran)
    LinearLayout placeFotoRekKoran;
    //Option Form
    @BindView(R.id.btn_save)
    Button btnSave;
    private File tempFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_dokumen_penghasilan);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Foto Dokumen");


        initViewVisibleForm();
    }

    private void initViewVisibleForm() {
        String kategory = getIntent().getStringExtra("CATEGORY");
        String type = getIntent().getStringExtra("TYPE");
        tvKategori.setText(kategory);
        tvType.setText(type);

        if (kategory.equals("Otomotive") && type.equals("Mobil")) {
            viewKaryawanMotor.setVisibility(View.VISIBLE);
            viewKaryawanMobil.setVisibility(View.VISIBLE);
        } else if (kategory.equals("Otomotive") && type.equals("Motor")) {
            viewKaryawanMotor.setVisibility(View.VISIBLE);
        } else if (kategory.equals("Electronic")) {
            viewKaryawanMotor.setVisibility(View.VISIBLE);
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

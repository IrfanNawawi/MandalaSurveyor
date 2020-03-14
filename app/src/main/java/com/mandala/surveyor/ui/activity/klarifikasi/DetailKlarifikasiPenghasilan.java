package com.mandala.surveyor.ui.activity.klarifikasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mandala.surveyor.R;
import com.mandala.surveyor.ui.activity.dokumen.DokumenPenghasilan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailKlarifikasiPenghasilan extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_kategori)
    TextView tvKategori;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.input_pendapatan_pemohon)
    EditText inputPendapatanPemohon;
    @BindView(R.id.input_pendapatan_tambahan_pemohon)
    EditText inputPendapatanTambahanPemohon;
    @BindView(R.id.input_pendapatan_pasangan)
    EditText inputPendapatanPasangan;
    @BindView(R.id.input_pendapatan_tambahan_pasangan)
    EditText inputPendapatanTambahanPasangan;
    @BindView(R.id.input_total_pendapatan)
    EditText inputTotalPendapatan;
    @BindView(R.id.input_biaya_hidup)
    EditText inputBiayaHidup;
    @BindView(R.id.input_angsuran_lainnya)
    EditText inputAngsuranLainnya;
    @BindView(R.id.input_sisa_pendapatan)
    EditText inputSisaPendapatan;
    @BindView(R.id.btn_next)
    Button btnNext;
    @BindView(R.id.btn_save)
    Button btnSave;
    private ArrayAdapter<String> adapterNullForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_klarifikasi_penghasilan);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Klarifikasi Penghasilan");

        initViewVisibleForm();
    }

    private void initViewVisibleForm() {
        String kategory = getIntent().getStringExtra("CATEGORY");
        String type = getIntent().getStringExtra("TYPE");
        tvKategori.setText(kategory);
        tvType.setText(type);
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
            R.id.btn_next,
            R.id.btn_save
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_next:
                String varKategori = tvKategori.getText().toString();
                String varType = tvType.getText().toString();

                Intent intentVar = new Intent(getApplicationContext(), DokumenPenghasilan.class);
                intentVar.putExtra("CATEGORY", varKategori);
                intentVar.putExtra("TYPE", varType);
                startActivity(intentVar);
                break;
            case R.id.btn_save:

                break;
        }
    }
}

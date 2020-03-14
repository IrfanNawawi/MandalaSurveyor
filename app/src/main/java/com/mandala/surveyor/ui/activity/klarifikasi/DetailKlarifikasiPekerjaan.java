package com.mandala.surveyor.ui.activity.klarifikasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

public class DetailKlarifikasiPekerjaan extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_kategori)
    TextView tvKategori;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.spinner_pekerjaan)
    Spinner spinnerPekerjaan;
    @BindView(R.id.spinner_jenis_pekerjaan)
    Spinner spinnerJenisPekerjaan;
    @BindView(R.id.spinner_sektor_ekonomi)
    Spinner spinnerSektorEkonomi;
    @BindView(R.id.input_name_perusahaan)
    EditText inputNamaPerusahaan;
    @BindView(R.id.input_lama_perusahaan)
    EditText inputLamaPerusahaan;
    @BindView(R.id.input_alamat)
    EditText inputAlamat;
    @BindView(R.id.input_rt)
    EditText inputRT;
    @BindView(R.id.input_rw)
    EditText inputRW;
    @BindView(R.id.input_kodepos)
    EditText inputKodePos;
    @BindView(R.id.spinner_jumlah_karyawan)
    Spinner spinnerJumlahKaryawan;
    @BindView(R.id.spinner_masa_kerja)
    Spinner spinnerMasaKerja;
    @BindView(R.id.spinner_status_kepegawaian)
    Spinner spinnerStatusKepegawaian;
    @BindView(R.id.spinner_jabatan)
    Spinner spinnerJabatan;
    @BindView(R.id.btn_save)
    Button btnSave;
    @BindView(R.id.btn_next)
    Button btnNext;
    private ArrayAdapter<String> adapterNullForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_klarifikasi_pekerjaan);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Klarifikasi Pekerjaan");

        adapterNullForm = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item) {
            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View v = super.getDropDownView(position, convertView, parent);
                return v;
            }
        };
        adapterNullForm.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterNullForm.add("---");
        spinnerPekerjaan.setAdapter(adapterNullForm);
        spinnerJenisPekerjaan.setAdapter(adapterNullForm);
        spinnerSektorEkonomi.setAdapter(adapterNullForm);
        spinnerJumlahKaryawan.setAdapter(adapterNullForm);
        spinnerMasaKerja.setAdapter(adapterNullForm);
        spinnerStatusKepegawaian.setAdapter(adapterNullForm);
        spinnerJabatan.setAdapter(adapterNullForm);

        initViewVisibleForm();
    }

    private void initViewVisibleForm() {
        String kategory = getIntent().getStringExtra("CATEGORY");
        String type = getIntent().getStringExtra("TYPE");

        tvType.setText(type);
        tvKategori.setText(kategory);
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
            R.id.btn_save,
            R.id.btn_next
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_save:

                break;
            case R.id.btn_next:
                String varKategori = tvKategori.getText().toString();
                String varType = tvType.getText().toString();

                Intent intentTaksasi = new Intent(getApplicationContext(), DetailKlarifikasiPenghasilan.class);
                intentTaksasi.putExtra("CATEGORY", varKategori);
                intentTaksasi.putExtra("TYPE", varType);
                startActivity(intentTaksasi);
                break;
        }
    }
}

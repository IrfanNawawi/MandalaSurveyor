package com.mandala.surveyor.ui.activity.klarifikasi;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.mandala.surveyor.R;
import com.mandala.surveyor.ui.activity.dokumen.DokumenKonsumen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailKlarifikasiKonsumen extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_kategori)
    TextView tvKategori;
    @BindView(R.id.view_tipe_agent)
    LinearLayout viewTipeAgent;
    @BindView(R.id.view_sifat_usaha)
    LinearLayout viewSifatUsaha;
    @BindView(R.id.view_pekerjaan)
    LinearLayout viewPekerjaan;
    @BindView(R.id.view_tipe_perorangan_lembaga)
    LinearLayout viewTipePeronganLembaga;
    @BindView(R.id.view_jenis_badan_usaha)
    LinearLayout viewJenisBadanUsaha;
    @BindView(R.id.view_nama_perusahaan)
    LinearLayout viewNamaPerusahaan;
    @BindView(R.id.input_name_sales)
    EditText inputNameSales;
    @BindView(R.id.input_type_agent)
    EditText inputTypeAgent;
    @BindView(R.id.input_sifat_usaha)
    EditText inputSifatUsaha;
    @BindView(R.id.spinner_tipe_konsumen)
    Spinner spinnerTipeKonsumen;
    @BindView(R.id.spinner_pekerjaan)
    Spinner spinnerPekerjaan;
    @BindView(R.id.spinner_tipe_perorangan_lembaga)
    Spinner spinnerTipePeroranganLembaga;
    @BindView(R.id.spinner_jenis_badan_usaha)
    Spinner spinnerJenisBadanUsaha;
    @BindView(R.id.input_nama_perusahaan)
    EditText inputNamaPerusahaan;
    @BindView(R.id.input_tanggal_pendirian)
    EditText inputTanggalPendirian;
    @BindView(R.id.spinner_jenis_identitas_company)
    Spinner spinnerJenisIdentitasCompany;
    @BindView(R.id.input_no_identitas_company)
    EditText inputNoIdentitasCompany;
    @BindView(R.id.input_nama_npwp)
    EditText inputNamaNPWP;
    @BindView(R.id.input_jenis_npwp)
    EditText inputJenisNPWP;
    @BindView(R.id.input_alamat_npwp)
    EditText inputAlamatNPWP;
    @BindView(R.id.input_fullname_konsumen)
    EditText inputFullNameKonsumen;
    @BindView(R.id.input_nama_panggilan)
    EditText inputNamaPanggilan;
    @BindView(R.id.input_tempat_lahir)
    EditText inputTempatLahir;
    @BindView(R.id.spinner_tanggal)
    Spinner spinnerTanggalLahir;
    @BindView(R.id.input_usia)
    EditText inputUsia;
    @BindView(R.id.input_alamat)
    EditText inputAlamat;
    @BindView(R.id.input_rt)
    EditText inputRT;
    @BindView(R.id.input_rw)
    EditText inputRW;
    @BindView(R.id.input_kodepos)
    EditText inputKodepos;
    @BindView(R.id.spinner_provinsi)
    Spinner spinnerProvinsi;
    @BindView(R.id.spinner_kota)
    Spinner spinnerKota;
    @BindView(R.id.spinner_kecamatan)
    Spinner spinnerKecamatan;
    @BindView(R.id.spinner_kelurahan)
    Spinner spinnerKelurahan;
    @BindView(R.id.input_no_hp)
    EditText inputNoHP;
    @BindView(R.id.input_no_wa)
    EditText inputNoWA;
    @BindView(R.id.input_email)
    EditText inputEmail;
    @BindView(R.id.input_gadis_ibu_kandung)
    EditText inputGadisIbuKandung;
    @BindView(R.id.spinner_pendidikan)
    Spinner spinnerPendidikan;
    @BindView(R.id.spinner_status_perkawinan)
    Spinner spinnerStatusPerkawinan;
    @BindView(R.id.spinner_tanggungan)
    Spinner spinnerTanggungan;
    @BindView(R.id.input_nama_pasangan)
    EditText inputNamaPasangan;
    @BindView(R.id.spinner_pekerjaan_pasangan)
    Spinner spinnerPekerjaanPasangan;
    @BindView(R.id.input_nama_penjamin)
    EditText inputNamaPenjamin;
    @BindView(R.id.input_jenis_identitas)
    EditText inputJenisIdentitas;
    @BindView(R.id.input_no_identitas)
    EditText inputNoIdentitas;
    @BindView(R.id.spinner_hubungan_penjaminPemohon)
    Spinner spinnerHubunganPenjaminPemohon;
    @BindView(R.id.input_telp_1)
    EditText inputTelp1;
    @BindView(R.id.input_telp_2)
    EditText inputTelp2;
    @BindView(R.id.input_no_hp_1)
    EditText inputNoHp1;
    @BindView(R.id.input_no_hp_2)
    EditText InputNoHp2;
    @BindView(R.id.input_no_hp_penjamin)
    EditText inputNoHPPenjamin;
    @BindView(R.id.input_email_pic_perusahaan)
    EditText inputEmailPicPerusahaan;
    @BindView(R.id.input_pic_perusahaan)
    EditText inputPicPerusahaan;
    @BindView(R.id.spinner_pekerjaan_penjamin)
    Spinner spinnerPekerjaanPenjamin;
    @BindView(R.id.btn_save)
    Button btnSave;
    @BindView(R.id.btn_next)
    Button btnNext;
    private ArrayAdapter<String> adapterTipeKonsumen;
    private ArrayAdapter<String> adapterPekerjaan;
    private ArrayAdapter<String> adapterStatusPerkawinan;
    private ArrayAdapter<String> adapterNullForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_klarifikasi_konsumen);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Klarifikasi Konsumen");

        adapterTipeKonsumen = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item) {
            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View v = super.getDropDownView(position, convertView, parent);
                return v;
            }
        };
        adapterTipeKonsumen.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterTipeKonsumen.add("Perorangan");
        spinnerTipeKonsumen.setAdapter(adapterTipeKonsumen);

        adapterPekerjaan = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item) {
            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View v = super.getDropDownView(position, convertView, parent);
                return v;
            }
        };
        adapterPekerjaan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterPekerjaan.add("Wirausaha");
        spinnerPekerjaan.setAdapter(adapterPekerjaan);

        adapterStatusPerkawinan = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item) {
            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View v = super.getDropDownView(position, convertView, parent);
                return v;
            }
        };
        adapterStatusPerkawinan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterStatusPerkawinan.add("Kawin");
        spinnerStatusPerkawinan.setAdapter(adapterStatusPerkawinan);

        adapterNullForm = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item) {
            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View v = super.getDropDownView(position, convertView, parent);
                return v;
            }
        };
        adapterNullForm.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterNullForm.add("---");
        spinnerTanggalLahir.setAdapter(adapterNullForm);
        spinnerProvinsi.setAdapter(adapterNullForm);
        spinnerKecamatan.setAdapter(adapterNullForm);
        spinnerKelurahan.setAdapter(adapterNullForm);
        spinnerPendidikan.setAdapter(adapterNullForm);
        spinnerPekerjaanPasangan.setAdapter(adapterNullForm);
        spinnerHubunganPenjaminPemohon.setAdapter(adapterNullForm);
        spinnerPekerjaanPenjamin.setAdapter(adapterNullForm);

        initViewVisibleForm();
    }

    private void initViewVisibleForm() {
        String kategory = getIntent().getStringExtra("CATEGORY");
        tvKategori.setText(kategory);

        if (kategory.equals("Electronic")) {
            viewPekerjaan.setVisibility(View.GONE);
            viewTipePeronganLembaga.setVisibility(View.VISIBLE);
        } else if (kategory.equals("Micro")) {
            viewTipeAgent.setVisibility(View.GONE);
            viewSifatUsaha.setVisibility(View.VISIBLE);
        } else if (kategory.equals("Lembaga")) {
            viewTipeAgent.setVisibility(View.GONE);
            viewSifatUsaha.setVisibility(View.GONE);
            viewJenisBadanUsaha.setVisibility(View.VISIBLE);
            viewNamaPerusahaan.setVisibility(View.VISIBLE);
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
            R.id.btn_save,
            R.id.btn_next
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_save:

                break;
            case R.id.btn_next:
                String varDokumen = tvKategori.getText().toString();

                Intent intentDokumen = new Intent(getApplicationContext(), DokumenKonsumen.class);
                intentDokumen.putExtra("CATEGORY", varDokumen);
                startActivity(intentDokumen);
                break;
        }
    }
}




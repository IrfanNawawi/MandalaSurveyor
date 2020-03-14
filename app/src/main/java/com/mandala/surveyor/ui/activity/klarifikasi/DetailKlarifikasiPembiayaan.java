package com.mandala.surveyor.ui.activity.klarifikasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mandala.surveyor.R;
import com.mandala.surveyor.ui.activity.dokumen.DokumenTempatTinggal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailKlarifikasiPembiayaan extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    //Get Value
    @BindView(R.id.tv_kategori)
    TextView tvKategori;
    @BindView(R.id.tv_type)
    TextView tvType;

    @BindView(R.id.btn_alamat_tagih)
    Button btnAlamatTagih;

    //View Visible
    @BindView(R.id.view_tujuan_penggunaan)
    LinearLayout viewTujuanPengajuan;
    @BindView(R.id.view_jenis_kendaraan)
    LinearLayout viewJenisKendaraan;
    @BindView(R.id.view_nama_supplier)
    LinearLayout viewNamaSupplier;
    @BindView(R.id.view_biaya_kategori_objek)
    LinearLayout viewBiayaKategoriObjek;
    @BindView(R.id.view_tahun)
    LinearLayout viewTahun;
    @BindView(R.id.view_pembiayaan_micro)
    LinearLayout viewPembiayaanMicro;
    @BindView(R.id.view_harga_unit)
    LinearLayout viewHargaUnit;
    @BindView(R.id.view_pembiayaan_micro_2)
    LinearLayout viewPembiayaanMicro2;
    @BindView(R.id.view_tanggal_tempo)
    LinearLayout viewTanggalTempo;
    @BindView(R.id.view_jenis_angsuran)
    LinearLayout viewJenisAngsuran;


    //Option Form
    @BindView(R.id.btn_next)
    Button btnNext;
    @BindView(R.id.btn_save)
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_klarifikasi_pembiayaan);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initViewVisibleForm();
    }

    private void initViewVisibleForm() {
        String kategory = getIntent().getStringExtra("CATEGORY");
        String type = getIntent().getStringExtra("TYPE");
        tvKategori.setText(kategory);
        tvType.setText(type);

        if (kategory.equals("Otomotive")) {
            getSupportActionBar().setTitle("Klarifikasi Pembiayaan Otomotif");
        } else if (kategory.equals("Electronic")) {
            getSupportActionBar().setTitle("Klarifikasi Pembiayaan MEC");
        } else if (kategory.equals("Micro")) {
            getSupportActionBar().setTitle("Klarifikasi Pembiayaan Micro");
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
            R.id.btn_next,
            R.id.btn_alamat_tagih
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_next:
                String varKategori = tvKategori.getText().toString();
                String varType = tvType.getText().toString();

                Intent intentVar = new Intent(getApplicationContext(), DokumenTempatTinggal.class);
                intentVar.putExtra("CATEGORY", varKategori);
                intentVar.putExtra("TYPE", varType);
                startActivity(intentVar);
                break;
            case R.id.btn_save:

                break;
            case R.id.btn_alamat_tagih:
                initDialogAddress();
                break;
        }
    }

    private void initDialogAddress() {
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        View alertLayout = LayoutInflater.from(this).inflate(R.layout.dialog_address, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setView(alertLayout);
        alert.setCancelable(true);

        final AlertDialog dialog = alert.create();
        dialog.show();

        final TextView tvLihat = alertLayout.findViewById(R.id.tv_lihat_alamat);
        final TextView tvUbah = alertLayout.findViewById(R.id.tv_ubah_alamat);
        final TextView tvHapus = alertLayout.findViewById(R.id.tv_hapus_alamat);

        tvLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        tvUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        tvHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}

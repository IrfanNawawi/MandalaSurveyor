package com.mandala.surveyor.ui.activity.dokumen;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mandala.surveyor.R;
import com.mandala.surveyor.utils.PermissionUtil;

import java.io.File;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.mandala.surveyor.utils.PermissionUtil.REQUEST_CODE_TAKE_PICTURE;
import static com.mandala.surveyor.utils.PermissionUtil.REQUEST_MAIN;

public class DokumenKonsumen extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    //Get Value
    @BindView(R.id.tv_kategori)
    TextView tvKategori;
    //View Visible
    @BindView(R.id.view_foto_npwp)
    LinearLayout viewFotoNpwp;
    @BindView(R.id.view_foto_tabungan)
    LinearLayout viewFotoTabungan;
    //Foto KTP Pemohon
    @BindView(R.id.btn_ktp_pemohon)
    RelativeLayout btnKtpPemohon;
    @BindView(R.id.img_ktp_pemohon)
    ImageView imgKtpPemohon;
    @BindView(R.id.place_ktp_pemohon)
    LinearLayout placeKtpPemohon;
    //Foto KTP Pasangan
    @BindView(R.id.btn_ktp_pasangan)
    RelativeLayout btnKtpPasangan;
    @BindView(R.id.img_ktp_pasangan)
    ImageView imgKtpPasangan;
    @BindView(R.id.place_ktp_pasangan)
    LinearLayout placeKtpPasangan;
    //Foto KK
    @BindView(R.id.btn_kk)
    RelativeLayout btnKK;
    @BindView(R.id.img_kk)
    ImageView imgKK;
    @BindView(R.id.place_kk)
    LinearLayout placeKK;
    //Foto Surat Optional
    @BindView(R.id.btn_surat_optional)
    RelativeLayout btnSuratOptional;
    @BindView(R.id.img_surat_optional)
    ImageView imgSuratOptional;
    @BindView(R.id.place_surat_optional)
    LinearLayout placeSuratOptional;
    //Foto NPWP
    @BindView(R.id.btn_npwp)
    RelativeLayout btnNpwp;
    @BindView(R.id.img_npwp)
    ImageView imgNpwp;
    @BindView(R.id.place_npwp)
    LinearLayout placeNpwp;
    //Foto NPWP
    @BindView(R.id.btn_tabungan)
    RelativeLayout btnTabungan;
    @BindView(R.id.img_tabungan)
    ImageView imgTabungan;
    @BindView(R.id.place_tabungan)
    LinearLayout placeTabungan;
    //Option Form
    @BindView(R.id.btn_save)
    Button btnSave;
    @BindView(R.id.btn_next)
    Button btnNext;
    private File tempFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_dokumen_konsumen);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Foto Dokumen");
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        checkingPermissions();
        initViewVisibleForm();
    }

    private void initViewVisibleForm() {
        String kategory = getIntent().getStringExtra("CATEGORY");
        tvKategori.setText(kategory);

        if (kategory.equals("Electronic")) {
            viewFotoNpwp.setVisibility(View.GONE);
        } else if (kategory.equals("Micro")) {
            viewFotoNpwp.setVisibility(View.GONE);
            viewFotoTabungan.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_MAIN:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    checkingPermissions();
                }
                break;
        }
    }

    private void checkingPermissions() {
        if (PermissionUtil.isGranted(this, Manifest.permission.CAMERA,
                new String[]{Manifest.permission.CAMERA},
                REQUEST_MAIN,
                "Akses kamera diperlukan untuk melanjutkan proses")) {
        }
    }

    private void openCamera() {
        int randomName = (int) (Math.random() * 9000) + 1000;

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        tempFile = new File(this.getExternalCacheDir() + File.separator + randomName + "-collection.jpg" + File.separator);
        Uri uri = Uri.fromFile(tempFile);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(cameraIntent, REQUEST_CODE_TAKE_PICTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode != RESULT_OK) {

            return;
        }

        if (requestCode == REQUEST_CODE_TAKE_PICTURE) {

            Glide.with(this)
                    .load(tempFile)
                    .thumbnail(0.5f)
                    .into(imgKtpPemohon);

            imgKtpPemohon.setVisibility(View.VISIBLE);
            placeKtpPemohon.setVisibility(View.GONE);
        }
        super.onActivityResult(requestCode, resultCode, data);
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
            R.id.btn_ktp_pemohon,
            R.id.btn_ktp_pasangan,
            R.id.btn_kk,
            R.id.btn_surat_optional,
            R.id.btn_npwp,
            R.id.btn_save,
            R.id.btn_next
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_ktp_pemohon:
                openCamera();
                break;
            case R.id.btn_ktp_pasangan:
                openCamera();
                break;
            case R.id.btn_kk:
                openCamera();
                break;
            case R.id.btn_surat_optional:
                openCamera();
                break;
            case R.id.btn_npwp:
                openCamera();
                break;
            case R.id.btn_save:

                break;
            case R.id.btn_next:
                startActivity(new Intent(getApplicationContext(), DokumenLainnya.class));

                break;
        }
    }
}

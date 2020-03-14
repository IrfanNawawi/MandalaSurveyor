package com.mandala.surveyor.ui.activity.dokumen;

import android.content.Intent;
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

public class DokumenTempatTinggal extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    //Get Value
    @BindView(R.id.tv_kategori)
    TextView tvKategori;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.tv_portfolio_tempat_tinggal)
    TextView tvPortfolioTempatTinggal;
    //Foto Listrik PBB
    @BindView(R.id.btn_listrik_pbb)
    RelativeLayout btnListrikPbb;
    @BindView(R.id.img_listrik_pbb)
    ImageView imgListrikPbb;
    @BindView(R.id.place_listrik_pbb)
    LinearLayout placeListrikPbb;
    //Foto Listrik PBB Mobil
    @BindView(R.id.btn_listrik_pbb_mobil)
    RelativeLayout btnListrikPbbMobil;
    @BindView(R.id.img_listrik_pbb_mobil)
    ImageView imgListrikPbbMobil;
    @BindView(R.id.place_listrik_pbb_mobil)
    LinearLayout placeListrikPbbMobil;
    //Foto Tempat Tinggal
    @BindView(R.id.btn_tempat_tinggal)
    RelativeLayout btnTempatTinggal;
    @BindView(R.id.img_tempat_tinggal)
    ImageView imgTempatTinggal;
    @BindView(R.id.place_tempat_tinggal)
    LinearLayout placeTempatTinggal;
    //Option Form
    @BindView(R.id.btn_save)
    Button btnSave;
    @BindView(R.id.btn_next)
    Button btnNext;
    private File tempFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_dokumen_tempat_tinggal);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Foto Dokumen");

        initViewVisibleForm();
    }

    private void initViewVisibleForm() {
        String kategory = getIntent().getStringExtra("CATEGORY");
        String type = getIntent().getStringExtra("TYPE");

        tvType.setText(type);
        tvKategori.setText(kategory);

        if (kategory.equals("Otomotive") && type.equals("Motor")) {
            tvPortfolioTempatTinggal.setText("Portfolio Otomotif (Motor)");
        } else if (kategory.equals("Otomotive") && type.equals("Mobil")) {
            tvPortfolioTempatTinggal.setText("Portfolio Otomotif (Mobil)");
        } else if (kategory.equals("Electronic")) {
            tvPortfolioTempatTinggal.setText("Portfolio MEc (Electronic & Furniture)");
        } else if (kategory.equals("Micro")) {
            tvPortfolioTempatTinggal.setVisibility(View.GONE);
        }

    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        switch (requestCode) {
//            case PERMISSION_MAIN:
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    openCamera();
//                } else {
//                    checkingPermissions();
//                }
//                break;
//        }
//    }
//
//    private void checkingPermissions() {
//        if (PermissionUtil.isGranted(this, Manifest.permission.CAMERA,
//                new String[]{Manifest.permission.CAMERA},
//                PERMISSION_MAIN,
//                "Akses kamera diperlukan untuk melanjutkan proses")) {
//            openCamera();
//        }
//    }
//
//    private void openCamera() {
//        int randomName = (int) (Math.random() * 9000) + 1000;
//
//        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        tempFile = new File(this.getExternalCacheDir() + File.separator + randomName + "-collection.jpg" + File.separator);
//        Uri uri = Uri.fromFile(tempFile);
//        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
//        startActivityForResult(cameraIntent, REQUEST_CODE_TAKE_PICTURE);
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//        if (resultCode != RESULT_OK) {
//
//            return;
//        }
//
//        if (requestCode == REQUEST_CODE_TAKE_PICTURE) {
//
//            Glide.with(this)
//                    .load(tempFile)
//                    .thumbnail(0.5f)
//                    .into(imgKtpPemohon);
//
//            imgKtpPemohon.setVisibility(View.VISIBLE);
//            placKtpPemohon.setVisibility(View.GONE);
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }

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

                Intent intentVar = new Intent(getApplicationContext(), DokumenAgunan.class);
                intentVar.putExtra("CATEGORY", varKategori);
                intentVar.putExtra("TYPE", varType);
                startActivity(intentVar);
                break;
        }
    }
}

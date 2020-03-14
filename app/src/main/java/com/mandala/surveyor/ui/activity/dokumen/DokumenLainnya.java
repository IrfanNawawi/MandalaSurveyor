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

import com.bumptech.glide.Glide;
import com.mandala.surveyor.R;
import com.mandala.surveyor.ui.activity.klarifikasi.DetailKlarifikasiCekLingkungan;
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

public class DokumenLainnya extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    //Foto Konsumen
    @BindView(R.id.btn_foto_konsumen)
    RelativeLayout btnFotoKonsumen;
    @BindView(R.id.img_foto_konsumen)
    ImageView imgFotoKonsumen;
    @BindView(R.id.place_foto_konsumen)
    LinearLayout placeFotoKonsumen;
    //Foto Lainnya
    @BindView(R.id.btn_foto_lain)
    RelativeLayout btnFotoLain;
    @BindView(R.id.img_foto_lain)
    ImageView imgFotoLain;
    @BindView(R.id.place_foto_lain)
    LinearLayout placeFotoLain;
    //Option Form
    @BindView(R.id.btn_save)
    Button btnSave;
    private File tempFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_dokumen_lainnya);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Foto Dokumen");
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        checkingPermissions();
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
                    .into(imgFotoKonsumen);

            imgFotoKonsumen.setVisibility(View.VISIBLE);
            placeFotoKonsumen.setVisibility(View.GONE);
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
            R.id.btn_foto_konsumen,
            R.id.btn_save,
            R.id.btn_next
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_foto_konsumen:
                openCamera();
                break;
            case R.id.btn_save:

                break;
            case R.id.btn_next:
                startActivity(new Intent(getApplicationContext(), DetailKlarifikasiCekLingkungan.class));
                break;
        }
    }
}

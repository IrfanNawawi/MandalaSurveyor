package com.mandala.surveyor.ui.activity.setting;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.mandala.surveyor.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.img_password)
    ImageView imgPassword;
    @BindView(R.id.arrow_password)
    ImageView arrowPassword;
    @BindView(R.id.btn_password)
    RelativeLayout btnPassword;
    @BindView(R.id.img_gps)
    ImageView imgGps;
    @BindView(R.id.arrow_gps)
    ImageView arrowGps;
    @BindView(R.id.btn_gps)
    RelativeLayout btnGps;
    @BindView(R.id.img_permission)
    ImageView imgPermission;
    @BindView(R.id.arrow_permission)
    ImageView arrowPermission;
    @BindView(R.id.btn_permission)
    RelativeLayout btnPermission;
    @BindView(R.id.img_panduan)
    ImageView imgPanduan;
    @BindView(R.id.arrow_panduan)
    ImageView arrowPanduan;
    @BindView(R.id.btn_panduan)
    RelativeLayout btnPanduan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Setting");
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

    @OnClick({R.id.btn_password, R.id.btn_gps, R.id.btn_permission, R.id.btn_panduan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_password:
                startActivity(new Intent(getApplicationContext(), Password.class));

                break;
            case R.id.btn_gps:
                break;
            case R.id.btn_permission:
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", getPackageName(), null);
                intent.setData(uri);
                startActivity(intent);

                break;
            case R.id.btn_panduan:
                break;
        }
    }
}

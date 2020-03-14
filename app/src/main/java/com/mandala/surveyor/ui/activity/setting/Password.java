package com.mandala.surveyor.ui.activity.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;
import com.mandala.surveyor.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Password extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.input_username)
    EditText inputUsername;
    @BindView(R.id.input_layout_username)
    TextInputLayout inputLayoutUsername;
    @BindView(R.id.input_old_password)
    EditText inputOldPassword;
    @BindView(R.id.input_layout_old_password)
    TextInputLayout inputLayoutOldPassword;
    @BindView(R.id.input_new_password)
    EditText inputNewPassword;
    @BindView(R.id.input_layout_new_password)
    TextInputLayout inputLayoutNewPassword;
    @BindView(R.id.input_confirm_password)
    EditText inputConfirmPassword;
    @BindView(R.id.input_layout_confirm_password)
    TextInputLayout inputLayoutConfirmPassword;
    @BindView(R.id.check_agree)
    CheckBox checkAgree;
    @BindView(R.id.btn_simpan)
    Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_password);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Perubahan Password");
    }

    @OnClick({R.id.check_agree, R.id.btn_simpan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.check_agree:
                break;
            case R.id.btn_simpan:
                break;
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
}

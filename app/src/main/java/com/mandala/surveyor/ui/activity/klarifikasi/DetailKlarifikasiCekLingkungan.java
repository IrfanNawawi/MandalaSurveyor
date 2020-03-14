package com.mandala.surveyor.ui.activity.klarifikasi;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.mandala.surveyor.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailKlarifikasiCekLingkungan extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.input_name)
    EditText inputName;
    @BindView(R.id.spinner_hubungan_pemohon)
    Spinner spinnerHubunganPemohon;
    @BindView(R.id.input_catatan)
    EditText inputCatatan;
    @BindView(R.id.input_name_2)
    EditText inputName2;
    @BindView(R.id.spinner_asal_usul)
    Spinner spinnerAsalUsul;
    @BindView(R.id.spinner_kemasyarakatan)
    Spinner spinnerKemasyarakatan;
    @BindView(R.id.spinner_karakter_konsumen)
    Spinner spinnerKarakterKonsumen;
    @BindView(R.id.btn_save)
    Button btnSave;
    private ArrayAdapter<String> adapterNullForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_cek_lingkungan);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Cek Lingkungan");

        adapterNullForm = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item) {
            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View v = super.getDropDownView(position, convertView, parent);
                return v;
            }
        };
        adapterNullForm.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterNullForm.add("---");
        spinnerHubunganPemohon.setAdapter(adapterNullForm);
        spinnerAsalUsul.setAdapter(adapterNullForm);
        spinnerKemasyarakatan.setAdapter(adapterNullForm);
        spinnerKarakterKonsumen.setAdapter(adapterNullForm);
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

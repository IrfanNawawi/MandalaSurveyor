package com.mandala.surveyor.ui.activity.penugasan;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
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
import com.mandala.surveyor.ui.activity.klarifikasi.DetailKlarifikasiKonsumen;
import com.mandala.surveyor.ui.activity.klarifikasi.DetailKlarifikasiPekerjaan;
import com.mandala.surveyor.ui.activity.klarifikasi.DetailKlarifikasiPembiayaan;
import com.mandala.surveyor.ui.activity.klarifikasi.DetailKlarifikasiTempatTinggal;
import com.mandala.surveyor.ui.activity.klarifikasi.DetailTaksasi;
import com.mandala.surveyor.ui.activity.signature.SignatureActivity;
import com.mandala.surveyor.utils.custom.GPSTracker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailPenugasan2 extends AppCompatActivity {

    GPSTracker gpsTracker;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_no_aplikasi)
    TextView tvNoAplikasi;
    @BindView(R.id.tv_nama)
    TextView tvNama;
    @BindView(R.id.tv_kategori)
    TextView tvKategori;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.view_get_address)
    LinearLayout viewGetAddress;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.view_empty_address)
    LinearLayout viewEmptyAddress;
    @BindView(R.id.view_type_address)
    LinearLayout viewTypeAddress;
    @BindView(R.id.spinner_alamat)
    Spinner spinnerAlamat;
    @BindView(R.id.view_proses)
    LinearLayout viewProses;
    @BindView(R.id.view_proses_survey)
    LinearLayout viewProsesSurvey;
    @BindView(R.id.btn_tagging)
    LinearLayout btnTagging;
    @BindView(R.id.tv_tagging)
    TextView tvTagging;
    @BindView(R.id.view_survey)
    LinearLayout btnSurvey;
    @BindView(R.id.view_form_konsumen)
    LinearLayout btnFormKonsumen;
    @BindView(R.id.tv_konsumen)
    TextView tvKonsumen;
    @BindView(R.id.view_form_tempat_tinggal)
    LinearLayout btnFormTempatTinggal;
    @BindView(R.id.view_form_penghasilan)
    LinearLayout btnFormPenghasilan;
    @BindView(R.id.view_form_unit)
    LinearLayout btnFormUnit;
    @BindView(R.id.view_taksasi)
    LinearLayout btnTaksasi;
    @BindView(R.id.btn_ttd_konsumen)
    LinearLayout btnTtdKonsumen;
    @BindView(R.id.btn_ttd_penjamin)
    LinearLayout btnTtdPenjamin;
    @BindView(R.id.btn_batal)
    Button btnBatal;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    private ArrayAdapter<String> adapterAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_penugasan_2);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Penugasan");

        adapterAlamat = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item) {

            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View v = super.getDropDownView(position, convertView, parent);

                return v;
            }
        };
        adapterAlamat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterAlamat.add("---");
        spinnerAlamat.setAdapter(adapterAlamat);

        initDetailSurvey();
    }

    private void initDetailSurvey() {
        String kode = getIntent().getStringExtra("NO_APLIKASI");
        String name = getIntent().getStringExtra("NAMA");
        String kategory = getIntent().getStringExtra("KATEGORI");
        String type = getIntent().getStringExtra("TYPE");

        tvNoAplikasi.setText(kode);
        tvNama.setText(name);
        tvKategori.setText(kategory);
        tvType.setText(type);

        if (kategory.equals("Otomotive")) {
            btnTaksasi.setVisibility(View.VISIBLE);
        }
    }

    public void initDialogSurveyBatal() {
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        View alertLayout = LayoutInflater.from(this).inflate(R.layout.dialog_survey_batal, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setView(alertLayout);
        alert.setCancelable(true);

        final AlertDialog dialog = alert.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        final ArrayAdapter<String> adapterStatus, adapterAlasan;
        final Spinner spinnerStatus = alertLayout.findViewById(R.id.spinnerStatus);
        final Spinner spinnerAlasan = alertLayout.findViewById(R.id.spinnerAlasan);
        final Button btnCancel = alertLayout.findViewById(R.id.btn_batal);
        final Button btnOk = alertLayout.findViewById(R.id.btn_ok);

        adapterStatus = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item) {

            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View v = super.getDropDownView(position, convertView, parent);

                return v;
            }
        };
        adapterStatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterStatus.add("Belum");
        spinnerStatus.setAdapter(adapterStatus);

        adapterAlasan = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item) {

            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View v = super.getDropDownView(position, convertView, parent);

                return v;
            }
        };
        adapterAlasan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterAlasan.add("Rumah Kosong");
        spinnerAlasan.setAdapter(adapterAlasan);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                finish();
            }
        });
    }

    public void initDialogSurveySubmit() {
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        View alertLayout = LayoutInflater.from(this).inflate(R.layout.dialog_survey_submit, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setView(alertLayout);
        alert.setCancelable(true);

        final AlertDialog dialog = alert.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        final ArrayAdapter<String> adapterStatus;
        final Spinner spinnerStatus = alertLayout.findViewById(R.id.spinnerStatus);
        final EditText inputCatatan = alertLayout.findViewById(R.id.input_catatan);
        final EditText inputCharacter = alertLayout.findViewById(R.id.input_character);
        final EditText inputCapacity = alertLayout.findViewById(R.id.input_capacity);
        final EditText inputCapital = alertLayout.findViewById(R.id.input_capital);
        final EditText inputCondition = alertLayout.findViewById(R.id.input_condition);
        final EditText inputCollateral = alertLayout.findViewById(R.id.input_collateral);
        final Button btnCancel = alertLayout.findViewById(R.id.btn_batal);
        final Button btnOk = alertLayout.findViewById(R.id.btn_ok);

        adapterStatus = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item) {

            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View v = super.getDropDownView(position, convertView, parent);

                return v;
            }
        };
        adapterStatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterStatus.add("Sudah");
        spinnerStatus.setAdapter(adapterStatus);


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                finish();
            }
        });
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
            R.id.btn_tagging,
            R.id.btn_ttd_konsumen,
            R.id.btn_ttd_penjamin,
            R.id.btn_batal,
            R.id.btn_submit,
            R.id.view_form_konsumen,
            R.id.view_form_tempat_tinggal,
            R.id.view_form_penghasilan,
            R.id.view_form_unit,
            R.id.view_taksasi
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btn_tagging:
                gpsTracker = new GPSTracker(this, this);
                if (gpsTracker.canGetLocation()) {
                    gpsTracker.latitude = gpsTracker.getLatitude();
                    gpsTracker.longitude = gpsTracker.getLongitude();
                    gpsTracker.isGPSEnabled();
                    gpsTracker.isNetworkEnabled();

                    if (gpsTracker.latitude != 0 && gpsTracker.longitude != 0 && GPSTracker.mCurrentAddress != null) {
                        viewEmptyAddress.setVisibility(View.GONE);
                        viewTypeAddress.setVisibility(View.GONE);
                        btnSurvey.setVisibility(View.GONE);
                        btnTagging.setVisibility(View.VISIBLE);
                        viewGetAddress.setVisibility(View.VISIBLE);
                        btnFormKonsumen.setVisibility(View.VISIBLE);
                        btnFormTempatTinggal.setVisibility(View.VISIBLE);
                        btnFormPenghasilan.setVisibility(View.VISIBLE);
                        btnFormUnit.setVisibility(View.VISIBLE);
                        viewProses.setVisibility(View.GONE);
                        viewProsesSurvey.setVisibility(View.VISIBLE);
                        tvAddress.setText(GPSTracker.mCurrentAddress);
                    } else {
                        gpsTracker.showSettingsAlert();
                    }
                } else {
                    gpsTracker.showSettingsAlert();
                }
                break;
            case R.id.btn_ttd_konsumen:
                startActivity(new Intent(getApplicationContext(), SignatureActivity.class));
                break;
            case R.id.btn_ttd_penjamin:
                startActivity(new Intent(getApplicationContext(), SignatureActivity.class));
                break;
            case R.id.btn_batal:
                initDialogSurveyBatal();

                break;
            case R.id.btn_submit:
                initDialogSurveySubmit();

                break;
            case R.id.view_form_konsumen:
                String varKonsumen = tvKategori.getText().toString();
                String varTypeKonsumen = tvType.getText().toString();

                Intent intentKonsumen = new Intent(getApplicationContext(), DetailKlarifikasiKonsumen.class);
                intentKonsumen.putExtra("CATEGORY", varKonsumen);
                intentKonsumen.putExtra("TYPE", varTypeKonsumen);
                startActivity(intentKonsumen);
                break;
            case R.id.view_form_tempat_tinggal:
                String varTempatTinggal = tvKategori.getText().toString();
                String varTypeTempatTinggal = tvType.getText().toString();

                Intent intentTinggal = new Intent(getApplicationContext(), DetailKlarifikasiTempatTinggal.class);
                intentTinggal.putExtra("CATEGORY", varTempatTinggal);
                intentTinggal.putExtra("TYPE", varTypeTempatTinggal);
                startActivity(intentTinggal);
                break;
            case R.id.view_form_penghasilan:
                String varPenghasilan = tvKategori.getText().toString();
                String varTypePenghasilan = tvType.getText().toString();

                Intent intentPenghasilan = new Intent(getApplicationContext(), DetailKlarifikasiPekerjaan.class);
                intentPenghasilan.putExtra("CATEGORY", varPenghasilan);
                intentPenghasilan.putExtra("TYPE", varTypePenghasilan);
                startActivity(intentPenghasilan);
                break;
            case R.id.view_form_unit:
                String varUnit = tvKategori.getText().toString();
                String varTypeUnit = tvType.getText().toString();

                Intent intentUnit = new Intent(getApplicationContext(), DetailKlarifikasiPembiayaan.class);
                intentUnit.putExtra("CATEGORY", varUnit);
                intentUnit.putExtra("TYPE", varTypeUnit);
                startActivity(intentUnit);
                break;
            case R.id.view_taksasi:
                String varTaksasi = tvKategori.getText().toString();
                String varTypeTaksasi = tvType.getText().toString();

                Intent intentTaksasi = new Intent(getApplicationContext(), DetailTaksasi.class);
                intentTaksasi.putExtra("CATEGORY", varTaksasi);
                intentTaksasi.putExtra("TYPE", varTypeTaksasi);
                startActivity(intentTaksasi);
                break;
        }
    }
}

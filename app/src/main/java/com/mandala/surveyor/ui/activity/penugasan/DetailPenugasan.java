package com.mandala.surveyor.ui.activity.penugasan;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mandala.surveyor.R;
import com.mandala.surveyor.data.db.models.SurveyData;
import com.mandala.surveyor.utils.custom.ProportionalImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailPenugasan extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.header)
    AppBarLayout appBarLayout;
    @BindView(R.id.btn_call)
    FloatingActionButton btnCall;
    @BindView(R.id.btn_profile)
    FloatingActionButton btnProfile;
    @BindView(R.id.btn_message)
    FloatingActionButton btnMessage;
    @BindView(R.id.tv_address)
    TextView alamat;
    @BindView(R.id.img_location)
    ProportionalImageView imgLocation;
    @BindView(R.id.tv_navigation)
    TextView text;
    @BindView(R.id.btn_navigation)
    RelativeLayout btnNavigasi;
    @BindView(R.id.tv_name_konsumen)
    TextView namaKonsumen;
    @BindView(R.id.tv_no_booking)
    TextView noBooking;
    @BindView(R.id.tv_kelurahan)
    TextView kelurahan;
    @BindView(R.id.tv_kecamatan)
    TextView kecamatan;
    @BindView(R.id.tv_kota)
    TextView kota;
    @BindView(R.id.tv_provinsi)
    TextView provinsi;
    @BindView(R.id.tv_no_hp)
    TextView noHp;
    @BindView(R.id.tv_no_whatsapp)
    TextView noWhatsapp;
    @BindView(R.id.tv_type_product)
    TextView kategoriProduk;
    @BindView(R.id.tv_sub_produk)
    TextView subProduk;
    @BindView(R.id.tv_jenis_produk)
    TextView jenisProduk;
    @BindView(R.id.tv_merk)
    TextView merk;
    @BindView(R.id.tv_type)
    TextView type;
    @BindView(R.id.tv_model)
    TextView model;
    @BindView(R.id.body)
    NestedScrollView body;
    @BindView(R.id.btn_next)
    FloatingActionButton btnNext;
    @BindView(R.id.main_content)
    CoordinatorLayout mainContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_penugasan);
        ButterKnife.bind(this);

        initCollapsingToolbar();
    }

    private void initCollapsingToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Penugasan");

        collapsingToolbar.setTitleEnabled(false);
        collapsingToolbar.setTitle(" ");
        appBarLayout.setExpanded(true);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle("");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle("");
                    isShow = false;
                }
            }
        });

        body.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > oldScrollY) {
                    btnCall.hide();
                    btnProfile.hide();
                    btnMessage.hide();
                } else {
                    btnCall.show();
                    btnProfile.show();
                    btnMessage.show();
                }
            }
        });

        initDetailSurvey();
    }

    private void initDetailSurvey() {
        SurveyData surveyItem = getIntent().getParcelableExtra("SURVEYLIST");

        alamat.setText(surveyItem.getAlamat());
        namaKonsumen.setText(surveyItem.getNama());
        noBooking.setText(surveyItem.getAplikasi());
        kelurahan.setText(surveyItem.getKelurahan());
        kecamatan.setText(surveyItem.getKecamatan());
        kota.setText(surveyItem.getKota());
        provinsi.setText(surveyItem.getProvinsi());
        noHp.setText(surveyItem.getNoHp());
        noWhatsapp.setText(surveyItem.getNoWA());
        kategoriProduk.setText(surveyItem.getKategori());
        subProduk.setText(surveyItem.getSubProduk());
        jenisProduk.setText(surveyItem.getJenisProduk());
        merk.setText(surveyItem.getMerk());
        type.setText(surveyItem.getType());
        model.setText(surveyItem.getModel());
    }

    public void onBackPressed() {
        finish();
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

    @OnClick({R.id.btn_call, R.id.btn_profile, R.id.btn_message, R.id.btn_navigation, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_call:
                break;
            case R.id.btn_profile:
                break;
            case R.id.btn_message:
                break;
            case R.id.btn_navigation:
                break;
            case R.id.btn_next:
                String noAplikasi = noBooking.getText().toString().trim();
                String nama = namaKonsumen.getText().toString().trim();
                String kategori = kategoriProduk.getText().toString();
                String typeKategori = type.getText().toString();

                Intent varPenugasan = new Intent(getApplicationContext(), DetailPenugasan2.class);
                varPenugasan.putExtra("NO_APLIKASI", noAplikasi);
                varPenugasan.putExtra("NAMA", nama);
                varPenugasan.putExtra("KATEGORI", kategori);
                varPenugasan.putExtra("TYPE", typeKategori);
                startActivity(varPenugasan);

                break;
        }
    }

}

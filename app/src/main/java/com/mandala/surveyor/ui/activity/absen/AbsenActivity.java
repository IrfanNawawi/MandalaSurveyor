package com.mandala.surveyor.ui.activity.absen;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mandala.surveyor.R;
import com.mandala.surveyor.ui.fragment.absen.AbsenMobile;
import com.mandala.surveyor.ui.fragment.absen.AbsenOffice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AbsenActivity extends AppCompatActivity implements AbsenView {

    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction transaction;

    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.user_photo)
    ImageView userPhoto;
    @BindView(R.id.user_status)
    TextView userStatus;
    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.user_nik)
    TextView userNik;
    @BindView(R.id.user_level)
    TextView userLevel;
    @BindView(R.id.user_date)
    TextView userDate;
    @BindView(R.id.nav_profile)
    LinearLayout navProfile;
    @BindView(R.id.img_mobile)
    ImageView imgMobile;
    @BindView(R.id.title_mobile)
    TextView titleMobile;
    @BindView(R.id.tab_mobile)
    LinearLayout tabMobile;
    @BindView(R.id.img_office)
    ImageView imgOffice;
    @BindView(R.id.title_office)
    TextView titleOffice;
    @BindView(R.id.tab_office)
    LinearLayout tabOffice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absen);
        ButterKnife.bind(this);

        initTabMobile();
    }

    @Override
    public void initTabMobile() {
        tabMobile.setBackground(this.getResources().getDrawable(R.drawable.bg_oval_grey));
        imgMobile.setColorFilter(ContextCompat.getColor(this, R.color.activeMenu));
        titleMobile.setTextColor(this.getResources().getColor(R.color.activeMenu));

        tabOffice.setBackground(null);
        imgOffice.setColorFilter(ContextCompat.getColor(this, R.color.deactiveMenu));
        titleOffice.setTextColor(this.getResources().getColor(R.color.deactiveMenu));

        AbsenMobile absenMobile = new AbsenMobile();
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, absenMobile);
        transaction.commit();
    }

    @Override
    public void initTabOffice() {
        tabMobile.setBackground(null);
        imgMobile.setColorFilter(ContextCompat.getColor(this, R.color.deactiveMenu));
        titleMobile.setTextColor(this.getResources().getColor(R.color.deactiveMenu));

        tabOffice.setBackground(this.getResources().getDrawable(R.drawable.bg_oval_grey));
        imgOffice.setColorFilter(ContextCompat.getColor(this, R.color.activeMenu));
        titleOffice.setTextColor(this.getResources().getColor(R.color.activeMenu));

        AbsenOffice absenOffice = new AbsenOffice();
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, absenOffice);
        transaction.commit();
    }

    public void onBackPressed() {
        finish();
    }

    @OnClick({R.id.btn_back, R.id.tab_mobile, R.id.tab_office})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();

                break;
            case R.id.tab_mobile:
                initTabMobile();

                break;
            case R.id.tab_office:
                initTabOffice();

                break;
        }
    }
}

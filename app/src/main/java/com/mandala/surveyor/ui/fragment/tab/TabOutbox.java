package com.mandala.surveyor.ui.fragment.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mandala.surveyor.R;
import com.mandala.surveyor.ui.fragment.outbox.OutboxDraft;
import com.mandala.surveyor.ui.fragment.outbox.OutboxSelesai;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class TabOutbox extends Fragment {

    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    Unbinder unbinder;

    @BindView(R.id.img_selesai)
    ImageView imgSelesai;
    @BindView(R.id.title_selesai)
    TextView titleSelesai;
    @BindView(R.id.count_selesai)
    TextView countSelesai;
    @BindView(R.id.tab_selesai)
    LinearLayout tabSelesai;
    @BindView(R.id.img_draft)
    ImageView imgDraft;
    @BindView(R.id.title_draft)
    TextView titleDraft;
    @BindView(R.id.count_draft)
    TextView countDraft;
    @BindView(R.id.tab_draft)
    LinearLayout tabDraft;
    @BindView(R.id.fragment_container)
    FrameLayout fragmentContainer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_outbox, container, false);
        unbinder = ButterKnife.bind(this, v);

        initTabSelesai();

        return v;
    }

    @OnClick({R.id.tab_selesai, R.id.tab_draft})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tab_selesai:
                initTabSelesai();

                break;
            case R.id.tab_draft:
                initTabDraft();

                break;
        }
    }

    private void initTabSelesai() {
        tabSelesai.setBackground(this.getResources().getDrawable(R.drawable.bg_oval_grey));
        imgSelesai.setColorFilter(ContextCompat.getColor(getActivity(), R.color.activeMenu));
        titleSelesai.setTextColor(this.getResources().getColor(R.color.activeMenu));
        countSelesai.setTextColor(this.getResources().getColor(R.color.activeMenu));

        tabDraft.setBackground(null);
        imgDraft.setColorFilter(ContextCompat.getColor(getActivity(), R.color.deactiveMenu));
        titleDraft.setTextColor(this.getResources().getColor(R.color.deactiveMenu));
        countDraft.setTextColor(this.getResources().getColor(R.color.deactiveMenu));

        OutboxSelesai outboxSelesai = new OutboxSelesai();
        fragmentManager = getChildFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, outboxSelesai);
        transaction.commit();
    }

    private void initTabDraft() {
        tabSelesai.setBackground(null);
        imgSelesai.setColorFilter(ContextCompat.getColor(getActivity(), R.color.deactiveMenu));
        titleSelesai.setTextColor(this.getResources().getColor(R.color.deactiveMenu));
        countSelesai.setTextColor(this.getResources().getColor(R.color.deactiveMenu));

        tabDraft.setBackground(this.getResources().getDrawable(R.drawable.bg_oval_grey));
        imgDraft.setColorFilter(ContextCompat.getColor(getActivity(), R.color.activeMenu));
        titleDraft.setTextColor(this.getResources().getColor(R.color.activeMenu));
        countDraft.setTextColor(this.getResources().getColor(R.color.activeMenu));

        OutboxDraft outboxDraft = new OutboxDraft();
        fragmentManager = getChildFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, outboxDraft);
        transaction.commit();
    }
}

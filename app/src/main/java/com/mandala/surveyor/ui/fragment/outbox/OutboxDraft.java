package com.mandala.surveyor.ui.fragment.outbox;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.mandala.surveyor.R;
import com.mandala.surveyor.data.db.models.OutboxDraftData;
import com.mandala.surveyor.ui.adapter.AdapterOutboxDraft;
import com.mandala.surveyor.utils.RecyclerViewUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class OutboxDraft extends Fragment {

    AdapterOutboxDraft adapterOutbox;
    RecyclerViewUtil recyclerViewUtil;
    Unbinder unbinder;

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.outbox_draft, container, false);

        unbinder = ButterKnife.bind(this, v);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);

        recyclerViewUtil = new RecyclerViewUtil(getActivity(), R.dimen.card_margin);
        mRecyclerView.addItemDecoration(recyclerViewUtil);

        adapterOutbox = new AdapterOutboxDraft(getRecyclerData(), getActivity());
        mRecyclerView.setAdapter(adapterOutbox);

        return v;
    }

    private List<OutboxDraftData> getRecyclerData() {
        List<OutboxDraftData> recyclerList = new ArrayList<>();
        recyclerList.add(new OutboxDraftData("12945762923478", "John Doe", "Electronic", "Jl. H.Samali Ujung II Pasar Minggu", "Jakarta Selatan"));

        return recyclerList;
    }
}

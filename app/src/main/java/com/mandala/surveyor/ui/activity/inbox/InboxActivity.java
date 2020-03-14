package com.mandala.surveyor.ui.activity.inbox;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.mandala.surveyor.R;
import com.mandala.surveyor.data.db.models.InboxData;
import com.mandala.surveyor.ui.adapter.AdapterInbox;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class InboxActivity extends AppCompatActivity {

    AdapterInbox adapterInbox;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Inbox");

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        adapterInbox = new AdapterInbox(getRecyclerData(), this);
        mRecyclerView.setAdapter(adapterInbox);
    }

    private List<InboxData> getRecyclerData() {
        List<InboxData> recyclerList = new ArrayList<>();
        recyclerList.add(new InboxData(0, "29/11/2019"));
        recyclerList.add(new InboxData(0, "29/11/2019"));
        recyclerList.add(new InboxData(1, "29/11/2019"));

        return recyclerList;
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

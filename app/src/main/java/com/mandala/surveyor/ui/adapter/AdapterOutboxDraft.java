package com.mandala.surveyor.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mandala.surveyor.R;
import com.mandala.surveyor.data.db.models.OutboxDraftData;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class AdapterOutboxDraft extends RecyclerView.Adapter<AdapterOutboxDraft.MenuViewHolder> {

    private List<OutboxDraftData> menuList;
    private Context context;

    public AdapterOutboxDraft(List<OutboxDraftData> menuList, Context context) {
        this.menuList = menuList;
        this.context = context;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_outbox_draft, null);
        MenuViewHolder menuViewHolder = new MenuViewHolder(view);
        return menuViewHolder;
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        final OutboxDraftData dataList = menuList.get(position);

        holder.aplikasi.setText(dataList.getAplikasi());
        holder.nama.setText(dataList.getNama());
        holder.kategori.setText(dataList.getKategori());
        holder.alamat.setText(dataList.getAlamat());
        holder.kota.setText(dataList.getKota());

        holder.item.setTag(position);
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout item;
        TextView aplikasi, nama, kategori, alamat, kota;

        public MenuViewHolder(View itemView) {
            super(itemView);
            aplikasi = itemView.findViewById(R.id.aplikasi);
            nama = itemView.findViewById(R.id.nama);
            kategori = itemView.findViewById(R.id.kategori);
            alamat = itemView.findViewById(R.id.alamat);
            kota = itemView.findViewById(R.id.kota);

            item = itemView.findViewById(R.id.item);
        }
    }
}

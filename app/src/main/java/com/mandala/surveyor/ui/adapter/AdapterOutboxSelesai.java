package com.mandala.surveyor.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mandala.surveyor.R;
import com.mandala.surveyor.data.db.models.OutboxSelesaiData;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class AdapterOutboxSelesai extends RecyclerView.Adapter<AdapterOutboxSelesai.MenuViewHolder> {

    private List<OutboxSelesaiData> menuList;
    private Context context;

    public AdapterOutboxSelesai(List<OutboxSelesaiData> menuList, Context context) {
        this.menuList = menuList;
        this.context = context;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_outbox_selesai, null);
        MenuViewHolder menuViewHolder = new MenuViewHolder(view);
        return menuViewHolder;
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        final OutboxSelesaiData dataList = menuList.get(position);
        int getStatus = dataList.getStatus();

        holder.aplikasi.setText(dataList.getAplikasi());
        holder.nama.setText(dataList.getNama());
        holder.kategori.setText(dataList.getKategori());
        holder.alamat.setText(dataList.getAlamat());
        holder.kota.setText(dataList.getKota());

        if (getStatus == 1) {
            holder.flag.setBackground(context.getResources().getDrawable(R.drawable.triangle_green));
            holder.status.setTextColor(context.getResources().getColor(R.color.default_green));

        } else {
            holder.flag.setBackground(context.getResources().getDrawable(R.drawable.triangle_red));
            holder.status.setTextColor(context.getResources().getColor(R.color.default_red));
        }

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
        View flag;
        TextView status, aplikasi, nama, kategori, alamat, kota;

        public MenuViewHolder(View itemView) {
            super(itemView);
            flag = itemView.findViewById(R.id.flag);
            status = itemView.findViewById(R.id.status);
            aplikasi = itemView.findViewById(R.id.aplikasi);
            nama = itemView.findViewById(R.id.nama);
            kategori = itemView.findViewById(R.id.kategori);
            alamat = itemView.findViewById(R.id.alamat);
            kota = itemView.findViewById(R.id.kota);

            item = itemView.findViewById(R.id.item);
        }
    }
}

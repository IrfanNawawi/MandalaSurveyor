package com.mandala.surveyor.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mandala.surveyor.R;
import com.mandala.surveyor.data.db.models.LacakAplikasiData;
import com.mandala.surveyor.ui.activity.lacakaplikasi.LacakAplikasiDetail;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class AdapterLacakAplikasi extends RecyclerView.Adapter<AdapterLacakAplikasi.MenuViewHolder> {

    private List<LacakAplikasiData> menuList;
    private Context context;

    public AdapterLacakAplikasi(List<LacakAplikasiData> menuList, Context context) {
        this.menuList = menuList;
        this.context = context;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lacak_aplikasi, null);
        MenuViewHolder menuViewHolder = new MenuViewHolder(view);
        return menuViewHolder;
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        final LacakAplikasiData dataList = menuList.get(position);

        int status = dataList.getStatus();

        holder.tglTerima.setText(dataList.getTanggal());
        holder.noAplikasi.setText(dataList.getAplikasi());
        holder.nama.setText(dataList.getNama());
        holder.kategori.setText(dataList.getKategori());
        holder.alamat.setText(dataList.getAlamat());

        if (status == 0) {
            holder.badgeStatus.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
            holder.tvStatus.setTextColor(context.getResources().getColor(R.color.colorAccent));
            holder.status.setText("Belum Survey");
            holder.status.setTextColor(context.getResources().getColor(R.color.colorAccent));
        } else if (status == 1) {
            holder.badgeStatus.setBackgroundColor(context.getResources().getColor(R.color.default_yellow));
            holder.tvStatus.setTextColor(context.getResources().getColor(R.color.default_yellow));
            holder.status.setText("Proses Survey");
            holder.status.setTextColor(context.getResources().getColor(R.color.default_yellow));
        } else if (status == 2) {
            holder.badgeStatus.setBackgroundColor(context.getResources().getColor(R.color.default_green));
            holder.tvStatus.setTextColor(context.getResources().getColor(R.color.default_green));
            holder.status.setText("Selesai");
            holder.status.setTextColor(context.getResources().getColor(R.color.default_green));
        } else {
            holder.badgeStatus.setBackgroundColor(context.getResources().getColor(R.color.default_red));
            holder.tvStatus.setTextColor(context.getResources().getColor(R.color.default_red));
            holder.status.setText("Pending");
            holder.status.setTextColor(context.getResources().getColor(R.color.default_red));
        }

        holder.item.setTag(position);
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, LacakAplikasiDetail.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout item;
        TextView tglTerima, noAplikasi, nama, kategori, alamat, tvStatus, status;
        View badgeStatus;

        public MenuViewHolder(View itemView) {
            super(itemView);
            tglTerima = itemView.findViewById(R.id.tgl_terima);
            noAplikasi = itemView.findViewById(R.id.no_aplikasi);
            nama = itemView.findViewById(R.id.nama);
            kategori = itemView.findViewById(R.id.kategori);
            alamat = itemView.findViewById(R.id.alamat);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            status = itemView.findViewById(R.id.status);

            badgeStatus = itemView.findViewById(R.id.badge_status);
            item = itemView.findViewById(R.id.item);
        }
    }
}

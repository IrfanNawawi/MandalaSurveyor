package com.mandala.surveyor.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mandala.surveyor.R;
import com.mandala.surveyor.data.db.models.KelengkapanData;
import com.mandala.surveyor.ui.activity.kelengkapandata.KelengkapanDataDetail;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class AdapterKelengkapanData extends RecyclerView.Adapter<AdapterKelengkapanData.MenuViewHolder> {

    private List<KelengkapanData> menuList;
    private Context context;

    public AdapterKelengkapanData(List<KelengkapanData> menuList, Context context) {
        this.menuList = menuList;
        this.context = context;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_kelengkapan_data, null);
        MenuViewHolder menuViewHolder = new MenuViewHolder(view);
        return menuViewHolder;
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        final KelengkapanData dataList = menuList.get(position);

        holder.noBooking.setText(": " + dataList.getBooking());
        holder.tglBooking.setText(": " + dataList.getTanggal());
        holder.nama.setText(dataList.getNama());
        holder.kategori.setText(dataList.getKategori());
        holder.alamat.setText(dataList.getAlamat());

        holder.item.setTag(position);
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, KelengkapanDataDetail.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout item;
        TextView noBooking, tglBooking, nama, kategori, alamat;

        public MenuViewHolder(View itemView) {
            super(itemView);
            noBooking = itemView.findViewById(R.id.no_booking);
            tglBooking = itemView.findViewById(R.id.tgl_booking);
            nama = itemView.findViewById(R.id.nama);
            kategori = itemView.findViewById(R.id.kategori);
            alamat = itemView.findViewById(R.id.alamat);

            item = itemView.findViewById(R.id.item);
        }
    }
}

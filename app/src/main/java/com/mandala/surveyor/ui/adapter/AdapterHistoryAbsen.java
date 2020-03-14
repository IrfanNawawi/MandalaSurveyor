package com.mandala.surveyor.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mandala.surveyor.R;
import com.mandala.surveyor.data.db.models.HistoryAbsenData;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class AdapterHistoryAbsen extends RecyclerView.Adapter<AdapterHistoryAbsen.MenuViewHolder> {

    private List<HistoryAbsenData> menuList;
    private Context context;

    public AdapterHistoryAbsen(List<HistoryAbsenData> menuList, Context context) {
        this.menuList = menuList;
        this.context = context;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_history_absen, null);
        MenuViewHolder menuViewHolder = new MenuViewHolder(view);
        return menuViewHolder;
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        final HistoryAbsenData dataList = menuList.get(position);
        int status_absen = dataList.getStatus();

        holder.image.setImageResource(dataList.getImage());
        holder.title.setText(dataList.getTitle());
        holder.nama.setText(dataList.getNama());
        holder.nik.setText(dataList.getNik());
        holder.cabang.setText(dataList.getCabang());
        holder.job.setText(dataList.getJob());
        holder.waktuAbsen.setText(dataList.getWaktuAbsen());

        if (status_absen == 1) {
            holder.status.setBackgroundColor(context.getResources().getColor(R.color.default_green));
        } else if (status_absen == 2) {
            holder.status.setBackgroundColor(context.getResources().getColor(R.color.default_orange));
        } else if (status_absen == 3) {
            holder.status.setBackgroundColor(context.getResources().getColor(R.color.default_red));
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
        ImageView image;
        TextView title, nama, nik, cabang, job, waktuAbsen;
        View status;

        public MenuViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            nama = itemView.findViewById(R.id.nama);
            nik = itemView.findViewById(R.id.nik);
            cabang = itemView.findViewById(R.id.cabang);
            job = itemView.findViewById(R.id.job);
            waktuAbsen = itemView.findViewById(R.id.waktu_absen);

            status = itemView.findViewById(R.id.status);
            item = itemView.findViewById(R.id.item);
        }
    }
}

package com.mandala.surveyor.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.mandala.surveyor.R;
import com.mandala.surveyor.data.db.models.SurveyData;
import com.mandala.surveyor.ui.activity.takstator.DetailTakstator;

import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterTakstator extends RecyclerView.Adapter<AdapterTakstator.MenuViewHolder> {

    private List<SurveyData> menuList;
    private Context context;

    public AdapterTakstator(List<SurveyData> menuList, Context context) {
        this.menuList = menuList;
        this.context = context;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_takstator, null);
        MenuViewHolder menuViewHolder = new MenuViewHolder(view);
        return menuViewHolder;
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        final SurveyData dataList = menuList.get(position);
        int getStatus = dataList.getStatus();

        holder.noAplikasi.setText(dataList.getAplikasi());
        holder.nama.setText(dataList.getNama());
        holder.kategori.setText(dataList.getKategori());
        holder.alamat.setText(dataList.getAlamat());

        if (getStatus == 0) {
            holder.status.setText(dataList.getJarak());
        } else {
            holder.status.setText("Selesai");
            holder.status.setTextSize(20);
            holder.jarak.setVisibility(View.GONE);
            holder.btnBatal.setBackground(context.getDrawable(R.drawable.bg_btn_grey));
            holder.btnBatal.setEnabled(false);
        }

        holder.btnBatal.setTag(position);
        holder.btnBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder;
                builder = new AlertDialog.Builder(context);
                builder.setCancelable(true);
                View alertLayout = LayoutInflater.from(context).inflate(R.layout.dialog_batal, null);
                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setView(alertLayout);
                alert.setCancelable(true);

                final AlertDialog dialog = alert.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                final Spinner spinnerAlasan = alertLayout.findViewById(R.id.spinnerAlasan);
                final ArrayAdapter<String> adapterAlasan;
                final Button btnSubmit = alertLayout.findViewById(R.id.btn_submit);

                adapterAlasan = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item) {

                    public View getDropDownView(int position, View convertView, ViewGroup parent) {
                        View v = super.getDropDownView(position, convertView, parent);

                        return v;
                    }
                };
                adapterAlasan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                adapterAlasan.add("---");
                spinnerAlasan.setAdapter(adapterAlasan);

                btnSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });

        holder.item.setTag(position);
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent varSurvey = new Intent(context, DetailTakstator.class);
//                varSurvey.putExtra("SURVEYLIST", dataList);
                varSurvey.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(varSurvey);
            }
        });

    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.btn_batal)
        Button btnBatal;
        @BindView(R.id.item)
        RelativeLayout item;
        @BindView(R.id.status)
        TextView status;
        @BindView(R.id.jarak)
        TextView jarak;
        @BindView(R.id.no_aplikasi)
        TextView noAplikasi;
        @BindView(R.id.nama)
        TextView nama;
        @BindView(R.id.kategori)
        TextView kategori;
        @BindView(R.id.alamat)
        TextView alamat;

        public MenuViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

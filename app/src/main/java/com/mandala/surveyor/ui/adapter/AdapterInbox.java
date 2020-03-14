package com.mandala.surveyor.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mandala.surveyor.R;
import com.mandala.surveyor.data.db.models.InboxData;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class AdapterInbox extends RecyclerView.Adapter<AdapterInbox.MenuViewHolder> {

    private List<InboxData> menuList;
    private Context context;

    public AdapterInbox(List<InboxData> menuList, Context context) {
        this.menuList = menuList;
        this.context = context;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_inbox, null);
        MenuViewHolder menuViewHolder = new MenuViewHolder(view);
        return menuViewHolder;
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        final InboxData dataList = menuList.get(position);
        int flags = dataList.getFlag();

        holder.date.setText(dataList.getDate());

        if (flags == 1) {
            holder.image.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_inbox_read));
        } else {
            holder.image.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_inbox_unread));
        }

        holder.item.setTag(position);
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flags == 1) {
                    System.out.println("Item Clicked");
                } else {
//                    context.startActivity(new Intent(context, PemberitahuanDetail.class));
//                    ((Activity) context).finish();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        LinearLayout item;
        TextView date;
        View flag;

        public MenuViewHolder(View itemView) {
            super(itemView);
            flag = itemView.findViewById(R.id.flag);
            date = itemView.findViewById(R.id.date);

            image = itemView.findViewById(R.id.image);
            item = itemView.findViewById(R.id.item);
        }
    }
}

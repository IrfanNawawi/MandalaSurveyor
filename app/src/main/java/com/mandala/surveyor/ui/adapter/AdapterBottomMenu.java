package com.mandala.surveyor.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mandala.surveyor.R;
import com.mandala.surveyor.data.items.BottomMenu;
import com.mandala.surveyor.ui.activity.absen.AbsenActivity;
import com.mandala.surveyor.ui.activity.inbox.InboxActivity;
import com.mandala.surveyor.ui.activity.kelengkapandata.KelengkapanDataActivity;
import com.mandala.surveyor.ui.activity.lacakaplikasi.LacakAplikasiActivity;
import com.mandala.surveyor.ui.activity.penugasan.PenugasanActivity;
import com.mandala.surveyor.ui.activity.performance.MyPerformanceActivity;
import com.mandala.surveyor.utils.custom.ProportionalImageView;
import com.nex3z.notificationbadge.NotificationBadge;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class AdapterBottomMenu extends RecyclerView.Adapter<AdapterBottomMenu.MenuViewHolder> {

    private List<BottomMenu> menuList;
    private Context context;

    public AdapterBottomMenu(List<BottomMenu> menuList, Context context) {
        this.menuList = menuList;
        this.context = context;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_bottom_menu, null);
        MenuViewHolder menuViewHolder = new MenuViewHolder(view);
        return menuViewHolder;
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        final BottomMenu bottomMenu = menuList.get(position);

        holder.image.setImageResource(bottomMenu.getImage());
        holder.title.setText(bottomMenu.getTitle());
        holder.badge.setNumber(bottomMenu.getBadge());
        holder.menu.setTag(position);
        holder.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (bottomMenu.getTitle()) {
                    case "Absen":
                        context.startActivity(new Intent(context, AbsenActivity.class));

                        break;
                    case "Penugasan":
                        context.startActivity(new Intent(context, PenugasanActivity.class));

                        break;
                    case "My\nPerformance":
                        context.startActivity(new Intent(context, MyPerformanceActivity.class));

                        break;
                    case "Lacak\nAplikasi":
                        context.startActivity(new Intent(context, LacakAplikasiActivity.class));

                        break;
                    case "Inbox":
                        context.startActivity(new Intent(context, InboxActivity.class));

                        break;
                    case "Kelengkapan\nData":
                        context.startActivity(new Intent(context, KelengkapanDataActivity.class));

                        break;
                    default:
                        //DEFAULT
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {

        LinearLayout menu;
        ProportionalImageView image;
        NotificationBadge badge;
        TextView title;

        public MenuViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            badge = itemView.findViewById(R.id.badge);

            menu = itemView.findViewById(R.id.menu);
        }
    }
}

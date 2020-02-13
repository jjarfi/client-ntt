package com.github.jjarfi.sibntt.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.jjarfi.sibntt.Model.Suku;
import com.github.jjarfi.sibntt.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeView> {
    Context context;
    List<Suku> suku;

    public HomeAdapter(Context context, int content_home, List<Suku> suku) {
        this.context = context;
        this.suku = suku;
    }

    @NonNull
    @Override
    public HomeView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.menu_item_layout_home, null);

        return new HomeView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeView holder, int position) {
        Picasso.with(context)
                .load(suku.get(position).getLink()).into(holder.img_home);

        holder.txt_namahome.setText(suku.get(position).getNamasuku());

    }

    @Override
    public int getItemCount() {
        return suku.size();
    }
}

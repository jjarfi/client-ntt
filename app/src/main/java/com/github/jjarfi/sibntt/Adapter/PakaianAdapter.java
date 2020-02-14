package com.github.jjarfi.sibntt.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.github.jjarfi.sibntt.Model.Pakaian;
import com.github.jjarfi.sibntt.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PakaianAdapter extends RecyclerView.Adapter<PakaianView> {
    Context context;
    List<Pakaian> pakaian;

    public PakaianAdapter(Context context, int activity_pakaian, List<Pakaian> pakaian) {
        this.context = context;
        this.pakaian = pakaian;
    }

    @NonNull
    @Override
    public PakaianView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.menu_item_layout_pakaian, null);

        return new PakaianView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PakaianView holder, int position) {
        Picasso.with(context)
                .load(pakaian.get(position).getLink()).into(holder.img_pakaian);

        holder.txt_pakaian.setText(pakaian.get(position).getNamapakaian());
        holder.txt_desk.setText(pakaian.get(position).getDeskripsi());

    }

    @Override
    public int getItemCount() {
        return pakaian.size();
    }
}

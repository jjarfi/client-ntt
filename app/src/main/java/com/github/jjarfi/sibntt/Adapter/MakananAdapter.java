package com.github.jjarfi.sibntt.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.jjarfi.sibntt.Model.Makanan;
import com.github.jjarfi.sibntt.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MakananAdapter extends RecyclerView.Adapter<MakananView> {
    Context context;
    List<Makanan>makanan;

    public MakananAdapter(Context context, int activity_makanan, List<Makanan> makanan) {
        this.context = context;
        this.makanan = makanan;
    }

    @NonNull
    @Override

    public MakananView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.menu_item_layout_makanan, null);

        return new MakananView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MakananView holder, int position) {
        Picasso.with(context)
                .load(makanan.get(position).getLink()).into(holder.img_makanan);

        holder.txt_makanan.setText(makanan.get(position).getNamamakanan());
        holder.txt_desk_makanan.setText(makanan.get(position).getDeskripsi());

    }

    @Override
    public int getItemCount() {
        return makanan.size();
    }
}

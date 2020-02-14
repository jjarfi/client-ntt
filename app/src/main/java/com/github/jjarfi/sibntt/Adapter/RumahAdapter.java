package com.github.jjarfi.sibntt.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.jjarfi.sibntt.Model.Rumah;
import com.github.jjarfi.sibntt.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RumahAdapter extends RecyclerView.Adapter<RumahView> {

    Context context;
    List<Rumah> rumah;

    public RumahAdapter(Context context, int activity_rumah, List<Rumah> rumah) {
        this.context = context;
        this.rumah = rumah;
    }

    @NonNull
    @Override
    public RumahView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.menu_item_layout_rumah, null);

        return new RumahView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RumahView holder, int position) {
        Picasso.with(context)
                .load(rumah.get(position).getLink()).into(holder.img_rumah);

        holder.txt_rumah.setText(rumah.get(position).getNamarumah());
        holder.txt_desk.setText(rumah.get(position).getDeskripsi());

    }

    @Override
    public int getItemCount() {
        return rumah.size();
    }
}

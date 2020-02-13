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


public class SukuAdapter extends RecyclerView.Adapter<SukuView> {
    Context context;
    List<Suku> suku;

    public SukuAdapter(Context context, int activity_suku, List<Suku> suku) {
        this.context = context;
        this.suku = suku;
    }

    @NonNull
    @Override
    public SukuView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.menu_item_layout_suku, null);

        return new SukuView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SukuView holder, int position) {
        Picasso.with(context)
                .load(suku.get(position).getLink()).into(holder.img_suku);

        holder.txt_suku.setText(suku.get(position).getNamasuku());
        holder.txt_desk.setText(suku.get(position).getDeskripsi());
    }

    @Override
    public int getItemCount() {
        return suku.size();
    }
}

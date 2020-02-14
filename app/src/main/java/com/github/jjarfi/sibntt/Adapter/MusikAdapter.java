package com.github.jjarfi.sibntt.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.jjarfi.sibntt.Model.Musik;
import com.github.jjarfi.sibntt.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MusikAdapter extends RecyclerView.Adapter<MusikView> {

    Context context;
    List<Musik> musik;

    public MusikAdapter(Context context, int activity_musik, List<Musik> musik) {
        this.context = context;
        this.musik = musik;
    }

    @NonNull
    @Override
    public MusikView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.menu_item_layout_musik, null);

        return new MusikView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MusikView holder, int position) {
        Picasso.with(context)
                .load(musik.get(position).getLink()).into(holder.img_musik);

        holder.txt_musik.setText(musik.get(position).getNamamusik());
        holder.txt_desk_musik.setText(musik.get(position).getDeskripsi());

    }

    @Override
    public int getItemCount() {
        return musik.size();
    }
}

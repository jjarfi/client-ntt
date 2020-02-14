package com.github.jjarfi.sibntt.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.jjarfi.sibntt.Model.Sejarah;
import com.github.jjarfi.sibntt.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SejarahAdapter extends RecyclerView.Adapter<SejarahView> {
    Context context;
    List<Sejarah> sejarah;

    public SejarahAdapter(Context context, int activity_sejarah, List<Sejarah> sejarah) {
        this.context = context;
        this.sejarah = sejarah;
    }

    @NonNull
    @Override
    public SejarahView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.menu_item_layout_sejarah, null);

        return new SejarahView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SejarahView holder, int position) {
        Picasso.with(context)
                .load(sejarah.get(position).getLink()).into(holder.img_sejarah);

        holder.txt_sejarah.setText(sejarah.get(position).getNamasejarah());
        holder.txt_desk.setText(sejarah.get(position).getDeskripsi());
    }

    @Override
    public int getItemCount() {
        return sejarah.size();
    }
}

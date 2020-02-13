package com.github.jjarfi.sibntt.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.jjarfi.sibntt.Model.Suku;
import com.github.jjarfi.sibntt.Model.Tarian;
import com.github.jjarfi.sibntt.R;
import com.github.jjarfi.sibntt.SukuActivity;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

public class TarianAdapter extends RecyclerView.Adapter<TarianView> {
    Picasso picasso;
    Context context;
    List<Tarian> tarian;

    public TarianAdapter(Context context, int activity_tarian, List<Tarian> tarian) {
        this.context = context;
        this.tarian = tarian;
    }


    @NonNull
    @Override
    public TarianView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.menu_item_layout_tarian, null);

        return new TarianView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TarianView holder, int position) {
//        Picasso.with(context)
//                .load(tarian.get(position).getLink()).into((Target) holder.img_tarian);
        holder.img_tarian.loadData(tarian.get(position).getLink(), "text/html","utf-8");

        holder.txt_tarian.setText(tarian.get(position).getNamatarian());

    }

    @Override
    public int getItemCount() {
        return tarian.size();
    }
}

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

public class HomeSejarahAdapter extends RecyclerView.Adapter<HomeSejarahView> {

    Context context;
    List<Sejarah> sejarah;

    public HomeSejarahAdapter(Context context, int content_home, List<Sejarah> sejarah) {
        this.context = context;
        this.sejarah = sejarah;
    }

    @NonNull
    @Override
    public HomeSejarahView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.menu_item_layout_home_sejarah, null);
        return new HomeSejarahView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeSejarahView holder, int position) {
        Picasso.with(context)
                .load(sejarah.get(position).getLink()).into(holder.img_sejarah_home);

        holder.txt_sejarah_home.setText(sejarah.get(position).getNamasejarah());
        holder.txt_desk_home_sejarah.setText(sejarah.get(position).getDeskripsi());
    }

    @Override
    public int getItemCount() {
        return sejarah.size();
    }
}

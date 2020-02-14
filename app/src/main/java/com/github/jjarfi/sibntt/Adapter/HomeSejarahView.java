package com.github.jjarfi.sibntt.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.jjarfi.sibntt.R;

public class HomeSejarahView extends RecyclerView.ViewHolder {
    ImageView img_sejarah_home;
    TextView txt_sejarah_home;
    TextView txt_desk_home_sejarah;
    public HomeSejarahView(@NonNull View itemView) {
        super(itemView);

        img_sejarah_home = (ImageView) itemView.findViewById(R.id.img_sejarah_home_menu);
        txt_sejarah_home= (TextView)itemView.findViewById(R.id.txt_nama_sejarah_home_menu);
        txt_desk_home_sejarah= (TextView)itemView.findViewById(R.id.txt_desk_sejarah_home_menu);
    }
}

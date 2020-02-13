package com.github.jjarfi.sibntt.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.jjarfi.sibntt.R;

public class HomeView extends RecyclerView.ViewHolder {
    ImageView img_home;
    TextView txt_namahome;
    public HomeView(@NonNull View itemView) {
        super(itemView);

        img_home = (ImageView) itemView.findViewById(R.id.img_menu_home);
        txt_namahome= (TextView)itemView.findViewById(R.id.txt_nama_home);
    }
}

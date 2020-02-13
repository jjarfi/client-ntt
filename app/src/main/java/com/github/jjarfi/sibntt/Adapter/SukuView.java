package com.github.jjarfi.sibntt.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.jjarfi.sibntt.R;

public class SukuView extends RecyclerView.ViewHolder {
    ImageView img_suku;
    TextView txt_suku;
    TextView txt_desk;
    public SukuView(@NonNull View itemView) {
        super(itemView);


        img_suku = (ImageView) itemView.findViewById(R.id.img_suku_menu);
        txt_suku= (TextView)itemView.findViewById(R.id.txt_nama_suku_menu);
        txt_desk= (TextView)itemView.findViewById(R.id.txt_desk_suku_menu);
    }
}

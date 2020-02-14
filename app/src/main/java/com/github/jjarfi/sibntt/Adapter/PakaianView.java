package com.github.jjarfi.sibntt.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.jjarfi.sibntt.R;

public class PakaianView extends RecyclerView.ViewHolder {
    ImageView img_pakaian;
    TextView txt_pakaian;
    TextView txt_desk;
    public PakaianView(@NonNull View itemView) {
        super(itemView);

        img_pakaian = (ImageView) itemView.findViewById(R.id.img_pakaian_menu);
        txt_pakaian= (TextView)itemView.findViewById(R.id.txt_nama_pakaian_menu);
        txt_desk= (TextView)itemView.findViewById(R.id.txt_desk_pakaian_menu);
    }
}

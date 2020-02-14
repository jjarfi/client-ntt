package com.github.jjarfi.sibntt.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.jjarfi.sibntt.R;

public class RumahView extends RecyclerView.ViewHolder {
    ImageView img_rumah;
    TextView txt_rumah;
    TextView txt_desk;

    public RumahView(@NonNull View itemView) {
        super(itemView);

        img_rumah = (ImageView) itemView.findViewById(R.id.img_rumah_menu);
        txt_rumah = (TextView) itemView.findViewById(R.id.txt_nama_rumah_menu);
        txt_desk = (TextView) itemView.findViewById(R.id.txt_desk_rumah_menu);
    }
}

package com.github.jjarfi.sibntt.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.jjarfi.sibntt.R;

public class SejarahView extends RecyclerView.ViewHolder {
    ImageView img_sejarah;
    TextView txt_sejarah;
    TextView txt_desk;

    public SejarahView(@NonNull View itemView) {
        super(itemView);
        img_sejarah = (ImageView) itemView.findViewById(R.id.img_sejarah_menu);
        txt_sejarah = (TextView) itemView.findViewById(R.id.txt_nama_sejarah_menu);
        txt_desk = (TextView) itemView.findViewById(R.id.txt_desk_sejarah_menu);
    }
}

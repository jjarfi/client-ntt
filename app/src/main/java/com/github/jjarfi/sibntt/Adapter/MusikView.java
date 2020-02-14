package com.github.jjarfi.sibntt.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.jjarfi.sibntt.R;

public class MusikView extends RecyclerView.ViewHolder {

    ImageView img_musik;
    TextView txt_musik;
    TextView txt_desk_musik;
    public MusikView(@NonNull View itemView) {
        super(itemView);
        img_musik = (ImageView) itemView.findViewById(R.id.img_musik_menu);
        txt_musik= (TextView)itemView.findViewById(R.id.txt_nama_musik_menu);
        txt_desk_musik= (TextView)itemView.findViewById(R.id.txt_desk_musik_menu);

    }
}

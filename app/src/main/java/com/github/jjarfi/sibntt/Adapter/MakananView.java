package com.github.jjarfi.sibntt.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.github.jjarfi.sibntt.R;
public class MakananView extends RecyclerView.ViewHolder {
    ImageView img_makanan;
    TextView txt_makanan;
    TextView txt_desk_makanan;
    public MakananView(@NonNull View itemView) {
        super(itemView);

        img_makanan = (ImageView) itemView.findViewById(R.id.img_makanan_menu);
        txt_makanan= (TextView)itemView.findViewById(R.id.txt_nama_makanan_menu);
        txt_desk_makanan= (TextView)itemView.findViewById(R.id.txt_desk_makanan_menu);
    }
}

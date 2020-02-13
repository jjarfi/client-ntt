package com.github.jjarfi.sibntt.Adapter;

import android.content.Context;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import com.github.jjarfi.sibntt.Model.Makanan;

import java.util.List;

public class MakananAdapter extends ArrayAdapter<Makanan> {

    public MakananAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Makanan> objects) {
        super(context, resource, textViewResourceId, objects);
    }
}

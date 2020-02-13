package com.github.jjarfi.sibntt.Adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.github.jjarfi.sibntt.Model.Musik;

import java.util.List;

public class MusikAdapter extends ArrayAdapter<Musik> {

    public MusikAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Musik> objects) {
        super(context, resource, textViewResourceId, objects);
    }
}

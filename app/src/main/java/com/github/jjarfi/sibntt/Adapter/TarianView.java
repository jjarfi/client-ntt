package com.github.jjarfi.sibntt.Adapter;

import android.annotation.SuppressLint;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.jjarfi.sibntt.R;

public class TarianView extends RecyclerView.ViewHolder {
    WebView img_tarian;
    TextView txt_tarian;
    WebChromeClient chromeClient;
    WebViewClient wvClient;

    @SuppressLint("SetJavaScriptEnabled")
    public TarianView(@NonNull View itemView) {
        super(itemView);

        img_tarian = (WebView) itemView.findViewById(R.id.img_tarian_menu);
        txt_tarian= (TextView)itemView.findViewById(R.id.txt_nama_tarian_menu);
        img_tarian.setWebChromeClient(chromeClient);
        img_tarian.setWebViewClient(wvClient);
        img_tarian.getSettings().setJavaScriptEnabled(true);
        img_tarian.getSettings().setPluginState(WebSettings.PluginState.ON);
    }
}

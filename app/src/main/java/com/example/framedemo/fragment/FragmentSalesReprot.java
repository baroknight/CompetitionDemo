package com.example.framedemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.framedemo.R;

import me.yokeyword.fragmentation.SupportFragment;

public class FragmentSalesReprot extends SupportFragment {

    private WebView wv_visual_figure;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getContext()).inflate(R.layout.fragment_sales_report, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
//        initData();
//        initWebView();
        initWebViewDemo();
    }

    private void initWebViewDemo() {
        wv_visual_figure.loadUrl("file:///android_asset/indexDemo.html");

        wv_visual_figure.getSettings().setAllowFileAccess(true);
        wv_visual_figure.getSettings().setJavaScriptEnabled(true);

        wv_visual_figure.setWebViewClient(new WebViewClient() {
                                              @Override
                                              public void onPageFinished(WebView view, String url) {
                                                  super.onPageFinished(view, url);
                                              }
                                          }
        );
    }

    private void initData() {
    }

    private void initWebView() {
        wv_visual_figure.loadUrl("file:///android_asset/index.html");

        wv_visual_figure.getSettings().setAllowFileAccess(true);
        wv_visual_figure.getSettings().setJavaScriptEnabled(true);

        wv_visual_figure.setWebViewClient(new WebViewClient() {
                                              @Override
                                              public void onPageFinished(WebView view, String url) {
                                                  super.onPageFinished(view, url);
//                                                  wv_visual_figure.loadUrl("javascript:createEchart(" + dataName + "," + dataPrice + ")");
                                              }
                                          }
        );
    }

    private void initView(View view) {
        wv_visual_figure = view.findViewById(R.id.wv_car_visual_figure);
    }
}

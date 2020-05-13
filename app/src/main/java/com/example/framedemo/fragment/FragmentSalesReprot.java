package com.example.framedemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.framedemo.R;

import me.yokeyword.fragmentation.SupportFragment;

public class FragmentSalesReprot extends SupportFragment {
    ImageView ivColdWind;
    ImageView ivWarmWind;
    ImageButton ibSwitch;
    Button btnCold;
    Button btnWarm;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getContext()).inflate(R.layout.fragment_sales_report,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initListener();
    }

    private void initListener() {
        btnWarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivColdWind.setImageResource(R.drawable.close_cold_wind);
                ivWarmWind.setImageResource(R.drawable.open_warm_wind);
            }
        });
        btnCold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivColdWind.setImageResource(R.drawable.open_cold_wind);
                ivWarmWind.setImageResource(R.drawable.close_warm_wind);
            }
        });
        ibSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivColdWind.setImageResource(R.drawable.close_cold_wind);
                ivWarmWind.setImageResource(R.drawable.close_warm_wind);
            }
        });
    }

    private void initView(View view) {
        ivColdWind = view.findViewById(R.id.iv_cold_wind);
        ivWarmWind = view.findViewById(R.id.iv_warm_wind);
        ibSwitch = view.findViewById(R.id.ib_switch);
        btnCold = view.findViewById(R.id.btn_cold);
        btnWarm = view.findViewById(R.id.btn_warm);
    }
}

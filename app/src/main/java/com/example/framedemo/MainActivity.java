package com.example.framedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.framedemo.fragment.FragmentFactoryEnvironment;
import com.example.framedemo.fragment.FragmentHome;
import com.example.framedemo.fragment.FragmentSalesReprot;
import com.google.android.material.navigation.NavigationView;

import me.yokeyword.fragmentation.SupportActivity;

public class MainActivity extends SupportActivity {
    NavigationView navigationView;
    DrawerLayout mDrawerLayout;
    Toolbar mToolbar;
    TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();

        /**
         *  跳转Fragment监听
         * */
        initListener();
    }

    private void initFragment() {
        loadRootFragment(R.id.container, new FragmentHome());
    }

    private void initListener() {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu_fragment_home:
                                setFragmentText("首页");
                                startWithPop(new FragmentHome());
                                break;
                            case R.id.menu_fragment_sales_report:
                                setFragmentText("销售报表");
                                startWithPop(new FragmentSalesReprot());
                                break;
                            case R.id.menu_fragment_factory_environment:
                                setFragmentText("工厂环境");
                                startWithPop(new FragmentFactoryEnvironment());
                                break;
                        }
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                }
        );
    }

    private void setFragmentText(String title) {
        mTitle.setText(title);

    }

    private void initView() {
        navigationView = findViewById(R.id.navigation);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToolbar = findViewById(R.id.toolbar);
        mTitle = findViewById(R.id.tv_title);
        /**
         *  点击图标打开左侧导航栏
         * */
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                mDrawerLayout, mToolbar, R.string.open_drawer,
                R.string.close_drawer);
        toggle.syncState();
        mDrawerLayout.addDrawerListener(toggle);

    }
}

package com.example.sdk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class SpiceActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_close;
    private Button btn_return;


    public static final int CODE_RESULT = 2000; //返回结果的code
    int curPos;
    ViewPager viewPager;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spice);
        initView();
    }

    private void initView() {
        btn_close = (Button) findViewById(R.id.btn_close);
        btn_return = (Button) findViewById(R.id.btn_return);
        viewPager = findViewById(R.id.viewPager);
        if(getIntent() != null){
            //获取图片的路径集合
            list = getIntent().getStringArrayListExtra("imgs");
            //当前显示的图片位置
            curPos = getIntent().getIntExtra("pos",0);
        }else{
            list = new ArrayList<>();
        }

        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myViewPagerAdapter);
        if(curPos > 0) viewPager.setCurrentItem(curPos);
        btn_close.setOnClickListener(this);
        btn_return.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_close) {
            Intent intent = getIntent();
            intent.putExtra("path", "/data/data/a.png");
            setResult(CODE_RESULT, intent);
            finish();
        } else if (id == R.id.btn_return) {
        }
    }

    class MyViewPagerAdapter extends FragmentPagerAdapter {

        public MyViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return ImageFragment.newInstance(list.get(position));
        }
    }
}
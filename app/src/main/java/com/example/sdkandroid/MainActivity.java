package com.example.sdkandroid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sdk.SpiceActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_click;

    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn_click = (Button) findViewById(R.id.btn_click);
        list = new ArrayList<>();
        list.add("https://t7.baidu.com/it/u=378254553,3884800361&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg?sec=1601260805&t=4bd5ddf2a88416807b386d8176de7c36");
        list.add("https://t8.baidu.com/it/u=3571592872,3353494284&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg?sec=1601260805&t=0da7606aa4b5cce19eba06c4f8992175");
        list.add("https://t7.baidu.com/it/u=3616242789,1098670747&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg?sec=1601260805&t=9fb8302d7a49a70714120150110f3d56");
        btn_click = (Button) findViewById(R.id.btn_click);
        btn_click.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_click:
                btnOnClick();
                break;
        }
    }

    private void btnOnClick() {
        Intent intent = new Intent();
        intent.setAction("SpiceActivity");
        intent.putStringArrayListExtra("imgs", (ArrayList<String>) list);
        intent.putExtra("pos", 1);
        startActivityForResult(intent, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == SpiceActivity.CODE_RESULT) {
            if (data != null) {
                Log.i("path", data.getStringExtra("path"));
            }
        }
    }
}
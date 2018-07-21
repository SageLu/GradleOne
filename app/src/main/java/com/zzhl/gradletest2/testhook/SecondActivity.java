package com.zzhl.gradletest2.testhook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zzhl.gradletest2.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}

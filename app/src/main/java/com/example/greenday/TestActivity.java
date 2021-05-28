package com.example.greenday;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    LinearLayout main_container;
    Button button1, button2, button3, button4, button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        setTitle("뷰페이저테스트");

        main_container = (LinearLayout)findViewById(R.id.main_container);
        button1 = (Button)findViewById(R.id.rank);
        button2 = (Button)findViewById(R.id.trash);
        button3 = (Button)findViewById(R.id.home);
        button4 = (Button)findViewById(R.id.shop);
        button5 = (Button)findViewById(R.id.user);

    }

}
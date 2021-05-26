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
    Button button1, button2, button3;
    ChallengeFragment challengeFragment;
    RankFragment rankFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        setTitle("뷰페이저테스트");

        main_container = (LinearLayout)findViewById(R.id.main_container);
        ViewPager pager = (ViewPager)findViewById(R.id.view_pager);
        button1 = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);



    }

    class MyPagerAdapter extends FragmentPagerAdapter{
        ArrayList<Fragment> fragments;

        public MyPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
            fragments = new ArrayList<>();
            fragments.add(new ChallengeFragment());
            fragments.add(new RankFragment());
        }
        @Override
        public int getCount() {
            return 2;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }
    }
}
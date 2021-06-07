package com.example.greenday;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
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
    Button rank, trash, home, shop, user;
    FragmentManager fragmentManager;
    FragmentTransaction ft;
    ChallengeFragment challengeFragment;
    ShopFragment shopFragment;

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        setTitle("뷰페이저테스트");

        main_container = (LinearLayout)findViewById(R.id.main_container);
        viewPager= (ViewPager)findViewById(R.id.view_pager);
        rank = (Button)findViewById(R.id.rank);
        trash = (Button)findViewById(R.id.trash);
        home = (Button)findViewById(R.id.home);
        shop = (Button)findViewById(R.id.shop);
        user = (Button)findViewById(R.id.user);

        viewPager= (ViewPager)findViewById(R.id.view_pager);


        rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft = fragmentManager.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.main_container, challengeFragment);
                ft.commit();
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft = fragmentManager.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.main_container, shopFragment);
                ft.commit();
            }
        });

        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }


    class MyPagerAdapter extends FragmentPagerAdapter{
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();

        public MyPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
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
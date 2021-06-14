package com.example.greenday;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class Main2Activity extends AppCompatActivity {
    Button rank, trash, home, shop, user;
    LinearLayout mainontainer;
    FragmentManager fragmentManager;
    ChallengeFragment challengeFragment;
    ShopFragment shopFragment;
    HomeFragment homeFragment;
    TrashFragment trashFragment;
    UserFragment userFragment;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rank = (Button) findViewById(R.id.rank);
        shop = (Button) findViewById(R.id.shop);
        home = (Button) findViewById(R.id.home);
        trash = (Button) findViewById(R.id.trash);
        user = (Button) findViewById(R.id.user);
        mainontainer = (LinearLayout) findViewById(R.id.main_container);

        fragmentManager = getSupportFragmentManager();


        challengeFragment = new ChallengeFragment();
        shopFragment = new ShopFragment();
        homeFragment = new HomeFragment();
        trashFragment = new TrashFragment();
        userFragment = new UserFragment();

        ft = fragmentManager.beginTransaction(); // 프래그먼트로 들어올 때 홈 프래그먼트로 시작
        home.setBackgroundResource(R.drawable.home);
        ft.addToBackStack(null).replace(R.id.main_container, homeFragment).commit();


// 클릭으로 프래그먼트 이동
        rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //랭크 프래그먼트
                rank.setBackgroundResource(R.drawable.rank);
                shop.setBackgroundResource(R.drawable.no_shop);
                home.setBackgroundResource(R.drawable.no_home);
                trash.setBackgroundResource(R.drawable.no_trash);
                user.setBackgroundResource(R.drawable.no_user);
                ft = fragmentManager.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.main_container, challengeFragment);
                ft.commit();
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //가게 위치 프래그먼트
                shop.setBackgroundResource(R.drawable.shop);
                rank.setBackgroundResource(R.drawable.no_rank);
                home.setBackgroundResource(R.drawable.no_home);
                trash.setBackgroundResource(R.drawable.no_trash);
                user.setBackgroundResource(R.drawable.no_user);
                ft = fragmentManager.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.main_container, shopFragment);
                ft.commit();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 메인 프래그먼트
                home.setBackgroundResource(R.drawable.home);
                rank.setBackgroundResource(R.drawable.no_rank);
                shop.setBackgroundResource(R.drawable.no_shop);
                trash.setBackgroundResource(R.drawable.no_trash);
                user.setBackgroundResource(R.drawable.no_user);
                ft = fragmentManager.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.main_container, homeFragment);
                ft.commit();
            }
        });

        trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 분리수거 프래그먼트
                trash.setBackgroundResource(R.drawable.trash);
                rank.setBackgroundResource(R.drawable.no_rank);
                shop.setBackgroundResource(R.drawable.no_shop);
                home.setBackgroundResource(R.drawable.no_home);
                user.setBackgroundResource(R.drawable.no_user);
                ft = fragmentManager.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.main_container, trashFragment);
                ft.commit();
            }
        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 유저 프래그먼트
                user.setBackgroundResource(R.drawable.user);
                rank.setBackgroundResource(R.drawable.no_rank);
                shop.setBackgroundResource(R.drawable.no_shop);
                home.setBackgroundResource(R.drawable.no_home);
                trash.setBackgroundResource(R.drawable.no_trash);
                ft = fragmentManager.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.main_container, userFragment);
                ft.commit();
            }
        });
    }
}

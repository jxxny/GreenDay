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

        rank = (Button)findViewById(R.id.rank);
        shop = (Button)findViewById(R.id.shop);
        home = (Button)findViewById(R.id.home);
        trash = (Button)findViewById(R.id.trash);
        user = (Button)findViewById(R.id.user);
        mainontainer = (LinearLayout)findViewById(R.id.main_container);

        fragmentManager = getSupportFragmentManager();


        challengeFragment = new ChallengeFragment();
        shopFragment = new ShopFragment();
        homeFragment = new HomeFragment();
        trashFragment = new TrashFragment();
        userFragment = new UserFragment();

        ft = fragmentManager.beginTransaction();
        ft.addToBackStack(null).replace(R.id.main_container,homeFragment).commit();

        rank.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    rank.setBackgroundColor(Color.TRANSPARENT);
                    ft = fragmentManager.beginTransaction();
                    ft.addToBackStack(null);
                    ft.replace(R.id.main_container, challengeFragment);
                    ft.commit();
                }else{
                    rank.setBackgroundResource(R.drawable.no_rank);
                }
                return false;
            }
        });

        shop.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    shop.setBackgroundColor(Color.TRANSPARENT);
                    ft = fragmentManager.beginTransaction();
                    ft.addToBackStack(null);
                    ft.replace(R.id.main_container, shopFragment);
                    ft.commit();
                }else{
                    shop.setBackgroundResource(R.drawable.no_shop);
                }
                return false;
            }
        });

        home.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    home.setBackgroundColor(Color.TRANSPARENT);
                    ft = fragmentManager.beginTransaction();
                    ft.addToBackStack(null);
                    ft.replace(R.id.main_container, homeFragment);
                    ft.commit();
                }else{
                    home.setBackgroundResource(R.drawable.no_home);
                }
                return false;
            }
        });

        trash.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    trash.setBackgroundColor(Color.TRANSPARENT);
                    ft = fragmentManager.beginTransaction();
                    ft.addToBackStack(null);
                    ft.replace(R.id.main_container, trashFragment);
                    ft.commit();
                }else{
                    trash.setBackgroundResource(R.drawable.no_trash);
                }
                return false;
            }
        });

        user.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    user.setBackgroundColor(Color.TRANSPARENT);
                    ft = fragmentManager.beginTransaction();
                    ft.addToBackStack(null);
                    ft.replace(R.id.main_container, userFragment);
                    ft.commit();
                }else{
                    user.setBackgroundResource(R.drawable.no_user);
                }
                return false;
            }
        });

/*        rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //랭크 프래그먼트
                ft = fragmentManager.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.main_container, challengeFragment);
                ft.commit();
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //가게 위치 프래그먼트
                ft = fragmentManager.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.main_container, shopFragment);
                ft.commit();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 메인 프래그먼트
                ft = fragmentManager.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.main_container, homeFragment);
                ft.commit();
            }
        });

        trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 분리수거 프래그먼트
                ft = fragmentManager.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.main_container, trashFragment);
                ft.commit();
            }
        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 유저 프래그먼트
                ft = fragmentManager.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.main_container, userFragment);
                ft.commit();
            }
        });*/
    }

/*    @Override
    public void onBackPressed() {
        fragmentManager = getSupportFragmentManager();
        Fragment parent = fragmentManager.findFragmentById(R.id.main_container);
        if(parent != null){
            if(parent.getChildFragmentManager().getBackStackEntryCount() > 0){
                parent.getChildFragmentManager().popBackStack();
            }else{
                super.onBackPressed();
            }
        }
    }*/
}

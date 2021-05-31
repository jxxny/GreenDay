package com.example.greenday;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
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

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft = fragmentManager.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.main_container, homeFragment);
                ft.commit();
            }
        });

        trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft = fragmentManager.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.main_container, trashFragment);
                ft.commit();
            }
        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft = fragmentManager.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.main_container, userFragment);
                ft.commit();
            }
        });


    }

}

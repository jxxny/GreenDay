package com.example.greenday;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChallengeFragment extends Fragment {
    FragmentManager parenntFragmentManager;
    public ChallengeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_challenge, container, false);

        ViewPager viewPager = (ViewPager)view.findViewById(R.id.viewPager);
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        return view;
    }

    class MyPagerAdapter extends FragmentPagerAdapter{
        ArrayList<Fragment> fragments;

        public MyPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
            fragments = new ArrayList<>();
            fragments.add(new ChildChallengeFragment());
            fragments.add(new RankFragment());
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return 2;
        }
    }



}
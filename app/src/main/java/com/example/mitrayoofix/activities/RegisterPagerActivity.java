package com.example.mitrayoofix.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.mitrayoofix.R;
import com.example.mitrayoofix.fragments.RegisterPageOneFragment;
import com.example.mitrayoofix.fragments.RegisterPageTreeFragment;
import com.example.mitrayoofix.fragments.RegisterPageTwoFragment;

public class RegisterPagerActivity extends FragmentActivity {

    private static final int NUM_PAGES = 3;
    private ViewPager mPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mPager = findViewById(R.id.pager);
        pagerAdapter = new RegisterPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mPager.setAdapter(pagerAdapter);
    }

    public ViewPager getPager() {
        return mPager;
    }

    private class RegisterPagerAdapter extends FragmentStatePagerAdapter {
        public RegisterPagerAdapter(FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new RegisterPageOneFragment();
                case 1:
                    return new RegisterPageTwoFragment();
                case 2:
                    return new RegisterPageTreeFragment();
                default:
                    return new RegisterPageOneFragment();
            }
        }


        @Override
        public int getCount() {
            return NUM_PAGES;
        }


    }
}

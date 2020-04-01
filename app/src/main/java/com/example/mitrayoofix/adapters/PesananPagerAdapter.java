package com.example.mitrayoofix.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.mitrayoofix.fragments.PesananBelumSelesaiFragment;
import com.example.mitrayoofix.fragments.PesananSelesaiFragment;

public class PesananPagerAdapter extends FragmentStatePagerAdapter {

    public PesananPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new PesananBelumSelesaiFragment();
                break;
            case 1:
                fragment = new PesananSelesaiFragment();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Belum Selesai";
            case 1:
                return "Selesai";
            default:
                return "";
        }
    }
}

package com.example.mitrayoofix.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.mitrayoofix.R;
import com.example.mitrayoofix.fragments.AkunSayaFragment;
import com.example.mitrayoofix.fragments.BantuanFragment;
import com.example.mitrayoofix.fragments.InboxFragment;
import com.example.mitrayoofix.fragments.PesananFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // untuk launch pertama kali, isi view pesanan dengan fragment pesanan
        Fragment pesananFragment = new PesananFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_layout_fragment, pesananFragment)
                .commit();

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                Fragment fragment = null;
                switch (itemId) {
                    case R.id.navigation_home:
                        fragment = new PesananFragment();
                        break;
                    case R.id.navigation_inbox:
                        fragment = new InboxFragment();
                        break;
                    case R.id.navigation_help:
                        fragment = new BantuanFragment();
                        break;
                    case R.id.navigation_user:
                        fragment = new AkunSayaFragment();
                        break;

                }

                return loadFragment(fragment);
            }

            ;
        });
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_layout_fragment, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}

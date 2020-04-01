package com.example.mitrayoofix;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.mitrayoofix.fragments.AkunSayaFragment;
import com.example.mitrayoofix.fragments.BantuanFragment;
import com.example.mitrayoofix.fragments.InboxFragment;
import com.example.mitrayoofix.fragments.PesananFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        bottomNavigationView = findViewById(R.id.navigation_menu);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int itemId = item.getItemId();
//                Fragment fragment = null;
//                switch (itemId) {
//                    case R.id.navigation_pesanan:
//                        fragment = new PesananFragment();
//                        break;
//                    case R.id.navigation_inbox:
//                        fragment = new InboxFragment();
//                        break;
//                    case R.id.navigation_bantuan:
//                        fragment = new BantuanFragment();
//                        break;
//                    case R.id.navigation_akunsaya:
//                        fragment = new AkunSayaFragment();
//                        break;
//
//                }
//
//                return loadFragment(fragment);
//            }
//
//            ;
//        });
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

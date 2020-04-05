package com.example.mitrayoofix.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;

import com.example.mitrayoofix.CustomMapView;
import com.example.mitrayoofix.R;
import com.example.mitrayoofix.activities.RegisterPagerActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

public class RegisterPageOneFragment extends Fragment {

    private static final int NEXT_PAGE = 1;

    private RegisterPagerActivity activity;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_register1, container, false);

        activity = (RegisterPagerActivity) getActivity();

        Button nextButton = rootView.findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.getPager().setCurrentItem(NEXT_PAGE);
            }
        });
        return rootView;
    }


}

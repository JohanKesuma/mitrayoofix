package com.example.mitrayoofix.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mitrayoofix.R;
import com.example.mitrayoofix.activities.RegisterPagerActivity;

public class RegisterPageTwoFragment extends Fragment {
    private static final int NEXT_PAGE = 2;
    private static final int PREV_PAGE = 0;

    private Button nextButton;
    private Button prevButton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.activity_register2, container, false);

        // Next Button
        nextButton = view.findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((RegisterPagerActivity)getActivity()).getPager().setCurrentItem(NEXT_PAGE);
            }
        });

        // Prev Button
        prevButton = view.findViewById(R.id.prev_button);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((RegisterPagerActivity)getActivity()).getPager().setCurrentItem(PREV_PAGE);
            }
        });

        return view;
    }


}

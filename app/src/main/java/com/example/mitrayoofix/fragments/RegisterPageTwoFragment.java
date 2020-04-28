package com.example.mitrayoofix.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mitrayoofix.CustomMapView;
import com.example.mitrayoofix.R;
import com.example.mitrayoofix.activities.RegisterPagerActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class RegisterPageTwoFragment extends Fragment {
    private static final int NEXT_PAGE = 2;
    private static final int PREV_PAGE = 0;

    private TextInputEditText tgl_lahir;
    private DatePickerDialog dpd;
    private Calendar c;
    private Button nextButton;
    private Button prevButton;
    private CustomMapView mapView;
    private GoogleMap gmap;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.activity_register2, container, false);

        // Next Button
        nextButton = view.findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((RegisterPagerActivity) getActivity()).getPager().setCurrentItem(NEXT_PAGE);
            }
        });

        // Prev Button
        prevButton = view.findViewById(R.id.prev_button);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((RegisterPagerActivity) getActivity()).getPager().setCurrentItem(PREV_PAGE);
            }
        });

        tgl_lahir = view.findViewById(R.id.tgl_lahir);
        tgl_lahir.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    showDatePicker();
                }
            }
        });
        tgl_lahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        final int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);

        dpd = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                tgl_lahir.setText(mDay + " " + (mMonth + 1) + " " + mYear);
            }
        }, day, month, year);

        String[] data = {"Laki-Laki", "Perempuan"};

        ArrayAdapter jenisKelaminadapter = new ArrayAdapter<String>(getContext(), R.layout.dropdown_menu_popup_item, data);
        jenisKelaminadapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        AutoCompleteTextView editTextFilledExposedDropdown =
                view.findViewById(R.id.filled_exposed_dropdown);
        editTextFilledExposedDropdown.setAdapter(jenisKelaminadapter);

        editTextFilledExposedDropdown.setKeyListener(null);

//        Spinner jenisKelaminSpinner = view.findViewById(R.id.spinner);
//        jenisKelaminSpinner.setAdapter(jenisKelaminadapter);
//        jenisKelaminSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getContext(), parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        mapView = view.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                gmap = googleMap;
                gmap.setMinZoomPreference(12);
                LatLng ny = new LatLng(40.7143528, -74.0059731);
                gmap.moveCamera(CameraUpdateFactory.newLatLng(ny));
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }


    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    private void showDatePicker() {
        dpd.show();
    }


}

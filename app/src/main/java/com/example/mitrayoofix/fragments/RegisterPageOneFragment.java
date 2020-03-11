package com.example.mitrayoofix.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

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

import java.util.Calendar;

public class RegisterPageOneFragment extends Fragment {

    private static final int NEXT_PAGE = 1;

    AppCompatEditText tgl_lahir;
    Calendar c;
    DatePickerDialog dpd;
    Button nextButton;

    private RegisterPagerActivity activity;

    private CustomMapView mapView;
    private GoogleMap gmap;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_register1, container, false);

        activity = (RegisterPagerActivity) getActivity();

        nextButton = rootView.findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.getPager().setCurrentItem(NEXT_PAGE);
            }
        });

        tgl_lahir = (AppCompatEditText) rootView.findViewById(R.id.tgl_lahir);
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
        String[] jenisService = {"Service Ac",
                "Perledengan",
                "Kebersihan",
                "Mekanik Elektrik",
                "Pengecatan",
                "Pembasmi Hama",
                "Elektronik",
                "Laundry"
        };

        ArrayAdapter jenisKelaminadapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_item_selected, data);
        jenisKelaminadapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        ArrayAdapter jenisKServiceadapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_item_selected, jenisService);
        jenisKServiceadapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        Spinner jenisKelaminSpinner = rootView.findViewById(R.id.spinner);
        jenisKelaminSpinner.setAdapter(jenisKelaminadapter);
        jenisKelaminSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner jenisServiceSpinner = rootView.findViewById(R.id.spinner2);
        jenisServiceSpinner.setAdapter(jenisKServiceadapter);
        jenisServiceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        mapView = rootView.findViewById(R.id.mapView);
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
        return rootView;
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

package com.example.mitrayoofix.activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.mitrayoofix.CustomMapView;
import com.example.mitrayoofix.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    AppCompatEditText tgl_lahir;
    Calendar c;
    DatePickerDialog dpd;

    private CustomMapView mapView;
    private GoogleMap gmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);


        tgl_lahir = (AppCompatEditText) findViewById(R.id.tgl_lahir);
        tgl_lahir.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    showDatePicker();
                }
            }
        });

        c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        final int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);

        dpd = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
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

        ArrayAdapter jenisKelaminadapter = new ArrayAdapter<String>(this, R.layout.spinner_item_selected, data);
        jenisKelaminadapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        ArrayAdapter jenisKServiceadapter = new ArrayAdapter<String>(this, R.layout.spinner_item_selected, jenisService);
        jenisKServiceadapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

//        Spinner jenisKelaminSpinner = findViewById(R.id.spinner);
//        jenisKelaminSpinner.setAdapter(jenisKelaminadapter);
//        jenisKelaminSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(RegisterActivity.this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        mapView = findViewById(R.id.mapView);
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

    public void onPhotoProfileClicked(View view) {
        Toast.makeText(this, "Photo Profile Clicked", Toast.LENGTH_SHORT).show();
    }

    public void onTanggalLahirClicked(View view) {
        showDatePicker();
    }

    private void showDatePicker() {
        dpd.show();
    }

    public void onBackButtonClicked(View view) {

    }
}

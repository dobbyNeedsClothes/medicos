package com.yash.medicos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yash.medicos.fragments.DoctorsPrescription;
import com.yash.medicos.fragments.HomePage;
import com.yash.medicos.fragments.PatientInfo;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    FrameLayout frameLayout;
    HomePage homePage = new HomePage();
    DoctorsPrescription doctorsPrescription = new DoctorsPrescription();
    PatientInfo patientInfo = new PatientInfo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottomNav);
        frameLayout = findViewById(R.id.frameLayout);

        bottomNav.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
        bottomNav.setSelectedItemId(R.id.homePage);


    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.homePage:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout , homePage).commit();
                return true;

            case R.id.doctorPrescription:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout , doctorsPrescription).commit();
                return true;

            case R.id.patientInfo:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout , patientInfo).commit();
                return true;
        }
        return false;
    }

}
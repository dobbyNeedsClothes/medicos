package com.yash.medicos.fragments;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import com.yash.medicos.R;

import java.util.Calendar;

public class HomePage extends Fragment implements DatePickerDialog.OnDateSetListener {

// getView() works after onCreate and onViewCreated = it canon work inside them
    public HomePage() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PatientInfo patientInfo = new PatientInfo();
        view.findViewById(R.id.showTheDatePicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });



        view.findViewById(R.id.sendData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDataToWhatsapp(patientInfo.dataToSend("Yash Singh" , "12/12/2021" ,
                        "Take a paracetamol"));
            }
        });
    }

    private void sendDataToWhatsapp(String message) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT , message);
        sendIntent.setType("text/plain");
        sendIntent.setPackage("com.whatsapp");
        if (sendIntent.resolveActivity(getActivity().getPackageManager()) != null){
            startActivity(sendIntent);
        }
    }

    private void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext() , this , Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH) , Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override // this will get triggered when you set a date from the calender and will be used to set it in the textView
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = "date/month/year :" + dayOfMonth + "/" + month + "/" + year;
        TextView showDateHere = view.findViewById(R.id.showDateHere);
//        showDateHere.setText(date);

    }
}
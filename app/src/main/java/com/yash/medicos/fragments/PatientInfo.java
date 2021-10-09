package com.yash.medicos.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.yash.medicos.R;

public class PatientInfo extends Fragment {

    public PatientInfo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_patient_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText patientName = view.findViewById(R.id.patientName);
        String nameOfThePatient = patientName.getText().toString();

        EditText nextVisitingDate = view.findViewById(R.id.nextVisitDate);
        String visitingDate = nextVisitingDate.getText().toString();

        EditText noteFromDoctor = view.findViewById(R.id.noteFromTheDoctor);
        String doctorNote = noteFromDoctor.getText().toString();

        dataToSend(nameOfThePatient , visitingDate , doctorNote);
    }

    public String dataToSend(String nameOfThePatient, String visitingDate, String doctorNote) {
        String messageSend = "Hello" + nameOfThePatient + "your next visiting date is " + visitingDate + "and here are some instructions"
                + doctorNote ;
        return messageSend;
    }
}
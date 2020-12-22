package com.itb.gestitb.Fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.itb.gestitb.Models.StudentMissingModel;
import com.itb.gestitb.R;

import java.util.Objects;

public class MissedAttendanceFragment extends Fragment {

    EditText studentName;
    Spinner spinnerSubjects;
    CheckBox checkBoxisJustified;
    Button buttonDateHour;
    Button buttonAddMissed;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.missed_attendance_fragment, container, false);
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        studentName = view.findViewById(R.id.student_name_editText);
        spinnerSubjects = view.findViewById(R.id.spinner_subjects);
        checkBoxisJustified = view.findViewById(R.id.checkBox_isJustified);
        buttonDateHour = view.findViewById(R.id.button_date_hour);
        buttonAddMissed = view.findViewById(R.id.button_add_missed);

        StudentMissingModel studentMissingModel = (StudentMissingModel) requireArguments().get("missedAttendence");

        boolean flag = true;
        for (int i = 0; i < 8 && flag; i++) {
            spinnerSubjects.setSelection(i);
            if (spinnerSubjects.getSelectedItem().equals(Objects.requireNonNull(studentMissingModel).getSubject())) flag = false;
        }

        studentName.setText(Objects.requireNonNull(studentMissingModel).getName());
        if (studentMissingModel.isJustified()) checkBoxisJustified.setChecked(true);
        buttonDateHour.setText(studentMissingModel.getDate().toString());

        buttonAddMissed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (studentName.getText().length() != 0) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(view.getContext());
                    alertDialog.setTitle("Missed attendende created");
                    if (checkBoxisJustified.isChecked())
                        alertDialog.setMessage("The student " + studentName.getText() + " has missed " + spinnerSubjects.getSelectedItem() + " on " + buttonDateHour.getText() + " whit justification");
                    else
                        alertDialog.setMessage("The student " + studentName.getText() + " has missed " + spinnerSubjects.getSelectedItem() + " on " + buttonDateHour.getText() + " whitout justification");
                    alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            NavDirections listToDetailDirections = MissedAttendanceFragmentDirections.actionMissedAttendanceFragmentToMissedAttendanceListFragment();
                            Navigation.findNavController(v).navigate(listToDetailDirections);
                        }
                    });
                    alertDialog.create().show();
                }
            }
        });
    }
}





package com.itb.gestitb.Models;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class StudentMissingViewModel extends ViewModel {

    public List <StudentMissingModel> studentMissingModelList = new ArrayList<>();

    public StudentMissingViewModel(){
        for (int i = 1; i <= 100; i++){
            String[] subjects = {"M06-Accés cross_icon_foreground dades",
                    "M07-Desenvolupament d’interfícies",
                    "M08-Programació multimèdia i dispositius mòbils",
                    "M09-Programació de serveis i processos",
                    "M14-Formació en el centre de treball",
                    "M15-Game design",
                    "M16-Disseny 2D i 3D",
                    "M17-Programació de videojocs 2D i 3D"};

            studentMissingModelList.add(new StudentMissingModel("Student #" + i,subjects[(int) (Math.random() * subjects.length)], (i%2==0)));
        }
    }
}

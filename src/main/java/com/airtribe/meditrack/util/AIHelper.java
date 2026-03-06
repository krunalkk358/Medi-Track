package com.airtribe.meditrack.util;

import com.airtribe.meditrack.enums.Specialization;

public class AIHelper {

    public static Specialization recommendDoctor(String symptom) {

        symptom = symptom.toLowerCase();

        if(symptom.contains("heart")) {
            return Specialization.CARDIOLOGY;
        }

        if(symptom.contains("skin")) {
            return Specialization.DERMATOLOGY;
        }

        if(symptom.contains("bone")) {
            return Specialization.ORTHOPEDIC;
        }

        return Specialization.GENERAL_PHYSICIAN;
    }

}
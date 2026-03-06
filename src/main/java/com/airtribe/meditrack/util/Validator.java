package com.airtribe.meditrack.util;

import com.airtribe.meditrack.exception.InvalidDataException;

public class Validator {

    public static void validateName(String name) throws InvalidDataException {

        if(name == null || name.trim().isEmpty()) {
            throw new InvalidDataException("Name cannot be empty");
        }

    }

    public static void validateAge(int age) throws InvalidDataException {

        if(age <= 0 || age > 120) {
            throw new InvalidDataException("Invalid age");
        }

    }

}
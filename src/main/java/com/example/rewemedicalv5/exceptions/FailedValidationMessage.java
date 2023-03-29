package com.example.rewemedicalv5.exceptions;

public class FailedValidationMessage {

    public static final String INVALID_ID = "ID must be greater than 0";
    public static final String MANDATORY_ISGP = "Mandatory isGP field";
    public static final String INVALID_BIRTHDAY = "Invalid birthday date";
    public static final String INVALID_BIRTHDAY_DATE = "Birthday has to be in the past";
    public static final String INVALID_UID = "Invalid UID";
    public static final String INVALID_UID_LENGTH = "Invalid UID length, min = 3";
    public static final String INVALID_SPECIALTY_NAME_LENGTH = "Invalid specialty length, min = 3";
    public static final String INVALID_SPECIALTY_NAME = "Invalid specialty";
    public static final String INVALID_DOCTOR_NAME = "Invalid doctor name";
    public static final String INVALID_PATIENT_NAME = "Invalid patient name";
    public static final String INVALID_DIAGNOSIS_CODE_LENGTH = "Invalid diagnosis code length, min = 3";
    public static final String INVALID_DIAGNOSIS_DESCRIPTION = "Invalid diagnosis description";
}

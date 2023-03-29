package com.example.rewemedicalv5.exceptions;

public class PatientNotFound extends EntityNotFound{
    public PatientNotFound(String uid) {
        super("Patient with UID " + uid + " not found");
    }
}

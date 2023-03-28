package com.example.rewemedicalv5.exceptions;

public class PatientNotFound extends EntityNotFound{
    public PatientNotFound(String upin) {
        super("Patient with Upin " + upin + " not found");
    }
    public PatientNotFound(Long id) {
        super("Patient with Id " + id + " not found");
    }
}

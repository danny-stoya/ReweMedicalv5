package com.example.rewemedicalv5.exceptions;

public class DiagnosisNotFound extends EntityNotFound{
    public DiagnosisNotFound(String code) {
        super("Diagnosis " + code + " not found");
    }
}

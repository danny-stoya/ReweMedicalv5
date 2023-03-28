package com.example.rewemedicalv5.exceptions;

public class SpecialtyNotFound extends EntityNotFound{
    public SpecialtyNotFound(String name) {
        super("Specialty " + name + " not found");
    }
}

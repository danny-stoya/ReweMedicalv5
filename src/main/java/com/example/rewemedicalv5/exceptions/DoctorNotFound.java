package com.example.rewemedicalv5.exceptions;

public class DoctorNotFound extends EntityNotFound{
    public DoctorNotFound(String uid) {
        super("Doctor uid " + uid + " not found");
    }
//    public DoctorNotFound(Long id) {
//        super("Doctor with Id " + id + " not found");
//    }
}

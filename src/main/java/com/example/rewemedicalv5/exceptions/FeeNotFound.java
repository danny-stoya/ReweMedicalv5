package com.example.rewemedicalv5.exceptions;

public class FeeNotFound extends EntityNotFound{
    public FeeNotFound(Long id) {
        super("Fee with ID " + id + " not found");
    }
}

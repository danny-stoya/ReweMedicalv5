package com.example.rewemedicalv5.exceptions;


public class VisitNotFound extends EntityNotFound{
    public VisitNotFound(Long id) {
        super("Visit with ID " + id + " not found");
    }
}

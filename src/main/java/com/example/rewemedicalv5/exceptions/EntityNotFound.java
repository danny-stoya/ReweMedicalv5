package com.example.rewemedicalv5.exceptions;


public class EntityNotFound extends RuntimeException{
    public EntityNotFound(String message) {
       super(message);
    }
}

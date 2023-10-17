package com.test.demo.services.exceptionsTypes;

public class ResourcesNotFound extends RuntimeException{

    public ResourcesNotFound(String message){
        super(message);
    }
}

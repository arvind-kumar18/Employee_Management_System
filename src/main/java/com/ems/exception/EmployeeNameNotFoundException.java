package com.ems.exception;

public class EmployeeNameNotFoundException extends RuntimeException{

    public EmployeeNameNotFoundException(String msg){
        super(msg);
    }
}

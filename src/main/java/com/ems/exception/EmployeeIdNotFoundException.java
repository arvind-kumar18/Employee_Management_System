package com.ems.exception;

public class EmployeeIdNotFoundException extends RuntimeException{

    public EmployeeIdNotFoundException(String msg){
        super(msg);
    }
}

package com.example.noteappllication.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue){
        super(String.format("%s not found with %s: '%s",resourceName,fieldName,fieldValue));
        System.out.println("ResourceNotFound class constructor called");
        System.out.println("Change made by Kamal");
        System.out.println("Userprofile added....");
        System.out.println("Timeline not found!");
        System.out.println("Change1");
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName(){
        return resourceName;
    }

    public String getFieldName(){
        return fieldName;
    }
    public Object getFieldValue(){
        return fieldValue;
    }
}

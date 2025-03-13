package com.zup.ecommerce.exceptions;


public class ExistingEntityException extends IllegalArgumentException{
    public ExistingEntityException(String message){
        super(message);
    }
}

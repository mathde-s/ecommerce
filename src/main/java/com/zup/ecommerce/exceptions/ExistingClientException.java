package com.zup.ecommerce.exceptions;


public class ExistingClientException extends IllegalArgumentException{
    public ExistingClientException(String message){
        super(message);
    }
}

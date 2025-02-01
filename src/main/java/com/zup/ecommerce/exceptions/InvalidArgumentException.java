package com.zup.ecommerce.exceptions;

public class InvalidArgumentException extends IllegalArgumentException{
    public InvalidArgumentException(String message){
        super(message);
    }
}

package com.zup.ecommerce.exceptions;

public class NullArgumentException extends RuntimeException {
    public NullArgumentException(String message) {
        super(message);
    }
}

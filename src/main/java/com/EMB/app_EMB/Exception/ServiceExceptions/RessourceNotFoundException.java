package com.EMB.app_EMB.Exception.ServiceExceptions;

public class RessourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 123456789L;

    public RessourceNotFoundException(String message) {
        super(message);
    }
}

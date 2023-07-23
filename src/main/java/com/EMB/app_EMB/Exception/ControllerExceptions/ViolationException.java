package com.EMB.app_EMB.Exception.ControllerExceptions;

public class ViolationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ViolationException(String message) {
        super(message);
    }
}
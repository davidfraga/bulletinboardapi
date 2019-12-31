package com.warning.service.exception;

public class ModelNotFoundException extends RuntimeException {
	public ModelNotFoundException(Integer id) {
		super("Could not find model " + id);
	}

}



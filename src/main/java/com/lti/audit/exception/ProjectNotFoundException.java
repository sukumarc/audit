package com.lti.audit.exception;

public class ProjectNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ProjectNotFoundException(String message) {
		super(message);
	}

}

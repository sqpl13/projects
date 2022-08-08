package com.sqpl.app.upload;

public class StorageException extends RuntimeException {

	private static final long serialVersionUID = -4344018114366932836L;

	public StorageException(String message) {
		super(message);
	}

	public StorageException(String message, Throwable cause) {
		super(message, cause);
	}
}

package com.ljx.storage;

public class StorageFileNotFoundException extends StorageException {

	private static final long serialVersionUID = 1L;

	public StorageFileNotFoundException(String message) {
		super(message);
	}
	
	public StorageFileNotFoundException(String mssage, Throwable cause) {
		super(mssage, cause);
	}
}

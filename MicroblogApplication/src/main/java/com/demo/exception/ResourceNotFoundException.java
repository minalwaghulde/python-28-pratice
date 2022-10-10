package com.demo.exception;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{
	
	String resourceName;
	String fieldName;
	long fieldValue;
	public ResourceNotFoundException(String resourceName, String fieldName, long filedValue) {
		super(String.format("%s not found with %s:%l ", resourceName,fieldName));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue=filedValue;
	}
	
	

}

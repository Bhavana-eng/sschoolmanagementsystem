package com.school.sba.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserNotFoundException extends RuntimeException{
	private String message;
//	public UserNotFoundException(String message){
//		this.message=message;
//	}
//	@Override 
//	public String getMessage() {
//		return message;
//	}
}




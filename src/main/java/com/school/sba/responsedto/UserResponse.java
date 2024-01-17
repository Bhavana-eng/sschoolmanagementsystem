package com.school.sba.responsedto;

import com.school.sba.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
	private int userId;
	private String userName;
	private String email;
	private String userFirstName;
	private String userLastName;
	private long contactNo;
	private UserRole userRole;



}

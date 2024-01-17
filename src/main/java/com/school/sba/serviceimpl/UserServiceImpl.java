package com.school.sba.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.school.sba.entity.User;
import com.school.sba.enums.UserRole;
import com.school.sba.exception.AdminAlreadyPresentException;
import com.school.sba.repository.UserRepo;
import com.school.sba.requestdto.UserRequest;
import com.school.sba.responsedto.UserResponse;
import com.school.sba.service.UserService;
import com.school.sba.util.ResponseStructure;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ResponseStructure<UserResponse> responseStructure;

	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> addUser(UserRequest userRequest) {
if(userRequest.getUserRole()==UserRole.ADMIN && userRepo.existsByUserRole(UserRole.ADMIN))
{
	throw new AdminAlreadyPresentException("admin already exist");
}
		
		User user=userRepo.save(mapToUser(userRequest));
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("data added succesfully");
		responseStructure.setData(mapToUserResponse(user));
		return new ResponseEntity<ResponseStructure<UserResponse>>(responseStructure,HttpStatus.CREATED) ;
	}

	private User mapToUser(UserRequest request) {
		return User.builder()
				.userName(request.getUserName())
				.email(request.getEmail())
				.password(request.getPassword())
				.userFirstName(request.getUserFirstName())
				.userLastName(request.getUserLastName())
				.userRole(request.getUserRole())
				.contactNo(request.getContactNo())
				.build();	}
	private UserResponse mapToUserResponse(User user) {
		return UserResponse.builder()
				.userId(user.getUserId())
				.userName(user.getUserName())
				.email(user.getEmail())
				.userFirstName(user.getUserFirstName())
				.userLastName(user.getUserLastName())
				.userRole(user.getUserRole())
				.contactNo(user.getContactNo())
				.build();	}
	
	

//	public boolean registerAdmin(String userName,String password) {
//		if(!isExistingAdmin()) {
//			insertAdmin(userName,password);
//			return true;
//		}
//		else {
//			throw new AdminAlreadyPresentException("admin already exist");
//		}
//	}
//
//	private void insertAdmin(String userName, String password) {
//
//
//	}
//
//
//
//

//	private boolean isExistingAdmin() {
//		if()
//
//		return false;
//	}
}

//@Override
//public ResponseEntity<ResponseStructure<UserResponse>> getUserById(int userId) {
//	User fetch=userRepo.findById(userId).orElseThrow(()->new UserNotFoundException("userid not exist"));;
//	responseStructure.setStatus(HttpStatus.FOUND.value());
//	responseStructure.setMessage("user fetch succesfully");
//	responseStructure.setData(mapToUserResponse(fetch));
//	return  new ResponseEntity<ResponseStructure<UserResponse>>(responseStructure,HttpStatus.FOUND);
//
//}





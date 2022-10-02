package com.hasee.jwt.service;

import com.hasee.jwt.constants.MyConstants;
import com.hasee.jwt.dto.ResponseDto;
import com.hasee.jwt.dto.UserView;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService
{
	@Override
	public ResponseDto<UserView> loginUser( String email, String password, MyConstants.RoleType userRole )
	{
		// TODO: Login Logic
		return null;
	}
}

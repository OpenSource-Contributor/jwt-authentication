package com.hasee.jwt.service;

import com.hasee.jwt.constants.MyConstants;
import com.hasee.jwt.dto.ResponseDto;
import com.hasee.jwt.dto.UserView;

public interface IUserService
{
	ResponseDto<UserView> loginUser( String email, String password, MyConstants.UserRole userRole );

}

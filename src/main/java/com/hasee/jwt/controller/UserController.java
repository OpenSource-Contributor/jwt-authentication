package com.hasee.jwt.controller;

import com.hasee.jwt.constants.MyConstants;
import com.hasee.jwt.dto.ResponseDto;
import com.hasee.jwt.dto.UserView;
import com.hasee.jwt.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements IUserController
{
	@Autowired
	private Environment environment;

	@Autowired
	private IUserService userService;

	@Override
	public ResponseEntity<ResponseDto<UserView>> login( String version, String email, String password, MyConstants.UserRole userRole )
	{
		if ( version == null || version.isEmpty() )
		{
			return ResponseEntity.badRequest().body( new ResponseDto<>( -1, "Version is Missing" ) );
		}
		return ResponseEntity.ok( userService.loginUser( email, password, userRole ) );
	}
}

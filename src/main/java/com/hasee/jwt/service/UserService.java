package com.hasee.jwt.service;

import com.hasee.jwt.constants.MyConstants;
import com.hasee.jwt.dto.ResponseDto;
import com.hasee.jwt.dto.UserView;
import com.hasee.jwt.jwt.JwtUtils;
import com.hasee.jwt.model.User;
import com.hasee.jwt.repository.IUserRepository;
import com.hasee.jwt.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService implements IUserService
{
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private IUserRepository userRepository;

	@Override
	public ResponseDto<UserView> loginUser( String email, String password, MyConstants.UserRole userRole )
	{
		if ( Utility.isNull( email ) )
		{
			return new ResponseDto<>( -1, "Email is missing" );
		}
		if ( Utility.isNull( password ) )
		{
			return new ResponseDto<>( -1, "Password is missing" );
		}
		if ( userRole == null )
		{
			return new ResponseDto<>( -1, "User Role is missing" );
		}

		User user = userRepository.findByEmail( email ).orElse( null );
		if ( user == null )
		{
			return new ResponseDto<>( -1, "User not found" );
		}

		String jwt;
		try
		{
			Authentication authentication = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken( email, password ) );
			SecurityContextHolder.getContext().setAuthentication( authentication );
			jwt = jwtUtils.generateJwtToken( authentication );
			user.setLoginToken( jwt );
			UserView userView = user.getUserView();
			return new ResponseDto<>( 1, userView, "Login Success" );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
			return new ResponseDto<>( -1, "Login Failed" );
		}
	}
}

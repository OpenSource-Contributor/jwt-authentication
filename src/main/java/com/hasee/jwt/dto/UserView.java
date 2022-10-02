package com.hasee.jwt.dto;

import java.io.Serializable;
import java.time.LocalDate;
public class UserView implements Serializable
{
	private long userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate dob;
	private String accessToken;

	private String loginToken;

	public long getUserId()
	{
		return userId;
	}

	public UserView setUserId( long userId )
	{
		this.userId = userId;
		return this;
	}

	public String getUserName()
	{
		return userName;
	}

	public UserView setUserName( String userName )
	{
		this.userName = userName;
		return this;

	}

	public String getFirstName()
	{
		return firstName;
	}

	public UserView setFirstName( String firstName )
	{
		this.firstName = firstName;
		return this;

	}
	public String getLastName()
	{
		return lastName;
	}

	public UserView setLastName( String lastName )
	{
		this.lastName = lastName;
		return this;

	}

	public String getEmail()
	{
		return email;
	}

	public UserView setEmail( String email )
	{
		this.email = email;
		return this;

	}

	public LocalDate getDob()
	{
		return dob;
	}

	public UserView setDob( LocalDate dob )
	{
		this.dob = dob;
		return this;

	}

	public String getAccessToken()
	{
		return accessToken;
	}

	public void setAccessToken( String accessToken )
	{
		this.accessToken = accessToken;
	}

	public String getLoginToken()
	{
		return loginToken;
	}

	public UserView setLoginToken( String loginToken )
	{
		this.loginToken = loginToken;
		return this;
	}
}

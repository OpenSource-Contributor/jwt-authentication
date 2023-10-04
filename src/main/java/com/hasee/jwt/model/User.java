package com.hasee.jwt.model;

import com.hasee.jwt.constants.MyConstants;
import com.hasee.jwt.dto.UserView;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "USER", uniqueConstraints = { @UniqueConstraint(columnNames = "username"), @UniqueConstraint(columnNames = "email") })
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "USERNAME", length = 20, nullable = false)
	private String username;

	@Column(name = "FIRST_NAME", length = 50)
	private String firstName;

	@Column(name = "LAST_NAME", length = 50)
	private String lastName;

	@Column(name = "DOB")
	private LocalDate dob;

	@Column(name = "EMAIL", length = 50, nullable = false)
	private String email;

	@Column(name = "PASSWORD", length = 20, nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name = "ROLE", length = 20)
	private MyConstants.UserRole role;

	@Transient
	private String loginToken;

	public User()
	{
	}

	public User( String username, String email, String password )
	{
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Long getId()
	{
		return id;
	}

	public void setId( Long id )
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername( String username )
	{
		this.username = username;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail( String email )
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword( String password )
	{
		this.password = password;
	}

	public MyConstants.UserRole getRole()
	{
		return role;
	}

	public void setRole( MyConstants.UserRole role )
	{
		this.role = role;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName( String firstName )
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName( String lastName )
	{
		this.lastName = lastName;
	}

	public LocalDate getDob()
	{
		return dob;
	}

	public void setDob( LocalDate dob )
	{
		this.dob = dob;
	}

	public String getLoginToken()
	{
		return loginToken;
	}

	public void setLoginToken( String loginToken )
	{
		this.loginToken = loginToken;
	}

	public UserView getUserView()
	{
		UserView userView = new UserView();
		return userView.setUserId( this.id ).
				setUserName( this.username ).
				setFirstName( this.firstName ).
				setLastName( this.lastName ).
				setEmail( this.email ).
				setDob( this.dob ).
				setLoginToken( this.loginToken );
	}
}

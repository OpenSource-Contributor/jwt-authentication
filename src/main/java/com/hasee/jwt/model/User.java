package com.hasee.jwt.model;

import com.hasee.jwt.constants.MyConstants;

import javax.persistence.*;

@Entity
@Table(name = "USER", uniqueConstraints = { @UniqueConstraint(columnNames = "username"), @UniqueConstraint(columnNames = "email") })
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "USERNAME", length = 20, nullable = false)
	private String username;

	@Column(name = "EMAIL", length = 50, nullable = false)
	private String email;

	@Column(name = "PASSWORD", length = 20, nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name = "ROLE", length = 20)
	private MyConstants.RoleType role;

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

	public MyConstants.RoleType getRole()
	{
		return role;
	}

	public void setRole( MyConstants.RoleType role )
	{
		this.role = role;
	}
}

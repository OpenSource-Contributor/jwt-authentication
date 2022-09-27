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
}

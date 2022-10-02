package com.hasee.jwt.security;

import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

/**
 * Copyright (c) 2022. scicom.com.my - All Rights Reserved.
 * Created by amarathunga.h on 8/18/22, 10:53 AM.
 */
public class CustomGrantedAuthority implements GrantedAuthority
{
	private final String id;
	private final String role;

	public CustomGrantedAuthority( String id, String role )
	{
		this.role = role;
		this.id = id;
	}

	@Override
	public String getAuthority()
	{
		return id + "-" + role;
	}

	@Override
	public boolean equals( Object o )
	{
		if ( this == o )
			return true;
		if ( !( o instanceof CustomGrantedAuthority ) )
			return false;
		CustomGrantedAuthority that = ( CustomGrantedAuthority ) o;
		return Objects.equals( id, that.id ) && Objects.equals( role, that.role );
	}

	@Override
	public int hashCode()
	{
		return Objects.hash( id, role );
	}

	@Override
	public String toString()
	{
		return "CustomGrantedAuthority{" + "id='" + id + '\'' + ", role='" + role + '\'' + '}';
	}
}

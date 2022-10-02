package com.hasee.jwt.dto;

import java.io.Serializable;
public class ResponseDto<T> implements Serializable
{
	private int status;
	private T data;
	private String message;

	public ResponseDto( int status, String message )
	{
		this.status = status;
		this.message = message;
	}

	public ResponseDto( int status, T data, String message )
	{
		this.status = status;
		this.data = data;
		this.message = message;
	}

	public ResponseDto()
	{
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus( int status )
	{
		this.status = status;
	}

	public T getData()
	{
		return data;
	}

	public void setData( T data )
	{
		this.data = data;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage( String message )
	{
		this.message = message;
	}
}
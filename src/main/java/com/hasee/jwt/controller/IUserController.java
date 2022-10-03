package com.hasee.jwt.controller;

import com.hasee.jwt.constants.MyConstants;
import com.hasee.jwt.dto.ResponseDto;
import com.hasee.jwt.dto.UserView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("users")
@CrossOrigin(origins = { "*" })
public interface IUserController
{
	@RequestMapping(method = RequestMethod.POST, path = "/v{version}/signin", produces = "application/json")
	ResponseEntity<ResponseDto<UserView>> login( @PathVariable String version, @RequestHeader String email, @RequestHeader String password, @RequestParam(required = false) MyConstants.RoleType userRole );
}

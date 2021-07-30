package com.epam.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.user.exception.ServiceException;
import com.epam.user.model.User;
import com.epam.user.services.UserService;
import com.epam.user.utils.API_JSONInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/users")
@Api(value = "User Registration")
public class UserController {

	@Autowired
	private UserService userService;

	@ApiResponses(value = { @ApiResponse(code = 200, message = "User registered Successfully"),
			@ApiResponse(code = 401, message = "You are not authorized to registered the user"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 400, message = "Bad Request") })
	@ApiOperation(value = "Register User", notes=API_JSONInput.API_USER_CREATE)
	@PostMapping()
	public User createUserDetail(@RequestBody User user) throws ServiceException {

		return userService.saveUserDetail(user);
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated User details"),
			@ApiResponse(code = 401, message = "You are not authorized to updated User"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 400, message = "Bad Request") })
	@ApiOperation(value = "Update User Detail", notes= API_JSONInput.API_USER_CREATE)
	@PutMapping(value = "/{userId}")
	public User updateUser(@PathVariable("userId") Long userId, @RequestBody User user) throws ServiceException, Exception {

		user.setId(userId);
		return userService.updateUser(user);
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "User registered Successfully"),
			@ApiResponse(code = 401, message = "You are not authorized to registered the user"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 400, message = "Bad Request") })
	@ApiOperation(value = "Get user detail")
	@GetMapping("/{userId}")
	public User getUserDetail(@PathVariable("userId") Long userId) throws ServiceException {

		return userService.getUserDetailById(userId);
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully delete user detail(s)"),
			@ApiResponse(code = 401, message = "You are not authorized to delete user details"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 400, message = "Bad Request") })
	@ApiOperation(value = "delete user(s) profile")
	@DeleteMapping("/{userId}")
	public void deleteUsers(@PathVariable("userId") Long userId) throws ServiceException {

		userService.deleteUsers(userId);
	}
}

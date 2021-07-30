package com.epam.user.services;

import com.epam.user.exception.ServiceException;
import com.epam.user.model.User;

public interface UserService {

	User saveUserDetail(User user)  throws ServiceException;

	User getUserDetailById(Long userId)  throws ServiceException;

	User updateUser(User user)  throws ServiceException, Exception;

	void deleteUsers(Long userId) throws ServiceException;

}

package com.epam.user.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.user.exception.ServiceException;
import com.epam.user.model.User;
import com.epam.user.repositories.UserRepository;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

//	@Override
	public User saveUserDetail(User user) {
		return userRepository.save(user);
	}

//	@Override
	public User updateUser(User user) throws Exception {

		User userId = userRepository.getOne(user.getId());
		if (userId != null) {
			return userRepository.saveAndFlush(user);
		}
		else {
			throw new Exception("No record found with user Id : " +user.getId());
		}
	}

//	@Override
	public User getUserDetailById(Long userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new EntityNotFoundException("No record found with this user Id : " + userId));
	}

	@Override
	public void deleteUsers(Long userId) throws ServiceException {
		userRepository.deleteById(userId);
	}
}
package com.sendotp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sendotp.dao.UserDao;
import com.sendotp.entities.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao userDao;

	@Override
	public User sendOtp(User user) {
		
		User u = new User(user.getUcid(), user.getMob_no(), user.getExpire_time());
		return this.userDao.save(u);
	}
	
}

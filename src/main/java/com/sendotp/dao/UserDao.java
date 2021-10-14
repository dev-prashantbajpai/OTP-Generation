package com.sendotp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sendotp.entities.User;

public interface UserDao extends JpaRepository<User, Long> {

}

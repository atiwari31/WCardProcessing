package com.card.processing.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.card.processing.dto.UserPrincipal;
import com.card.processing.model.UserEntity;
import com.card.processing.repository.UserRepository;

@Service
@Transactional
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	public List<UserEntity> getAllUsers() {
		List<UserEntity> userList = userRepository.findAllUserEntityActiveTrue();

		if (userList.size() > 0) {
			return userList;

		} else {
			return new ArrayList<UserEntity>();
		}
	}

	public void addUser(UserEntity userEntity) {
		userRepository.save(userEntity);

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByusername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserPrincipal(user);
	}

	public UserEntity getUserByUsername(String username) {
		UserEntity user = userRepository.findByusername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return user;
	}

	public void deleteUserById(Long Id) {
		userRepository.updateUser(Id);
	}

	public int isUserExist(String userName) {
		return userRepository.isUserExist(userName);
	}
}

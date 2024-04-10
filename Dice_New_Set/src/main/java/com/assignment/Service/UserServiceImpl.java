package com.assignment.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.assignment.Model.User;
import com.assignment.Repository.UserRepository;

public class UserServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> opt = userRepository.findByEmail(username);
		
		if(opt.isPresent()) {
			return new UserImpl(opt.get());
		} else {
			throw new BadCredentialsException("User Not found with this username");
		}
		
	}

}

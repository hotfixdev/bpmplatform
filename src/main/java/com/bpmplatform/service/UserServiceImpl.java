package com.bpmplatform.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bpmplatform.model.Role;
import com.bpmplatform.model.User;
import com.bpmplatform.repository.RoleRepository;
import com.bpmplatform.repository.UserRepository;
/**
 * @author Dhiraj
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}
	@Override
	public List<User> findAllUser() {
		return userRepository.findAll();
	}
	
	

}

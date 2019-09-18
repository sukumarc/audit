package com.lti.audit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.audit.entities.AuditRole;
import com.lti.audit.entities.User;
import com.lti.audit.exception.UserNotFoundException;
import com.lti.audit.repository.AuditRoleRepository;
import com.lti.audit.repository.UserRepository;
import com.lti.audit.vo.UserVO;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuditRoleRepository auditRoleRepository;

	public List<User> getUsersByRoleCode(String roleCode) {
		return userRepository.findByRoleRoleCode(roleCode);
	}
	
	public User getUserById(Integer id) {
		return userRepository.findById(id).get();
	}

	public User addUser(UserVO userVo) {
		User user = new User();
		return updateOrCreate(user,userVo);
	}
	
	
	public User updateUser(Integer id, UserVO userVo) {
		User user = getUserById(id);
		
		if(user == null) {
			throw new UserNotFoundException();
		}
		 return updateOrCreate(user,userVo);
	}
	
	private User updateOrCreate(User user, UserVO userVo) {
		user.setUsername(userVo.getUsername());
		user.setDisplayName(userVo.getName());
		user.setPassword(userVo.getPassword());
		user.setIsActive(userVo.getIsActive());
		
		AuditRole auditRole = auditRoleRepository.findByRoleCode(userVo.getRole());
		if(auditRole== null) {
			throw new UserNotFoundException();
		}
		
		user.setRole(auditRole);
		return userRepository.save(user);
	}
	

	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

	public UserVO authenticateUser(UserVO userVO){
		
		User user = userRepository.findByUsername(userVO.getUsername());
		
		if(user != null) {
			if(user.getPassword().equals(userVO.getPassword())) {
				userVO.setIsAuth("true");
				userVO.setRole(user.getRole().getRoleCode());
				userVO.setName(user.getDisplayName());
				userVO.setUserId(user.getId());
			} else {
				userVO.setIsAuth("false");
			}
		} 
		return userVO;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
}

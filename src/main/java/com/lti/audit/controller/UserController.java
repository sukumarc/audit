package com.lti.audit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.audit.entities.User;
import com.lti.audit.services.UserService;
import com.lti.audit.vo.UserVO;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Authenticates the logging user.
	 * 
	 * @param userVO
	 * @return
	 */
	@PostMapping(value = "/login")
	public UserVO authenticateUser(@RequestBody UserVO userVO) {
		return userService.authenticateUser(userVO);
	}

	@GetMapping(value = "/mappedusers")
	public ResponseEntity<List<User>> fetchUserRoleMapping() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@GetMapping(value = "/user", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<User> getUsersByRole(@RequestParam String role) {
		return userService.getUsersByRoleCode(role);
	}

	@PostMapping(value = "/user")
	public ResponseEntity<Object> addUser(@RequestBody UserVO userVo) {
		userService.addUser(userVo);
		return ResponseEntity.ok(userVo);
	}

	@PutMapping(value = "/user/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable Integer id, @RequestBody UserVO userVo) {
		userService.updateUser(id, userVo);
		return ResponseEntity.ok(userVo);
	}

	@DeleteMapping(value = "/user/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
		return ResponseEntity.ok().build();
	}

}

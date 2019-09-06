package com.bridgelabz.usermngmt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bridgelabz.usermngmt.config.Response;
import com.bridgelabz.usermngmt.dto.LoginDto;
import com.bridgelabz.usermngmt.dto.UserDto;
import com.bridgelabz.usermngmt.exception.UserException;
import com.bridgelabz.usermngmt.services.IUserServices;

@RequestMapping(value = "/user")
@RestController
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private IUserServices userServices;

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Response> register(@RequestBody UserDto userDto, @RequestParam MultipartFile image) throws UserException {
		logger.info("creating new user - {}", userDto.getEmail());
		return new ResponseEntity<>(userServices.register(userDto, image), HttpStatus.OK);
	}

	@PutMapping("/login")
	public ResponseEntity<Response> login(@RequestBody LoginDto loginDto) throws UserException {
		return new ResponseEntity<>(userServices.login(loginDto), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Response> update(@RequestBody UserDto userDto, @RequestHeader String token) throws UserException {
		return new ResponseEntity<>(userServices.update(userDto, token), HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Response> update(@PathVariable Long userId, @RequestHeader String token) {
		return new ResponseEntity<>(userServices.delete(userId, token), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Response> getAll() {
		return new ResponseEntity<>(userServices.getAll(), HttpStatus.OK);
	}

	@GetMapping("/status")
	public ResponseEntity<Response> getActive(@RequestHeader String token) {
		return new ResponseEntity<>(userServices.getStatus(token), HttpStatus.OK);
	}

}
package com.springboot.rest.example.springbootuserapp.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;

	/*// GET /users
	// retriveAllUsers
	@GetMapping("/users")
	public List<User> retriveAllUsers() {

		return service.findAll();
	}

	// GET /users/{id}
	@GetMapping("/users/{id}")
	public User retriveUser(@PathVariable int id) {
		User user = service.findOne(id);
		if (user == null)
			throw new UserNotFoundException("id- " + id);

		return user;
	}

	// DELETE /users/{id}
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);

		if (user == null)
			throw new UserNotFoundException("id- " + id);
	}

	// input-details of User
	// output - created and return the created URI
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = service.save(user);

		// /user/{id}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}*/
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public User getUser(@PathVariable(value = "userId") String userId) {
		System.out.println("*******************"+userId.length());
		
		User user = service.getUser(userId);
		return user;

	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> getAllUser() {
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>");
		
		List<User> user = service.getAllUser();
		return user;

	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@RequestBody User user) {
		service.saveUser(user);
		return "New User Saved";
	}
}

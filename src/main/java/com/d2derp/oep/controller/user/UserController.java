package com.d2derp.oep.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.d2derp.oep.pojo.UserPojo;
import com.d2derp.oep.service.user.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(value = "/save")
	public void saveUser( @RequestBody UserPojo userPojo) {	
				userService.save(userPojo);
	}

	@GetMapping(value = "/getUser/{id}")
	public ResponseEntity<UserPojo> getUser(@PathVariable(value = "id") int id) {
		return ResponseEntity.ok(userService.findUser(id)); 

	}

	@GetMapping(value = "/list") 
	public ResponseEntity<List<UserPojo>> listUser() {
		
		return ResponseEntity.ok(userService.listUser());
	}

	@PutMapping(value = "/edit")
	public ResponseEntity<UserPojo> updateUser(@RequestBody UserPojo userPojo) {

		if (userService.findUser(userPojo.getId())!=null) {
            ResponseEntity.badRequest().build();
        }

	        return ResponseEntity.ok(userService.editUser(userPojo));
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity  deleteUser(@PathVariable(value ="id") int id) {
        if (userService.findUser(id)!=null) {
            ResponseEntity.badRequest().build();
        }

        userService.deleteUser(id);

        return ResponseEntity.ok().build();
 
	}

}

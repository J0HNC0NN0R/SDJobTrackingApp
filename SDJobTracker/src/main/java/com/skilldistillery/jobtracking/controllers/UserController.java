package com.skilldistillery.jobtracking.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.skilldistillery.jobtracking.entities.User;
import com.skilldistillery.jobtracking.services.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http:localhost:6969" })
public class UserController {
	@Autowired
	private UserService serv;

	@GetMapping("users")
	public List<User> index(Principal principal) {
		return serv.index();
	}
	

	@GetMapping("users/{id}")
	public User show(@PathVariable("id") int id, HttpServletResponse resp, Principal principal) {
		User user = serv.show(id);
		if (user != null) {
			resp.setStatus(200);
		} else {
			resp.setStatus(404);
		}
		return user;
	}

	@PostMapping("users")
	public User create(@RequestBody User user, HttpServletResponse resp, HttpServletRequest req,
			Principal principal) {
		User created = null;
		try {
			created = serv.create(user);
			StringBuffer url = req.getRequestURL();
			url.append("/" + created.getId());
			resp.setStatus(201);
			resp.setHeader("Location", url.toString());

		} catch (Exception e) {
			System.err.println(e);
			resp.setStatus(400);
		}
		return created;
	}

	@PutMapping("users/{id}")
	public User update(@PathVariable("id") int id, @RequestBody User user, HttpServletResponse resp,
			Principal principal) {
		User updated = null;
		try {
			updated = serv.updateUserById(id, user);
			if (updated != null) {
				resp.setStatus(200);
			} else {
				resp.setStatus(404);
			}

		} catch (Exception e) {
			System.err.println(e);
			resp.setStatus(400);
		}
		return updated;
	}

	@DeleteMapping("users/{id}")
	public void delete(@PathVariable("id") int id, HttpServletResponse resp, Principal principal) {
		try {
			if (!serv.deleteUserById(id)) {
				resp.setStatus(204);
			} else {
				resp.setStatus(404);
			}

		} catch (Exception e) {
			resp.setStatus(400);
		}
	}

}

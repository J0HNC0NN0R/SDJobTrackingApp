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

import com.skilldistillery.jobtracking.entities.Application;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http:localhost:4201" })
public class ApplicationController {
	@Autowired
	private ApplicationService serv;

	@GetMapping("applications")
	public List<Application> index(Principal principal) {
		return serv.index(principal.getName());
	}

	@GetMapping("applications/{id}")
	public Application show(@PathVariable("id") int id, HttpServletResponse resp, Principal principal) {
		Application application = serv.show(principal.getName(), id);
		if (application != null) {
			resp.setStatus(200);
		} else {
			resp.setStatus(404);
		}
		return application;
	}

	@PostMapping("applications")
	public Application create(@RequestBody Application application, HttpServletResponse resp, HttpServletRequest req,
			Principal principal) {
		Application created = null;
		try {
			created = serv.create(principal.getName(), application);
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

	@PutMapping("applications/{id}")
	public Application update(@PathVariable("id") int id, @RequestBody Application application, HttpServletResponse resp,
			Principal principal) {
		Application updated = null;
		try {
			updated = serv.update(principal.getName(), id, application);
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

	@DeleteMapping("applications/{id}")
	public void delete(@PathVariable("id") int id, HttpServletResponse resp, Principal principal) {
		try {
			if (!serv.destroy(principal.getName(), id)) {
				resp.setStatus(204);
			} else {
				resp.setStatus(404);
			}

		} catch (Exception e) {
			resp.setStatus(400);
		}
	}
}

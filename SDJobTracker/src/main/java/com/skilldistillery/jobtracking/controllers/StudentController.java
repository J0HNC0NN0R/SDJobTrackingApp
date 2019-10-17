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

import com.skilldistillery.jobtracking.entities.Student;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http:localhost:4201" })
public class StudentController {
	@Autowired
	private StudentService serv;

	@GetMapping("students")
	public List<Student> index(Principal principal) {
		return serv.index(principal.getName());
	}

	@GetMapping("students/{id}")
	public Student show(@PathVariable("id") int id, HttpServletResponse resp, Principal principal) {
		Student student = serv.show(principal.getName(), id);
		if (student != null) {
			resp.setStatus(200);
		} else {
			resp.setStatus(404);
		}
		return student;
	}

	@PostMapping("students")
	public Student create(@RequestBody Student student, HttpServletResponse resp, HttpServletRequest req,
			Principal principal) {
		Student created = null;
		try {
			created = serv.create(principal.getName(), student);
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

	@PutMapping("students/{id}")
	public Student update(@PathVariable("id") int id, @RequestBody Student student, HttpServletResponse resp,
			Principal principal) {
		Student updated = null;
		try {
			updated = serv.update(principal.getName(), id, student);
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

	@DeleteMapping("students/{id}")
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

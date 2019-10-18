package com.skilldistillery.jobtracking.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.jobtracking.entities.Application;
import com.skilldistillery.jobtracking.entities.Cohort;
import com.skilldistillery.jobtracking.entities.Company;
import com.skilldistillery.jobtracking.entities.Event;
import com.skilldistillery.jobtracking.entities.Student;
import com.skilldistillery.jobtracking.entities.User;
import com.skilldistillery.jobtracking.services.ApplicationService;
import com.skilldistillery.jobtracking.services.CompanyService;
import com.skilldistillery.jobtracking.services.StudentService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http:localhost:4201" })
public class StudentController {
	@Autowired
	private StudentService serv;
	
	@Autowired 
	private CompanyService compServ;

	@Autowired 
	private ApplicationService appServ;
	

	@GetMapping("students")
	public List<Student> searchStudentsByName(@RequestParam(value="name") String name){
		return serv.getStudentsByName(name);
	}
	
	@GetMapping("cohorts")
	public List<Cohort> findCohortsById(Principal principal) {
		return serv.getCohorts();
	}
	
	@GetMapping("cohorts/{cid}/students")
	public List<Student> findStudentsByCohort(@PathVariable("cid") int cid) {
		return serv.getStudentsByCohortId(cid);
	}
	
	@GetMapping("students/{id}/events")
	public List<Event> getAllEvents(@PathVariable("id") int id){
		return serv.getEventsByStudentId(id);
	}
	

	@GetMapping("students/{id}")
	public Student getStudentById(@PathVariable("id") int id, HttpServletResponse resp, Principal principal) {
		Student student = serv.findByStudentId(id);
		if (student != null) {
			resp.setStatus(200);
		} else {
			resp.setStatus(404);
		}
		return student;
	}

	@PostMapping("students")
	public Student create(@RequestBody Student student, HttpServletResponse resp, HttpServletRequest req,
			Principal principal, User user) {
		Student created = null;
		try {
			created = serv.create(student, user);
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
	
	@PostMapping("students/{id}/events")
	public Event createEvent(@PathVariable("id") int id, @RequestBody Event event, HttpServletResponse resp, HttpServletRequest req,
			Principal principal) {
		Event created = null;
		try {
			Student student = serv.findByStudentId(id);
			event.setStudent(student);
			created = serv.addEvent(event);
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
			updated = serv.update(student, id);
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

//	@DeleteMapping("students/{id}")
//	public void delete(@PathVariable("id") int id, HttpServletResponse resp, Principal principal) {
//		try {
//			if (!serv.destroy(id)) {
//				resp.setStatus(204);
//			} else {
//				resp.setStatus(404);
//			}
//
//		} catch (Exception e) {
//			resp.setStatus(400);
//		}
//	}

//	@GetMapping("students/notes/{company}")
//	public Student getCompanyNote(@PathVariable("company") String companyName, HttpServletResponse resp, Principal principal,
//			Student student) {
//		CompanyNote note = serv.getCompanyNote(companyName, student.getId());
//		if (note != null) {
//			resp.setStatus(200);
//		} else {
//			resp.setStatus(404);
//		}
//		return note;
//	}
	
	
	
	////////////////////////////////////////////////////////////////////////////////
	//							APPLICATION										  //	
	////////////////////////////////////////////////////////////////////////////////
	
	
//	@GetMapping("students/{id}/applications")
//	public List<Event> getApplications(@PathVariable("id") int id){
//		return serv.getApplicationsByStudentId(id);
//	}
//		
//	@GetMapping("students/{sid}/applications/{aid}")
//	public List<Event> getApplications(@PathVariable("sid") int sid, @PathVariable("aid") int aid){
//		return serv.getApplicationById(sid, aid);
//	}
//	

//	@PostMapping("students/{id}/applications")
//	public Application createApplication(@PathVariable("id") int id, @RequestBody Application application,
//			@RequestBody Company company, HttpServletResponse resp, HttpServletRequest req, 
//			Principal principal) {
//		Application created = null;
//		
//		Company managedCompany = compServ.findByName(company.getName());
//		if (managedCompany == null) {
//			managedCompany = compServ.create(company);
//		}
//		
//		try {
//			application.setCompany(managedCompany);
//			created = appServ.create(application);
//			StringBuffer url = req.getRequestURL();
//			url.append("/" + created.getId());
//			resp.setStatus(201);
//			resp.setHeader("Location", url.toString());
//
//		} catch (Exception e) {
//			System.err.println(e);
//			resp.setStatus(400);
//		}
//		return created;
//	}
//	
}

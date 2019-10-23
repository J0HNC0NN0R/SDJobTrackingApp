package com.skilldistillery.jobtracking.controllers;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.skilldistillery.jobtracking.entities.ApplicationForm;
import com.skilldistillery.jobtracking.entities.Cohort;
import com.skilldistillery.jobtracking.entities.Company;
import com.skilldistillery.jobtracking.entities.CompanyLocation;
import com.skilldistillery.jobtracking.entities.CompanyNote;
import com.skilldistillery.jobtracking.entities.Contact;
import com.skilldistillery.jobtracking.entities.Event;
import com.skilldistillery.jobtracking.entities.Progress;
import com.skilldistillery.jobtracking.entities.Student;
import com.skilldistillery.jobtracking.entities.StudentAddress;
import com.skilldistillery.jobtracking.entities.User;
import com.skilldistillery.jobtracking.services.ApplicationService;
import com.skilldistillery.jobtracking.services.CompanyService;
import com.skilldistillery.jobtracking.services.StudentService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http:localhost:6969" })
public class StudentController {
	@Autowired
	private StudentService serv;
	
	@Autowired 
	private CompanyService compServ;

	@Autowired 
	private ApplicationService appServ;
	
	@Autowired
	private PasswordEncoder encoder;
	
	// C O H O R T S
	
	@GetMapping("cohorts")
	public List<Cohort> findCohortsById(Principal principal) {
		return serv.getCohorts();
	}

	@PostMapping("cohorts")
	public Cohort addCohort(@RequestBody Cohort cohort, HttpServletResponse resp, 
			HttpServletRequest req, Principal principal) {
		Cohort created = null;
		
		try {
			created = serv.addCohort(cohort);
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
	
	@PutMapping("cohorts/{cid}")
	public Cohort updateCohort(@RequestBody Cohort cohort, @PathVariable("cid") int cid,
			HttpServletResponse resp, HttpServletRequest req, Principal principal) {
		System.err.println(cohort);
		
		Cohort updated = null;
		try {
			updated = serv.updateCohort(cohort, cid);
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

	
	// S T U D E N T S
	
	@GetMapping("students")
	public List<Student> searchStudentsByName(@RequestParam(value="name") String name, Principal principal){
		return serv.getStudentsByName("%" + name + "%");
	}
	
	
	@GetMapping("cohorts/{cid}/students")
	public List<Student> findStudentsByCohort(@PathVariable("cid") int cid, Principal principal) {
		return serv.getStudentsByCohortId(cid);
	}

//	@GetMapping("students/{id}")
//	public Student getStudentById(@PathVariable("id") int id, HttpServletResponse resp, Principal principal) {
//		Student student = serv.findByStudentId(id);
//		if (student != null) {
//			resp.setStatus(200);
//		} else {
//			resp.setStatus(404);
//		}
//		return student;
//	}
	
	@GetMapping("students/{username}")
	public Student findStudentsByUsername(@PathVariable("username") String username, Principal principal) {
		return serv.findByUserName(username);
	}
	
	@PostMapping("cohorts/{id}/students")
	public Student create(@RequestBody Student su, @PathVariable("id") int id, HttpServletResponse resp,
			HttpServletRequest req, Principal principal) {
		System.err.println("Controller: " + su);
		Student created = null;
		
		Student student = new Student();
		User user = new User();

		student.setAccepted(su.isAccepted());
		student.setFirstName(su.getFirstName());
		student.setLastName(su.getLastName());
		student.setEmail(su.getEmail());
		student.setGithubUsername(su.getGithubUsername());
		student.setGIBill(su.isGIBill());
		student.setVettec(su.isVettec());
		student.setEmployed(su.isEmployed());
		student.setDeposit_paid(su.isDepositPaid());
		student.setNeedsLoanerLaptop(su.isNeedsLoanerLaptop());
		student.setEducationLevel(su.getEducationLevel());
		student.setOpenToRelocation(su.isOpenToRelocation());
		student.setClearance(su.getClearance());
		
		user.setEnabled(true);
		user.setPassword(encoder.encode(su.getEmail()));
		user.setRole("USER");
		user.setUsername(su.getEmail());
		
		try {
			created = serv.create(student, user, id);
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
	
	@PutMapping("cohorts/{cid}/students/{sid}")
	public Student updateStudent(@PathVariable("sid") int sid, @PathVariable("cid") int cid, 
			@RequestBody Student student, HttpServletResponse resp, Principal principal) {
		Student updated = null;
		try {
			updated = serv.update(student, sid, cid);
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
	
	
	// A D D R E S S
	
	@PostMapping("students/{id}/addresses")
	public StudentAddress createAddress(@PathVariable("id") int id, 
			@RequestBody StudentAddress address, HttpServletResponse resp, HttpServletRequest req,
			Principal principal) {

		StudentAddress created = null;
		
		System.err.println(address);
		System.err.println("***************");
		
		try {
			created = serv.addStudentAddress(address, id);
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
	
	@PutMapping("students/{sid}/addresses/{aid}")
	public StudentAddress updateCompanyNote(@PathVariable("sid") int sid, @PathVariable("aid") int aid,
			@RequestBody StudentAddress address, HttpServletResponse resp, Principal principal) {

		StudentAddress updated = null;
		try {
			updated = serv.updateStudentAddress(address, aid);
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
	

	
	// C O M P A N Y  N O T E S
	
	@GetMapping("students/{id}/notes/companies/{cid}")
	public CompanyNote getNoteByCaompanyName(@PathVariable("sid") int sid, @PathVariable("cid") int cid,
			Principal principal) {
		return serv.getCompanyNote(cid, sid);
	}
	
	@PostMapping("students/{sid}/notes/companies/{cid}")
	public CompanyNote createCompanyNote(@PathVariable("sid") int sid, @PathVariable("cid") int cid,
			@RequestBody CompanyNote note, HttpServletResponse resp, HttpServletRequest req,
			Principal principal) {
		CompanyNote created = null;
		
		try {
			created = serv.addCompanyNote(note, cid, sid);
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

	@PutMapping("students/{sid}/notes/companies/{cid}")
	public CompanyNote updateCompanyNote(@PathVariable("sid") int sid, @PathVariable("cid") int cid,
			@RequestBody CompanyNote note, HttpServletResponse resp, Principal principal) {
		CompanyNote updated = null;
		try {
			updated = serv.updateCompanyNote(note, cid);
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
	
	
	// E V E N T S
	
	@GetMapping("students/{id}/events")
	public List<Event> getAllEvents(@PathVariable("id") int id, Principal principal){
		return serv.getEventsByStudentId(id);
	}
	
	@PostMapping("students/{id}/events")
	public Event createEvent(@PathVariable("id") int id, @RequestBody Event event, HttpServletResponse resp, 
			HttpServletRequest req, Principal principal) {
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


	////////////////////////////////////////////////////////////////////////////////
	//							APPLICATION										  //	
	////////////////////////////////////////////////////////////////////////////////
	
	
	@GetMapping("students/{id}/applications")
	public List<Application> getApplications(@PathVariable("id") int id, Principal principal){
		return appServ.getStudentApplications(id);
	}
		
	@GetMapping("students/{sid}/applications/{aid}")
	public Application getApplications(@PathVariable("sid") int sid, @PathVariable("aid") int aid,
			Principal principal){
		return appServ.findByApplicationId(aid);
	}
	

	@PostMapping("students/{id}/applications")
	public Application createApplication(@PathVariable("id") int id, @RequestBody ApplicationForm form, 
			HttpServletResponse resp, HttpServletRequest req, Principal principal) {
		Application application = new Application();
		Application created = null;
		
		Company company = new Company();
		company.setName(form.getCompanyName());
		company.setSiteURL(form.getSiteUrl());
		
		Company managedCompany = compServ.findByName(form.getCompanyName());
		if (managedCompany == null) {
			managedCompany = compServ.create(company);
		}
		
		CompanyLocation location = new CompanyLocation();
		location.setCity(form.getCity());
		location.setState(form.getState());
		
//		*** Company needs Many to Many relationship for this to work ***
//		CompanyLocation managedLoc = compServ.findByCityAndState(form.getCity(), form.getState());
//		if (managedLoc == null) {
			CompanyLocation managedLoc = compServ.addCompanyLocation(location, managedCompany.getId());
//		}}

		application.setCompany(managedCompany);
		application.setDescriptionURL(form.getDescriptionURL());
		application.setInterestLevel(form.getInterestLevel());
		application.setPosition(form.getPosition());
		
		
		try {
			created = appServ.create(application, id);
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
	
	@PutMapping("students/{sid}/applications/{aid}")
	public Application updateApplication(@PathVariable("sid") int sid, @PathVariable("aid") int aid,
			@RequestBody ApplicationForm form, HttpServletResponse resp, HttpServletRequest req, 
			Principal principal) {

		Application application = new Application();
		Application updated = null;
		
		Company company = new Company();
		company.setName(form.getCompanyName());
		company.setSiteURL(form.getSiteUrl());
		
		Company managedCompany = compServ.findByName(form.getCompanyName());
		if (managedCompany == null) {
			managedCompany = compServ.create(company);
		}
		
		CompanyLocation location = new CompanyLocation();
		location.setCity(form.getCity());
		location.setState(form.getState());

//		*** Company needs Many to Many relationship for this to work ***
//		CompanyLocation managedLoc = compServ.findByCityAndState(form.getCity(), form.getState());
//		if (managedLoc == null) {
			CompanyLocation managedLoc = compServ.addCompanyLocation(location, managedCompany.getId());
//		}
		
		
		application.setCompany(managedCompany);
		application.setDescriptionURL(form.getDescriptionURL());
		application.setInterestLevel(form.getInterestLevel());
		application.setPosition(form.getPosition());
		
		try {
			updated = appServ.update(application, aid);
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
	
	// P R O G R E S S

	@GetMapping("students/{sid}/applications/{aid}/progress")
	public List<Progress> getApplicationProgresses(@PathVariable("sid") int sid, @PathVariable("aid") int aid){
		return appServ.getAllProgressByAppId(aid);
	}
	
	@PostMapping("students/{sid}/applications/{aid}/progress")
	public Progress createProgress(@RequestBody Progress progress, @PathVariable("aid") int aid,
			HttpServletResponse resp, HttpServletRequest req) {
		progress.setUpdated(LocalDateTime.now());
		Progress created = null;
		try {
			created = appServ.addProgressOnApplication(progress, aid);
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
	
	@PutMapping("students/{sid}/applications/{aid}/progress/{pid}")
	public Progress updateProgress(@RequestBody Progress progress, @PathVariable("sid") int sid,
			@PathVariable("aid") int aid, @PathVariable("pid") int pid, HttpServletResponse resp) {
		
		Progress updated = null;

		try {
			updated = appServ.updateProgress(progress, pid);
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
	
	
	
	//	C O N T A C T S
	
	@GetMapping("students/{sid}/applications/{aid}/contacts")
	public List<Contact> getApplicationContacts(@PathVariable("sid") int sid, @PathVariable("aid") int aid){
		return appServ.getContactsByAppId(aid);
	}
	
	@PostMapping("students/{sid}/applications/{aid}/contacts")
	public Contact createApplicationContact(@RequestBody Contact contact, @PathVariable("aid") int aid,
			HttpServletResponse resp, HttpServletRequest req) {
		
		Contact created = null;

		try {
			created = appServ.addContactOnApplication(contact, aid);
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
	
	@PutMapping("students/{sid}/applications/{aid}/contacts/{cid}")
	public Contact updateApplicationContact(@RequestBody Contact contact, @PathVariable("cid") int aid,
			HttpServletResponse resp) {
		
		Contact updated = null;

		try {
			updated = appServ.addContactOnApplication(contact, aid);
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
	
}

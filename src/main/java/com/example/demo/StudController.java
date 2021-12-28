package com.example.demo;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class StudController 
{
	@Autowired
	StudsRepo repo;
	
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
	
	
	@RequestMapping("/getStuds")
	public ModelAndView getStuds( int roll)
	{
		Students stud = repo.findById(roll).orElse(new Students());
		ModelAndView mv = new ModelAndView("view.jsp");
		mv.addObject("stud", stud);
		return mv;
	}
	
	@GetMapping(path = "/studs")
	public List<Students> findStuds()
	{
		return repo.findAll();
	}
	
	@PostMapping(path = "/studs")
	public Students addStuds(@RequestBody Students studs)
	{
		repo.save(studs);
		return studs;
	}
	
	@DeleteMapping(path = "/studs/{roll}")
	public String deleteStuds(@PathVariable int roll)
	{
		repo.deleteById(roll);	
		return "Deleted";
	}
	
	@PutMapping(path = "/studs")
	public Students saveOrUpdateStuds(@RequestBody Students studs)
	{
		repo.save(studs);
		return studs;
	}
	
	
	@RequestMapping("/studs/{roll}")
	public Optional<Students> findStuds(@PathVariable int roll)
	{
		return repo.findById(roll);
	}
	
	

}

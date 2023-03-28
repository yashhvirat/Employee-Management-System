package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.model.Employee;
import com.employee.repo.EmployeeRepo;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepo repo;

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/req1")
	public String reg() {
		return "reg";
	}

	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public String register(Employee emp, Model m) {
		Employee e1 = repo.save(emp);
		return "result";
	}
	
	@RequestMapping(value = "/views", method = RequestMethod.GET)
	public String viewEmployees(Model m) {
		m.addAttribute("emps", repo.findAll());
		return "viewEmployee";
	}

	@RequestMapping(value = "/delete/{eid}", method = RequestMethod.GET)
	public String delete(@PathVariable Integer eid) {
		repo.deleteById(eid);
		return "redirect:/views";
	}

	@RequestMapping(value = "/edit/{eid}")
	public String edit(@PathVariable Integer eid, Model m) {
		Employee emp = repo.findById(eid).get();
		m.addAttribute("command", emp);
		return "editEmp";
	}

	/* It updates model object. */
	@RequestMapping(value = "/editemp", method = RequestMethod.POST)
	public String editsave(@RequestParam Integer eid, @RequestParam String name, @RequestParam String email,
			@RequestParam String password, @RequestParam String address, Employee emp, Model model) {
		repo.save(emp);
		return "redirect:/views";
	}

}
package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Staff;
import com.example.demo.service.AccountService;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.StaffService;

@Controller
public class StaffController {
	@Autowired
	private StaffService staffService;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private AccountService accountService;

	@GetMapping("/staff")
	public String list(Model model) {
		model.addAttribute("staffs", staffService.findAll());
		return "liststaff";
	}

	@GetMapping("/staff/add")
	public String add(Model model) {
//		staff.setDepartmentId(departmentId);
		model.addAttribute("staff", new Staff());
		model.addAttribute("departments", departmentService.findAllDepartment());
		model.addAttribute("accounts", accountService.findAllAccount());
		return "staffform";
	}

	@GetMapping("/staff/{id}/edit")
	public String edit(@PathVariable("id") int id, Model model) {
		model.addAttribute("staff", staffService.findOne(id));
		model.addAttribute("departments", departmentService.findAllDepartment());
		model.addAttribute("accounts", accountService.findAllAccount());
		return "staffform";
	}

	@RequestMapping(value = "/staff/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("staff") Staff staff) {

		staffService.save(staff);

		return new ModelAndView("redirect:/staff");
	}

	@GetMapping("/staff/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		staffService.delete(id);
		redirect.addFlashAttribute("successMessage", "Deleted staff successfully!");
		return "redirect:/staff";
	}

	@GetMapping("/staff/search")
	public String search(@RequestParam("term") String term) {
		List<Staff> list = staffService.search(term);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("staffs", list);
		return "redirect:/staff";
	}

	@RequestMapping(value = "/staff/detail/{id}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable int id) {
		
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("staff", staffService.findOne(id));
	
		modelAndView.setViewName("detailstaff");
		return modelAndView;
	}
	
	@GetMapping(value="/staff/{id}/task")
	public ModelAndView getTask(@PathVariable int id) {
		ModelAndView model = new ModelAndView();
		model.addObject("tasks",staffService.getListTask(id));
		model.setViewName("listtaskofstaff");
		return model;
		
	}
}

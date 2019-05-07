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
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import com.example.demo.service.RoleService;

@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private RoleService roleService;
	
	@GetMapping(value = "/account")
	public ModelAndView getAllAccount() {
		ModelAndView modelAndView = new ModelAndView();
		List<Account> listAccount = accountService.findAllAccount();
		modelAndView.addObject("accounts", listAccount);
		modelAndView.setViewName("listaccount");
		return modelAndView;
	}

	@GetMapping(value = "/account/delete/{id}")
	public String deleteAccount(@PathVariable int id, Model model) {
		accountService.deleteAccount(id);
		return "redirect:/account";
	}
	
	@GetMapping("/account/add")
	public ModelAndView add() {
		ModelAndView model = new ModelAndView();
		model.addObject("account",new Account());
		model.addObject("roles",roleService.getAllRole());
		model.setViewName("accountform");
		return model;
	}

	@RequestMapping(value = "/account/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("account") Account account) {

		accountService.saveAccount(account);

		return new ModelAndView("redirect:/account");
	}
}

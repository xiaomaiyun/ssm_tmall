package com.maven.tmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maven.tmall.pojo.User;
import com.maven.tmall.service.UserService;
import com.maven.tmall.util.Page;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("admin_user_list")
	public String list(Model model, Page page){
		PageHelper.offsetPage(page.getStart(), page.getCount());
		
		List<User> us = userService.list();
		
		int total = (int) new PageInfo<>(us).getTotal();
		page.setTotal(total);
		
		model.addAttribute("us", us);
		model.addAttribute("page", page);
		
		return "admin/listUser";
	}
	
}

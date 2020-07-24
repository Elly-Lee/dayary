package com.dayary.elly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dayary.elly.common.tool.BCRYPT;

@Controller
public class MainController {

	@GetMapping("/main")
	public String showMain(Model model) {
		String pw = BCRYPT.hashpw("user1");
		System.out.println(pw);
		return "home/main";
	}
}

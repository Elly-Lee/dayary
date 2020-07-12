package com.dayary.elly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/main")
	public String showMain(Model model) {
		model.addAttribute("time", System.currentTimeMillis());
		return "main";
	}
}

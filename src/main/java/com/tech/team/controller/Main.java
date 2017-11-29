package com.tech.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Main {

	@GetMapping("/")
	public String hello(){
		
		return "hello";
	}
}

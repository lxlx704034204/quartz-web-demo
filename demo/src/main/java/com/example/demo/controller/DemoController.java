package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DemoController {
	
	
	@RequestMapping("/index")
	String index() {
		return "Hello Spring Boot";
	}
	
	@RequestMapping("/")
	String root() {
		return "redirect:JobManager.html";
	}

	@RequestMapping("/apiTest")
	String apiTest() {
		System.out.println("apiTest");
		return "apiTest";
	}
	
}

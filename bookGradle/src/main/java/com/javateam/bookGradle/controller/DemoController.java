package com.javateam.bookGradle.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class DemoController {

	private static final Logger log = LoggerFactory.getLogger(DemoController.class);
	
	@GetMapping("/demo")
	@ResponseBody
	// public String demo(@RequestParam String p, HttpServletRequest request) {
	public String demo(@RequestParam(value = "p3", defaultValue = "python") String p, HttpServletRequest request) {	
		
		log.info("demo");
		
		String msg = "";
		
		// log.info("p = " + p);
		log.info("p = {}", p);
		
		msg += p + ", ";
		
		String p2 = request.getParameter("p") == null ? "python" : request.getParameter("p").equals("") 
				 ? "python" : request.getParameter("p");
		
		log.info("p(2) = {}", p2);
		msg += p2 + ", ";
		
		return msg;
		
	} 
	
}

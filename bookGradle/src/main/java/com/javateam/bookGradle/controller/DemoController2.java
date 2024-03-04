package com.javateam.bookGradle.controller;

import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class DemoController2 {

	private static final Logger log = LoggerFactory.getLogger(DemoController2.class);
	
	@GetMapping("/demo2")
	@ResponseBody
	// public String demo(@RequestParam String p, HttpServletRequest request) {
	public String demo2(@RequestParam Map<String, Object> map, HttpServletRequest request) {	
		
		
		
		log.info("demo2");
		
		String msg = "";
		
		map.forEach((k,v) -> {
			
			log.info(k + "=" + v);
			
		});
		
		Set<String> set = map.keySet();
		
		for (String k : set) {
			log.info(k + ": " + map.get(k) + " ");
			msg += k + ": " + map.get(k) + " ";
			
		}
		
		
		
		
		
		return msg;
		
	} 
	
}

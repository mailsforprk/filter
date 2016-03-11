package org.prk.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FilterController {

	
	@RequestMapping("/saveFilter")
	@ResponseBody
	public String welcome(@RequestParam String filterValue) {
		System.out.println(filterValue);
		
		return "fitlerName";
	}
}

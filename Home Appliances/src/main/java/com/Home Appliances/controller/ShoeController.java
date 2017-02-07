
package com.HomeAppliances.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoeController {
	@RequestMapping("/sparx")
	public ModelAndView sparx()
	{
		System.out.println("I am in sparx");
		return new ModelAndView("sparx");
	}
	

}

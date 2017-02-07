package com.HomeAppliances.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.HomeAppliances.dao.UsersDetailDao;
import com.HomeAppliances.model.UsersDetail;
import com.HomeAppliances.model.Item;
import com.HomeAppliances.model.ShippingAdd;
import com.HomeAppliances.service.UsersDetailService;
import com.HomeAppliances.service.ItemDaoService;
@Controller
public class HomeController {
	@Autowired
	UsersDetailService service;
	@Autowired
	ItemDaoService productService;
	
	@RequestMapping("/viewDetails")
	public ModelAndView viewDetails(@RequestParam("id") String id)
	{
		System.out.println("ID:"+id);
		Item product=productService.getProduct(Integer.parseInt(id));
		return new ModelAndView("viewDetails","product",product);
	}
	@RequestMapping("/productViewDetails")
	public ModelAndView productViewDetails(@RequestParam("id") String id)
	{
		System.out.println("I am in productViewDetails");
		System.out.println("ID:"+id);
		Item product=productService.getProduct(Integer.parseInt(id));
		return new ModelAndView("productViewDetails","product",product);
	}
	@RequestMapping("/")
	public ModelAndView home()
	{
		List<Item> product=productService.viewProducts();
		String jsonData="";
		ObjectMapper mapper=new ObjectMapper();
		try {
			jsonData=mapper.writeValueAsString(product);
			System.out.println(jsonData);
		} catch (JsonGenerationException e) {
			
			e.printStackTrace();
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return new ModelAndView("index","products",jsonData);
	}
	@RequestMapping("/aboutUs")
	public ModelAndView aboutUs()
	{
		System.out.println("I am in aboutUs");
		return new ModelAndView("aboutUs");
	}
	@RequestMapping("/customerSignUp")
	public ModelAndView signUp()
	{
		System.out.println("I am in customerSignUp");
		UsersDetail usersDetail=new UsersDetail();
	ShippingAdd shippingAddress=new ShippingAdd();
	usersDetail.setShippingAddress(shippingAddress);
		return new ModelAndView("customerSignUp","usersDetail",usersDetail);
	}
	 @RequestMapping("/SignUp")
	public ModelAndView customerSignUp(@Valid @ModelAttribute("usersDetail") UsersDetail customer, BindingResult result,
            Model model)
	{
		 ModelAndView mav;
		 if (result.hasErrors()) {
			 System.out.println("has errors");
	            return new ModelAndView("customerSignUp");
	        }
		System.out.println("customer's first name:"+customer.getFirstName());

		
		boolean isExisting=service.checkForEmail(customer);
		System.out.println("isExisting:"+isExisting);
		if(isExisting==true)
		{
			mav=new ModelAndView("customerSignUp","message","Email ID Already Exists");
		}
		service.signUp(customer);
		mav= new ModelAndView("customerSignUp","message","Dear "+customer.getFirstName()+" !! You have successfully registered,You can Login Now!!");
	   
		return mav;
	}
}

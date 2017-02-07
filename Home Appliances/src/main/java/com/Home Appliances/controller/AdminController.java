
package com.HomeAppliances.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.HomeAppliances.model.UsersDetail;
import com.HomeAppliances.model.Item;
import com.HomeAppliances.service.UsersDetailService;
import com.HomeAppliances.service.ItemDaoService;
@Controller
public class AdminController {
	Path path;
	@Autowired
	UsersDetailService service;
	@Autowired
	ItemDaoService productService;
	@RequestMapping("/AdminCheck")
	public String adminCheck(ModelMap model,Principal principal)
	{
		System.out.println("in admin");
		String name=principal.getName();
		System.out.println("name:"+name);
		model.addAttribute("username",name);
		model.addAttribute("message","spring security custom example");
		return "adminHome";
	}
	@RequestMapping("/CustomerCheck")
	public ModelAndView customerCheck(ModelMap model,Principal principal)
	{
		System.out.println("in customer");
		String name=principal.getName();
		System.out.println("name:"+name);
		model.addAttribute("username",name);
		model.addAttribute("message","spring security custom example");
		List<Item> product=productService.viewProducts();
		String jsonData="";
		ObjectMapper mapper=new ObjectMapper();
		try {
			jsonData=mapper.writeValueAsString(product);
			System.out.println(jsonData);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("customerHome","products",jsonData);
	}
	
@RequestMapping("/login")
public String loginMethod()
{
	return "login";
}

@RequestMapping("/logout")
public String logout(HttpServletRequest request)
{
	request.getSession().invalidate();
	System.out.println("logout page called");

	return "logout";
	
}
	@RequestMapping("/adminHome")
	public ModelAndView adminHome()
	{
		System.out.println("I am in admin home");
		return new ModelAndView("adminHome");
	}
	@RequestMapping("/deleteCustomer")
	public ModelAndView deleteCustomer(HttpServletRequest request)
	{
		ModelAndView mav;
		String id=request.getParameter("id");
		System.out.println("id:"+id);
		boolean result=service.deleteCustomer(Integer.parseInt(id));
		if(result==true)
		{
		  mav=new ModelAndView("showCustomers","message","Customer has been deleted");	
		}
		else
		{
			mav=new ModelAndView("showCustomers","message","Customer deletion failed");
		}
		return mav;
	}
	@RequestMapping("/deleteProduct")
	public String deleteProduct(HttpServletRequest request)
	{
		String id=request.getParameter("id");
		System.out.println("id:"+id);
		boolean result=productService.deleteProduct(Integer.parseInt(id));
		System.out.println("result:"+result);
		return "redirect:/viewProducts";
	}
	@RequestMapping("/showCustomers")
	public ModelAndView showCustomers()
	{
		List<UsersDetail> customer=service.viewAllCustomers();
		String jsonData="";
		System.out.println(customer.toString());
		ObjectMapper mapper=new ObjectMapper();
		try {
			jsonData=mapper.writeValueAsString(customer);
			System.out.println(jsonData);
		} catch (JsonGenerationException e) {
			
			e.printStackTrace();
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return new ModelAndView("showCustomers","ss",jsonData);
	}
	
	
	  @RequestMapping("/addProduct")  
	    public ModelAndView addProduct() {  
	        String message = "Add Product Page";  
	        System.out.println(message);
	        return new ModelAndView("addProduct", "shoes", new Item());  
	    } 
	@RequestMapping(value="/storeProduct")
	public String storeProduct(HttpServletRequest request,ModelMap model,@RequestParam("file") MultipartFile file, @Valid @ModelAttribute("shoes") Item p,BindingResult result)
	{
		String res="";
		if(result.hasErrors())
		{
			System.out.println("hasErrors eecuted");
			return "addProduct";
		}
		System.out.println("In Add Product method");
    	System.out.println("descrip:"+p.getDescription());
    	productService.addProduct(p);
    	 MultipartFile itemImage =p.getFile();
         String rootDirectory = request.getSession().getServletContext().getRealPath("/");
         
         path = Paths.get("C://Users//admin//Desktop//core java videos//HomeAppliances//src//main//webapp//resources//images//"+p.getProduct_id()+".jpg");
System.out.println();

         if (itemImage != null && !itemImage.isEmpty()) {
             try {
             	itemImage.transferTo(new File(path.toString()));
                        	
             	System.out.println("Item Saved");
             } catch (Exception e) {
                 e.printStackTrace();
                 throw new RuntimeException("item image saving failed.", e);
             }
         }
    	
    	return "redirect:/viewProducts";
    	
	}
	
	@RequestMapping("/viewProducts")
	public ModelAndView showProducts()
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
		return new ModelAndView("viewProducts","products",jsonData);
	}
	@RequestMapping("/buyNow")
	public ModelAndView buyNow()
	{
	    return new ModelAndView("buyNow");	
	}
	
}

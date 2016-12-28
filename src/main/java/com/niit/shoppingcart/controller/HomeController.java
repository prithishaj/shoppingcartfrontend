package com.niit.shoppingcart.controller;

import java.util.Locale.Category;
import java.util.function.Supplier;

import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.User;

import ch.qos.logback.classic.Logger;

@Controller
public class HomeController {
	
	public static Logger log = (Logger) LoggerFactory.getLogger(HomeController.class);
	
@Autowired
private Category category;

@Autowired
private Product product;

@Autowired
private Supplier supplier;

@Autowired
private CategoryDAO categoryDAO;

@Autowired
private SupplierDAO supplierDAO;

@Autowired
private UserDAO userDAO;

@Autowired
private User user;


	@RequestMapping("/")
	public ModelAndView onLoad(HttpSession session) {
		log.debug("Starting of method onLoad");
		ModelAndView mv = new ModelAndView("/home");
		session.setAttribute("category", category);
		session.setAttribute("product", product);
		session.setAttribute("supplier", supplier);
		
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("supplierList", supplierDAO.list());
		
		log.debug("Ending of method onLoad");
		return mv;
		
	}
	
	@RequestMapping("/register")
	
	public String register(Model m)
	{
        m.addAttribute("registerMessage","You are successfully registered");
		return "index";
	}
	
@RequestMapping("/validate")

	 public String validate(@RequestParam(name="UserID") String uid,@RequestParam(name="password")String pwd,Model model,HttpSession session)
	{
if(uid.equals("niit") && pwd.equals("niit"))
{
	/*model.addAttribute("sucessMessage","You are successfully logged in");*/
	session.setAttribute("sucessMessage","You are successfully logged in");
}
else
{
	model.addAttribute("errorMessage","Invalid Credentials....Please try again");
}
return "index";
	}

@RequestMapping("/login")
public ModelAndView login()
{
	ModelAndView mv=new ModelAndView("index");
	
	mv.addObject("UserClickedLogin","true");
	return mv;
}

@RequestMapping("/registerHere")
public ModelAndView registerhere(){
	log.debug("Starting of the method registerHere");
	ModelAndView mv  = new ModelAndView("/home");
	mv.addObject("user", user);
	mv.addObject("isUserClickedRegisterHere","true");
	log.debug("Ending of the method registerHere");
	return mv;
}

@RequestMapping("/loginHere")
public ModelAndView loginHere(){
	log.debug("Starting of the method loginHere");
	ModelAndView mv  = new ModelAndView("/home");
	mv.addObject("user", user);
	mv.addObject("isUserClickedLoginHere","true");
	log.debug("Ending of the method loginHere");
	return mv;
}
}
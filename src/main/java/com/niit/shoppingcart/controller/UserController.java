package com.niit.shoppingcart.controller;


import java.util.Locale.Category;
import java.util.function.Supplier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.hibernate.mapping.List;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Product;

import ch.qos.logback.classic.Logger;

@Controller
public class UserController {

	
	public static Logger log = (Logger) LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	User user;
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private Supplier supplier;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Product product;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public ModelAndView login (@RequestParam(value  = "username")String userID, 
			@RequestParam(value  = "password")String password, HttpSession session) {
		log.debug("Starting of the method login");
	
		
		ModelAndView mv = new ModelAndView("/home"); 
		user = userDAO.isValidUser(userID, userID);
		
		if (user != null) {
			log.debug("Valid Credentials");
			user= userDAO.get(userID);
			session.setAttribute("loggedInUser", user.getName());
			session.setAttribute("loggedInUserID", user.getId());
			
			session.setAttribute("user", user);
			
			if(user.getRole().equals("ROLE_ADMIN")){
			log.debug("Logged in as Admin");
			mv.addObject("isAdmin", "true");
			session.setAttribute("supplier", supplier);
			session.setAttribute("supplierList", supplierDAO.list());
			
			session.setAttribute("category", category);
			session.setAttribute("categoryList", categoryDAO.list());
			
			}
			
			else {
				log.debug("Logged in as User");
				mv.addObject("isAdmin", "false");
				cart = cartDAO.get(userID);
				mv.addObject("cart", cart);
				//Fetch the cart list based on user ID
				List<Cart> cartList = cartDAO.list(userID);
				mv.addObject("cartList", cartList);
				mv.addObject("cartSize",cartList.size());
			}
		} else {
				log.debug("Invalid Credentials");
				
				mv.addObject("InvalidCredentials", "true");
				mv.addObject("errorMessage","InvalidCredentials");
			}
			log.debug("Ending of the method login");
			return mv;
		}
		
		@RequestMapping("/logout")
		public ModelAndView logout(HttpServletRequest request) {
		log.debug("Starting of the method logout");
		ModelAndView mv = new ModelAndView("/home");
		session.invalidate(); //will remove attributes which are added session
		session = request.getSession(true);
		session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDAO.list());
		
		mv.addObject("logoutMessage", "You are successfully logged out");
		mv.addObject("loggedOut","true");
		log.debug("Ending of the method logout");
		return mv;
		}
		
		@RequestMapping(value= "/register", method = RequestMethod.POST)
		public ModelAndView registerUser(@ModelAttribute User user) {
			log.debug("Starting of the method registerUser");
			ModelAndView mv = new ModelAndView("home");
			if(userDAO.get(user.getId()) == null) {
				user.setRole("ROLE_USER");
				userDAO.saveOrUpdate(user);
				log.debug("You are successfully registered");
				mv.addObject("succussMessage","You are successfully registered");
			} else {
				log.debug("User exist with this id");
				mv.addObject("errorMessage","User exist with this id");
			}
			log.debug("Ending of the method registerUser");
			return mv;
			}
			
		@RequestMapping(value = "/loginError", method = RequestMethod.GET)
		public String loginError(Model model) {
			log.debug("Starting of the method loginError");
			model.addAttribute("errorMessage", "Login Error");
			log.debug("Ending of the method LoginError");
			return "home";
		}
		
		@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
		
		}
		
		
		
		
		
		
	
	
	


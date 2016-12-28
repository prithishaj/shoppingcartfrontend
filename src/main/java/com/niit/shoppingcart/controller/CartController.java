package com.niit.shoppingcart.controller;

import javax.enterprise.inject.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.model.Cart;




public class CartController {
	
	private static Logger log = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
    private CartDAO cartDAO;
	
	@Autowired
	private Cart cart;
	
	private String path = "D:\\shoppingcart\\img";
	@RequestMapping(value = "/manage cart" , method = RequestMethod.GET)
	public String listCart(Model model) {
		log.debug("Starting of the method listCart");
		model.addAttribute("cart",cart);
		model.addAttribute("cartList",cartDAO.list());
		model.addAttribute("isAdminClickedCart","true");
		log.debug("Ending of the method listCart");
		return "/home";
	}
	
	@RequestMapping(value = "/manage_cart_add", method = RequestMethod.POST)
	public String addCart(@ModelAttribute("category")Cart cart,Model model) {
		log.debug("Starting of the method addCategory");
		log.debug("id:"+ cart.getId());
		if (cartDAO.saveOrUpdate(cart)==true) {
			model.addAttribute("msg","Successfully created/updated the cart");
		} else {
			model.addAttribute("msg","not able to create/update the cart");
		}
		model.addAttribute("cart",cart);
		model.addAttribute("cartList",cartDAO.list());
		model.addAttribute("isAdminClickedCart","true");
		log.debug("Ending of the method addCart");
		return "/home";
	}
	
	@RequestMapping("manage_cart_remove/{id}")
	public String deleteCart(@PathVariable("id")String id,Model model) throws Exception {
		boolean flag = cartDAO.delete(id);
		String msg = "Successfully done the operation";
		if (flag != true) {
			msg ="The Opertion could not success";
		}
		model.addAttribute("msg",msg);
		return "forward:/manage_cart";
	}

	@RequestMapping("manage_cart_edit/{id}")
	public String editCart(@PathVariable("id")String id,Model model) {
		log.debug("Starting of the method editCart");
		cart = cartDAO.get(id);
		model.addAttribute("cart",cart);
		log.debug("Ending of the method editCart");
		return "forward:/manage_cart";
	}
	}


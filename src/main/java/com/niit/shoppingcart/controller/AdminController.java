package com.niit.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.shoppingcart.model.Product;

import antlr.collections.List;

 @Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private Product product;

	@RequestMapping
	public String adminPage() {
		return "admin";
	}

	@RequestMapping("/productInventory")
	public String productInventory(Model model) {
		List products = productService.getProductList();
		model.addAttribute("products", products);

		return "productInventory";
	}

	@RequestMapping("/customer")
	public String customerManagement(Model model) {
		return "customerManagement";
	}
}
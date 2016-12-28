package com.niit.shoppingcart.controller;

import javax.enterprise.inject.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;



public class ProductController {
	
	private static Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
    private ProductDAO productDAO;
	
	@Autowired
	private Product product;
	
	private String path = "D:\\shoppingcart\\img";
	@RequestMapping(value = "/manage product" , method = RequestMethod.GET)
	public String listProducts(Model model) {
		log.debug("Starting of the method listProducts");
		model.addAttribute("product",product);
		model.addAttribute("productList",productDAO.list());
		model.addAttribute("isAdminClickedProduct","true");
		log.debug("Ending of the method listproducts");
		return "/home";
	}
	
	@RequestMapping(value = "/manage_product_add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product")Product category,Model model) {
		log.debug("Starting of the method addProduct");
		log.debug("id:"+ product.getId());
		if (productDAO.saveOrUpdate(product)==true) {
			model.addAttribute("msg","Successfully created/updated the product");
		} else {
			model.addAttribute("msg","not able to create/update the product");
		}
		model.addAttribute("product",product);
		model.addAttribute("productList",productDAO.list());
		model.addAttribute("isAdminClickedProduct","true");
		log.debug("Ending of the method addProduct");
		return "/home";
	}
	
	@RequestMapping("manage_product_remove/{id}")
	public String deleteProduct(@PathVariable("id")String id,Model model) throws Exception {
		boolean flag = productDAO.delete(id);
		String msg = "Successfully done the operation";
		if (flag != true) {
			msg ="The Opertion could not success";
		}
		model.addAttribute("msg",msg);
		return "forward:/manage_product";
	}

	@RequestMapping("manage_product_edit/{id}")
	public String editProduct(@PathVariable("id")String id,Model model) {
		log.debug("Starting of the method editProduct");
		product = productDAO.get(id);
		model.addAttribute("product",product);
		log.debug("Ending of the method editProduct");
		return "forward:/manage_product";
	}
	}


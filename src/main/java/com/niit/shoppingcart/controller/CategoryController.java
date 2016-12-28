package com.niit.shoppingcart.controller;

import javax.enterprise.inject.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;


public class CategoryController {
	
	private static Logger log = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
    private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	private String path = "D:\\shoppingcart\\img";
	@RequestMapping(value = "/manage categories" , method = RequestMethod.GET)
	public String listCategories(Model model) {
		log.debug("Starting of the method listCategories");
		model.addAttribute("category",category);
		model.addAttribute("categoryList",categoryDAO.list());
		model.addAttribute("isAdminClickedCategories","true");
		log.debug("Ending of the method listCategories");
		return "/home";
	}
	
	@RequestMapping(value = "/manage_category_add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category")Category category,Model model) {
		log.debug("Starting of the method addCategory");
		log.debug("id:"+ category.getId());
		if (categoryDAO.saveOrupdate(category)==true) {
			model.addAttribute("msg","Successfully created/updated the category");
		} else {
			model.addAttribute("msg","not able to create/update the category");
		}
		model.addAttribute("category",category);
		model.addAttribute("categoryList",categoryDAO.list());
		model.addAttribute("isAdminClickedCategories","true");
		log.debug("Ending of the method addCategory");
		return "/home";
	}
	
	@RequestMapping("manage_category_remove/{id}")
	public String deleteCategory(@PathVariable("id")String id,Model model) throws Exception {
		boolean flag = categoryDAO.delete(id);
		String msg = "Successfully done the operation";
		if (flag != true) {
			msg ="The Opertion could not success";
		}
		model.addAttribute("msg",msg);
		return "forward:/manage_categories";
	}

	@RequestMapping("manage_category_edit/{id}")
	public String editCategory(@PathVariable("id")String id,Model model) {
		log.debug("Starting of the method editCategory");
		category = categoryDAO.get(id);
		model.addAttribute("category",category);
		log.debug("Ending of the method editCategory");
		return "forward:/manage_categories";
	}
	}


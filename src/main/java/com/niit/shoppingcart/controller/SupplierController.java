
import javax.enterprise.inject.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;


public class SupplierController {
	
	private static Logger log = LoggerFactory.getLogger(SupplierController.class);
	
	@Autowired
    private SupplierDAO supplierDAO;
	
	@Autowired
	private Supplier supplier;
	
	private String path = "D:\\shoppingcart\\img";
	
	@RequestMapping(value = "/manage suppliers" , method = RequestMethod.GET)
	public String listCategories(Model model) {
		log.debug("Starting of the method listCategories");
		model.addAttribute("Supplier",supplier);
		model.addAttribute("SupplierList",SupplierDAO.list());
		model.addAttribute("isAdminClickedCategories","true");
		log.debug("Ending of the method listCategories");
		return "/home";
	}
	
	@RequestMapping(value = "/manage_Supplier_add", method = RequestMethod.POST)
	public String addSupplier(@ModelAttribute("Supplier")Supplier Supplier,Model model) {
		log.debug("Starting of the method addSupplier");
		log.debug("id:"+ Supplier.getId());
		if (SupplierDAO.saveOrUpdate(Supplier)==true) {
			model.addAttribute("msg","Successfully created/updated the Supplier");
		} else {
			model.addAttribute("msg","not able to create/update the Supplier");
		}
		model.addAttribute("Supplier",Supplier);
		model.addAttribute("SupplierList",SupplierDAO.list());
		model.addAttribute("isAdminClickedCategories","true");
		log.debug("Ending of the method addSupplier");
		return "/home";
	}
	
	@RequestMapping("manage_Supplier_remove/{id}")
	public String deleteSupplier(@PathVariable("id")String id,Model model) throws Exception {
		boolean flag = SupplierDAO.delete(id);
		String msg = "Successfully done the operation";
		if (flag != true) {
			msg ="The Opertion could not success";
		}
		model.addAttribute("msg",msg);
		return "forward:/manage_categories";
	}

	@RequestMapping("manage_Supplier_edit/{id}")
	public String editSupplier(@PathVariable("id")String id,Model model) {
		log.debug("Starting of the method editSupplier");
		supplier = SupplierDAO.get(id);
		model.addAttribute("Supplier",supplier);
		log.debug("Ending of the method editSupplier");
		return "forward:/manage_categories";
	}
	}


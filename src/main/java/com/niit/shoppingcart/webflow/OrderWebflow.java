package com.niit.shoppingcart.webflow;

import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Product;

@Component
public class OrderWebflow {

	private static Logger log = (Logger) LoggerFactory.getLogger(OrderWebflow.class);
	
	@Autowired
	private Order orderDAO;
	
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	Cart cart;
	
	@Autowired
	Order order;
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	Product product;
	

	
	public Order initFlow() {
		
		log.debug("WEBFLOW->->Starting of the method initFlow");
		order = new Order();
		log.debug("WEBFLOW->->Ending of the method initFlow");
		return order;
	}
	
	public String addShippingAddress(Order order,ShippingAddress shippingAddress) {
		log.debug("WEB-FLOW->Starting of the method ShippingAddress");
        order.setShippingAddress(shippingAddress);
        log.debug("WEB-FLOW->Ending of the method ShippingAddress");
        return "success";
	}
	
	public String addBillingAddress(Order order,BillingAddress billingAddress) {
		log.debug("WEB-FLOW->Starting of the method BillingAddress");
        order.setBillingAddress(billingAddress);
        log.debug("WEB-FLOW->Ending of the method BillingAddress");
        return "success";
	}
	
	public String addPaymentMethod(Order order,PaymentMethod paymentMethod) {
		log.debug("WEB-FLOW->Starting of the method PaymentMethod");
        order.setPaymentMethod(paymentMethod.getPaymentMethod());
        log.debug("WEB-FLOW->Ending of the method PaymentMethod");
        return "success";
	}
	
	public String confirmOrder(Order order) {
		log.debug("WEB-FLOW->Starting of the method ConfirmOrder");
        orderDAO.saveOrUpdate(order);
        log.debug("WEB-FLOW->Ending of the method ConfirmOrder");
        return "success";
	}	
}

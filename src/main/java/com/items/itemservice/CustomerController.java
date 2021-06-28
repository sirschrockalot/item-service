package com.items.itemservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@CrossOrigin
@RequestMapping(value = "/customer", produces = { "application/json" })
public class CustomerController {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CustomerRepository customerRepo;
	
	
	@GetMapping
	public String getCustomer(@PathVariable("id") String id) {
		Gson gson = new GsonBuilder().create();
		return gson.toJson(customerRepo.findById(id));
	}
	
	@PostMapping
	private String saveCustomer(@RequestBody String customerData) {
		Gson gson = new Gson();
		Customer customer = gson.fromJson(customerData, Customer.class);
		LOG.info(gson.toJson(customer));
		LOG.info("Saving Customer");
		return gson.toJson(customerRepo.save(customer));

	}

//	@GetMapping(value = "/type")
//	public String getProductsByType(@RequestParam("searchCriteria") String searchCriteria) {
//		Gson gson = new GsonBuilder().create();
//		return gson.toJson(productsRepo.findByType(searchCriteria));
//	}


}

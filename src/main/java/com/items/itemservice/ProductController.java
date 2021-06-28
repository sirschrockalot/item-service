package com.items.itemservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@CrossOrigin
@RequestMapping(value = "/product", produces = { "application/json" })
public class ProductController {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductsRepository productsRepo;
	
	
	@GetMapping
	public String getProducts() {
		Gson gson = new GsonBuilder().create();
		return gson.toJson(productsRepo.findAll());
	}

	@GetMapping(value = "/type")
	public String getProductsByType(@RequestParam("searchCriteria") String searchCriteria) {
		Gson gson = new GsonBuilder().create();
		return gson.toJson(productsRepo.findByType(searchCriteria));
	}

}

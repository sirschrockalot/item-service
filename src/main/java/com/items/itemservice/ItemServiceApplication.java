package com.items.itemservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@SpringBootApplication
@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin
@RequestMapping(value = "/products", produces = { "application/json" })
public class ItemServiceApplication {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductsRepository productsRepo;
	
	@Autowired
	private CartRepository cartRepo;

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	@GetMapping
	public String getItems() {
		Gson gson = new GsonBuilder().create();
		return gson.toJson(productsRepo.findAll());
	}

	@GetMapping(value = "/type")
	public String getItems(@RequestParam("searchCriteria") String searchCriteria) {
		Gson gson = new GsonBuilder().create();
		return gson.toJson(productsRepo.findByType(searchCriteria));
	}

//	@PostMapping
//	private String saveCart(HttpEntity<String> entity) {
//		Gson gson = new Gson();
//		Cart cart = gson.fromJson(entity.getBody(), Cart.class);
//
//		LOG.info("Saving Cart");
//		return gson.toJson(cartRepo.save(cart));
//
//	}
	
	@PostMapping
	private String saveCart(@RequestBody String cartItems) {
		Gson gson = new Gson();
		Cart cart = gson.fromJson(cartItems, Cart.class);
		System.out.println(gson.toJson(cart));
//		Cart cart = new Cart();
//		cart.setCustomer(customer);
//		cart.setProducts(products);
		LOG.info("Saving Cart");
		return gson.toJson(cartRepo.save(cart));
//		return "Test";

	}

}

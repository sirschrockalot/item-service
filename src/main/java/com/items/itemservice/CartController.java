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
@RequestMapping(value = "/cart", produces = { "application/json" })
public class CartController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CartRepository cartRepo;

	@GetMapping
	public String getCarts() {
		Gson gson = new GsonBuilder().create();
		return gson.toJson(cartRepo.findAll());
	}

	@GetMapping(value = "/{id}")
	public String getCart(@PathVariable("id") String id) {
		Gson gson = new GsonBuilder().create();
		return gson.toJson(cartRepo.findById(id));
	}

	@PostMapping
	private String saveCart(@RequestBody String cartItems) {
		Gson gson = new Gson();
		Cart cart = gson.fromJson(cartItems, Cart.class);
		System.out.println(gson.toJson(cart));
		LOG.info(gson.toJson(cart));
		LOG.info("Saving Cart");
		return gson.toJson(cartRepo.save(cart));

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

}

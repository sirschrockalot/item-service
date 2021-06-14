package com.items.itemservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@SpringBootApplication
@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin
@RequestMapping(value = "/items", produces = { "application/json" })
public class ItemServiceApplication {
	@Autowired
	private ItemRepository itemRepo;
	
	

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}
	
	@GetMapping
	public String getItems() {
		Gson gson = new GsonBuilder().create();
		return gson.toJson(itemRepo.findAll());
	}
	
	
	@GetMapping(value="/type")
	public String getItems(@RequestParam("searchCriteria")String searchCriteria) {
		Gson gson = new GsonBuilder().create();
		return gson.toJson(itemRepo.findByType(searchCriteria));
	}

}

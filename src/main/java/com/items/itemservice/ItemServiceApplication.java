package com.items.itemservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin
@RequestMapping(value = "/products", produces = { "application/json" })
public class ItemServiceApplication {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

}

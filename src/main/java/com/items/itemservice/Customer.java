package com.items.itemservice;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "customers")
public class Customer {
	private String name;
	private String lastName;
	private String email;
	private String paymentMethod;
	private boolean isCoach;
}

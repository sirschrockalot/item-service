package com.items.itemservice;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "cart")
@Getter
@Setter
public class Cart {
	@Id
	private String id;
	private Customer customer;
	private double totalCost;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date createdDate = new Date();

	private List<CartProducts> products;

	@Getter
	@Setter
	private class CartProducts {
		private String name;
		private String type;
		private String image_url;
		private String price;
		private String size;
		private String flavor;
		private String qty;
	}
}

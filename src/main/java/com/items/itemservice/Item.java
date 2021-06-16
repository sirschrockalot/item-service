package com.items.itemservice;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "items")
@Getter @Setter
public class Item {
	
	private String id;
	private String name;
	private String type;
	private String image_url;
	private String price;
	private List<Variants> variants;
//	private List<String> flavors;
//	private List<Sizes> sizes;
	
	
//	@Getter @Setter
//	private class Sizes{
//		private String size;
//		private String price;
//	}
	
	@Getter @Setter
	private class Variants{
		private String size;
		private String price;
		private List<String> flavors;
	}
	

}

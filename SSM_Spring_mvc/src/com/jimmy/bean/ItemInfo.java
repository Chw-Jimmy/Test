package com.jimmy.bean;

public class ItemInfo {
	// id
	
	private String item_id;
	// name
	private String item_name;

	// type
	private String item_type;
	
	// price
	private String item_price;

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_type() {
		return item_type;
	}

	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}

	public String getItem_price() {
		return item_price;
	}

	public void setItem_price(String item_price) {
		this.item_price = item_price;
	}

	public ItemInfo(String item_id, String item_name, String item_type, String item_price) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_type = item_type;
		this.item_price = item_price;
	}

}

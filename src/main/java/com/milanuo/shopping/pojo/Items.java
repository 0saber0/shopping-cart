package com.milanuo.shopping.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "items")
public class Items {

	@Id
	private int id;
	@Column
	private String name;
	@Column
	private String city;
	@Column
	private int price;
	@Column
	private int number;
	@Column
	private String picture;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public int hashCode() {

		return this.getId() + this.getName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj instanceof Items) {
			Items i = (Items) obj;
			if (this.getId() == i.getId() && this.getName().equals(i.getName())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}

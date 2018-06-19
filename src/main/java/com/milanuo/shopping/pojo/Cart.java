package com.milanuo.shopping.pojo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class Cart {

	
	private HashMap<Items, Integer> goods;

	
	private double totalPrice;

	
	public Cart() {
		goods = new HashMap<Items, Integer>();
		totalPrice = 0.0;
	}

	public HashMap<Items, Integer> getGoods() {
		return goods;
	}

	public void setGoods(HashMap<Items, Integer> goods) {
		this.goods = goods;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	public boolean addGoodsInCart(Items item, int number) {
		if (goods.containsKey(item)) {
			goods.put(item, goods.get(item) + number);
		} else {
			goods.put(item, number);
		}
		calTotalPrice(); 
		return true;
	}

	public boolean removeGoodsFromCart(Items item) {
		goods.remove(item);
		calTotalPrice(); 
		return true;
	}

	public double calTotalPrice() {
		double sum = 0.0;
		Set<Items> keys = goods.keySet();
		Iterator<Items> it = keys.iterator(); 
		while (it.hasNext()) {
			Items i = it.next();
			sum += i.getPrice() * goods.get(i);
		}
		this.setTotalPrice(sum);
		return this.getTotalPrice();
	}

}

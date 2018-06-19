package com.milanuo.shopping.service;

import java.util.List;

import com.milanuo.shopping.pojo.Items;

public interface ItemsService {
	
	public List<Items> listAll();
	
	public Items getOne(int id);
}

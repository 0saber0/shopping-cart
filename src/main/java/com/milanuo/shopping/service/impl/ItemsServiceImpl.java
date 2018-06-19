package com.milanuo.shopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milanuo.shopping.mapper.ItemsMapper;
import com.milanuo.shopping.pojo.Items;
import com.milanuo.shopping.service.ItemsService;

@Service
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsMapper itemsMapper;
	
	public List<Items> listAll() {
		
		return itemsMapper.selectAll();
	}

	public Items getOne(int id) {
		
		return itemsMapper.selectByPrimaryKey(id);
	}

}

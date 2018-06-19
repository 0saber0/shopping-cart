package com.milanuo.shopping.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.milanuo.shopping.pojo.Items;
import com.milanuo.shopping.service.impl.ItemsServiceImpl;

@Controller
@RequestMapping("/shopping")
public class ItemsController {

	@Autowired
	private ItemsServiceImpl itemsServiceImpl;

	@RequestMapping("/index")
	public String index(Model model) {

		List<Items> listAll = itemsServiceImpl.listAll();
		model.addAttribute("listAll", listAll);

		return "index";
	}

	@RequestMapping("/details")
	public String details(int id, Model model, HttpServletRequest request, HttpServletResponse response) {

		if (id > 0) {
			Items items = itemsServiceImpl.getOne(id);
			model.addAttribute("items", items);

			String list = "";
			// 从客户端获得Cookies集合
			Cookie[] cookies = request.getCookies();
			// 遍历这个Cookies集合
			if (cookies != null && cookies.length > 0) {
				for (Cookie c : cookies) {
					if (c.getName().equals("ListViewCookie")) {
						list = c.getValue();
					}
				}
			}
			list += id + ",";
			// 如果浏览记录超过1000条，清零.
			String[] arr = list.split(",");
			if (arr != null && arr.length > 0) {
				if (arr.length >= 1000) {
					list = "";
				}
			}
			Cookie cookie = new Cookie("ListViewCookie", list);
			response.addCookie(cookie);

			ArrayList<Items> viewList = new ArrayList<Items>();
			int iCount = 5; // 每次返回前五条记录
			if (list != null && list.length() > 0) {
				String[] arr1 = list.split(",");
				
				// 如果商品记录大于等于5条
				if (arr.length >= 5) {
					for (int i = arr1.length - 1; i >= arr1.length - iCount; i--) {
						viewList.add(itemsServiceImpl.getOne(Integer.valueOf(arr1[i])));
					}
				} else {
					for (int i = arr.length - 1; i >= 0; i--) {
						viewList.add(itemsServiceImpl.getOne(Integer.valueOf(arr1[i])));
					}
				}
				
			} 
			model.addAttribute("viewList", viewList);

		}
		return "details";
	}
}

package com.milanuo.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.milanuo.shopping.pojo.Cart;
import com.milanuo.shopping.pojo.Items;
import com.milanuo.shopping.service.impl.ItemsServiceImpl;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private ItemsServiceImpl itemsServiceImpl;

	private String action;

	@RequestMapping("/choose")
	public String choose(String action, HttpServletRequest request, HttpServletResponse response) {

		if (action != null) {
			this.action = action;
			if (this.action.equals("add")) {// 如果是添加商品进购物车
				if (addToCart(request, response)) {
					return "forward:/WEB-INF/views/success.jsp";
				} else {
					return "forward:failure";
				}
			}
			if (this.action.equals("show")) {// 如果是显示购物车
				return "forward:/WEB-INF/views/cart.jsp";
			}
			if (this.action.equals("delete")) {// 如果是执行删除购物车中的商品
				if (deleteFromCart(request, response)) {
					return "forward:/WEB-INF/views/cart.jsp";
				} else {
					return "forward:/WEB-INF/views/cart.jsp";
				}
			}
		}
		return null;

	}

	// 添加商品进购物车的方法
	private boolean addToCart(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String number = request.getParameter("num");
		Items item = itemsServiceImpl.getOne(Integer.parseInt(id));

		// 是否是第一次给购物车添加商品,需要给session中创建一个新的购物车对象
		if (request.getSession().getAttribute("cart") == null) {
			Cart cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart.addGoodsInCart(item, Integer.parseInt(number))) {
			return true;
		} else {
			return false;
		}

	}

	// 从购物车中删除商品
	private boolean deleteFromCart(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		Items item = itemsServiceImpl.getOne(Integer.parseInt(id));
		if (cart.removeGoodsFromCart(item)) {
			return true;
		} else {
			return false;
		}
	}

}

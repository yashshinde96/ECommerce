package com.app.dao;

import java.util.List;

import com.app.pojos.Cart;
import com.app.pojos.Customer;
import com.app.pojos.Orders;
import com.app.pojos.Payment;
import com.app.pojos.Product;

public interface CustomerDaoInterface {

	List<Product> fetchProducts();

	String order(Orders order, Cart c);

	String addtoCart(int pid, Customer cus);

	List<Cart> fetchCart(Customer cus);

	void removeCart(Cart c);

	List<Orders> fetMyOrders(Customer cus);

	String removeCart(int pid);

}

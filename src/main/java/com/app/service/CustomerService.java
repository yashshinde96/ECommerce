package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CustomerDaoInterface;
import com.app.pojos.Cart;
import com.app.pojos.Customer;
import com.app.pojos.Orders;
import com.app.pojos.Payment;
import com.app.pojos.Product;

@Service
@Transactional
public class CustomerService implements CustomerServiceInterface {

	@Autowired
	private CustomerDaoInterface customerDao;

	@Override
	public List<Product> fetchProducts() {
		return customerDao.fetchProducts();
	}

	
	@Override
	public String order(Orders order, Cart c) {
		// TODO Auto-generated method stub
		return customerDao.order(order,c);
	}


	@Override
	public String addtoCart(int pid, Customer cus) {
		// TODO Auto-generated method stub
		return customerDao.addtoCart(pid, cus);
	}


	@Override
	public List<Cart> fetchCart(Customer cus) {
		// TODO Auto-generated method stub
		return customerDao.fetchCart(cus);
	}


	@Override
	public void removeCart(Cart c) {
		// TODO Auto-generated method stub
		customerDao.removeCart(c);
	}


	@Override
	public List<Orders> fetMyOrders(Customer cus) {
		// TODO Auto-generated method stub
		return customerDao.fetMyOrders(cus);
	}


	@Override
	public String removeCart(int pid) {
		// TODO Auto-generated method stub
		return customerDao.removeCart(pid);
	}

	


	
}

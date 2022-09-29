package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Cart;
import com.app.pojos.Customer;
import com.app.pojos.Orders;
import com.app.pojos.Payment;
import com.app.pojos.Product;

@Repository
public class CustomerDao implements CustomerDaoInterface {

	@Autowired
	private EntityManager mgr;

	@Override
	public List<Product> fetchProducts() {
		
		return mgr.createQuery("select p from Product p", Product.class).getResultList();
	}

	@Override
	public String order(Orders order, Cart c) {
		Product p=mgr.find(Product.class, order.getProd().getId());
		if(p.getStock() >= 1) {
		p.setStock(p.getStock()-1);
		mgr.persist(order);
		}else {
			mgr.persist(order);	
		}
		//mgr.remove(c);
		return "order Placed Successfully";
	}


	@Override
	public String addtoCart(int pid, Customer cus) {
		Product p=mgr.find(Product.class, pid);
		Cart c=new Cart();
		c.setCustomer(cus);
		c.setProduct(p);
		mgr.persist(c);
		return "Item Added to the Cart";
	}

	@Override
	public List<Cart> fetchCart(Customer cus) {
		String jpql="select c from Cart c where c.customer=:cust";
		List<Cart> list=mgr.createQuery(jpql, Cart.class).setParameter("cust", cus).getResultList();
		if(list!=null)
			return list;
		return null;
	}

	@Override
	public void removeCart(Cart c) {
		Cart c1=mgr.find(Cart.class, c.getId());
		mgr.remove(c1);
		
	}

	@Override
	public List<Orders> fetMyOrders(Customer cus) {
		String jpql="Select o from Orders o where o.customer=:cus";
		List<Orders> list= mgr.createQuery(jpql, Orders.class).setParameter("cus", cus).getResultList();
		for(Orders o:list) {
		System.out.println(o.getStatus());
		}return list;
	}

	@Override
	public String removeCart(int pid) {
		Cart c=mgr.find(Cart.class, pid);
		mgr.remove(c);
		return "Cart Item Removed";
	}

	
	
}

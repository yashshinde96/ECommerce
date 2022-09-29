package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders extends BaseEntity {
	
	@ManyToOne()
	@JoinColumn(name = "product_id")
	private Product prod;
	
	@ManyToOne()
	@JoinColumn(name = "customer_id")
	private Customer customer;

	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pay_id")
	private Payment pay;

	private String status;

	public Orders() {
		System.out.println("Order ");
	}


	public Orders(Product prod, Customer customer, Payment pay,String status) {
		super();
		this.prod = prod;
		this.customer = customer;
		this.pay = pay;
		this.status=status;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Product getProd() {
		return prod;
	}


	public void setProd(Product prod) {
		this.prod = prod;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Payment getPay() {
		return pay;
	}


	public void setPay(Payment pay) {
		this.pay = pay;
	}


	@Override
	public String toString() {
		return "Orders [prod=" + prod + ", customer=" + customer + ", pay=" + pay + "]";
	}

	
	
}

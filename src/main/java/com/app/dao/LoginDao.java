package com.app.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Admin;
import com.app.pojos.Customer;

@Repository
public class LoginDao implements LoginDaoInterface {

	@Autowired
	private EntityManager mgr;

	@Override
	public Admin checkAdmin() {
		try {
			String Jpql = "select a from Admin a";
			Admin admin = mgr.createQuery(Jpql, Admin.class).getSingleResult();
			if (admin != null)
				return admin;
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void registerAdmin(Admin admin) {
		mgr.persist(admin);

	}

	@Override
	public Admin verifyAdmin(String email, String password) {
		try {
			String jpql = "Select a from Admin a where a.email=:email and a.password=:password";
			Admin admin = mgr.createQuery(jpql, Admin.class).setParameter("email", email)
					.setParameter("password", password).getSingleResult();
			if (admin != null)
				return admin;
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String registerUser(Customer con) {
		
		mgr.persist(con);
		return "Registration done please login";
	}

	@Override
	public Customer verifyCustomer(String email, String password) {
		
		try {
			String jpql = "select c from Customer c where c.email=:email and c.Password=:password";
			Customer cus = mgr.createQuery(jpql, Customer.class).setParameter("email", email)
					.setParameter("password", password).getSingleResult();
			if (cus != null)
				return cus;
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String getPassword(String email) {
		try {
			String jpql = "select c from Customer c where c.email=:email";
			Customer cus = mgr.createQuery(jpql, Customer.class).setParameter("email", email)
					.getSingleResult();
			if (cus != null)
				return cus.getPassword();
			return null;
		} catch (Exception e) {
			return null;
		}
	}
}

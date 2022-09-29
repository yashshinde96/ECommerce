package com.app.service;

import com.app.pojos.Admin;
import com.app.pojos.Customer;

public interface LoginServiceInterface {

	Admin checkAdmin();

	void registerAdmin(Admin admin);

	Admin verifyAdmin(String email, String password);

	String registerUser(Customer con);

	Customer verifyCustomer(String email, String password);

	String getPassword(String email);

}

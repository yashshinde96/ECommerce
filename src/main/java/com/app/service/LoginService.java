package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.LoginDaoInterface;
import com.app.pojos.Admin;
import com.app.pojos.Customer;

@Service
@Transactional
public class LoginService implements LoginServiceInterface {

	@Autowired
	private LoginDaoInterface loginDao;
	@Override
	public Admin checkAdmin() {
		
		return loginDao.checkAdmin();
	}
	@Override
	public void registerAdmin(Admin admin) {
		loginDao.registerAdmin(admin);
	}
	@Override
	public Admin verifyAdmin(String email, String password) {
		return loginDao.verifyAdmin(email, password);
	}
	@Override
	public String registerUser(Customer con) {
		// TODO Auto-generated method stub
		return loginDao.registerUser(con);
	}
	@Override
	public Customer verifyCustomer(String email, String password) {
		// TODO Auto-generated method stub
		return loginDao.verifyCustomer(email, password);
	}
	@Override
	public String getPassword(String email) {
		// TODO Auto-generated method stub
		return loginDao.getPassword(email);
	}

}

package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AdminDaoInterface;
import com.app.pojos.Advertise;
import com.app.pojos.Banner;
import com.app.pojos.Orders;
import com.app.pojos.Product;

@Service
@Transactional
public class AdminService implements AdminServiceInterface {

	@Autowired
	private AdminDaoInterface adminDao;

	@Override
	public String addProduct(Product product) {
		// TODO Auto-generated method stub
		return adminDao.addProduct(product);
	}

	@Override
	public List<Banner> fetchBanners() {
		// TODO Auto-generated method stub
		return adminDao.fetchBanners();
	}

	@Override
	public String addBanner(Banner banner) {
		// TODO Auto-generated method stub
		return adminDao.addBanner(banner);
	}

	@Override
	public List<Advertise> fetchAdvertiesment() {
		// TODO Auto-generated method stub
		return adminDao.fetchAdvertiesment();
	}

	@Override
	public String publishAdvertise(Advertise add) {
		// TODO Auto-generated method stub
		return adminDao.publishAdvertise(add);
	}

	@Override
	public String toggleAdvertise(int aid) {
		// TODO Auto-generated method stub
		return adminDao.toggleAdvertise(aid);
	}

	@Override
	public String deleteAdvertise(int aid) {
		// TODO Auto-generated method stub
		return adminDao.deleteAdvertise(aid);
	}

	@Override
	public List<Advertise> fetchShowAdvertiesment() {
		// TODO Auto-generated method stub
		return adminDao.fetchShowAdvertiesment();
	}

	@Override
	public String toggleBanner(int id) {
		// TODO Auto-generated method stub
		return adminDao.toggleBanner(id);
	}

	@Override
	public String deleteBanner(int id) {
		// TODO Auto-generated method stub
		return adminDao.deleteBanner(id);
	}

	@Override
	public List<Banner> fetchShowBanners() {
		// TODO Auto-generated method stub
		return adminDao.fetchShowBanners();
	}

	@Override
	public Product fetchProductByID(int pid) {
		// TODO Auto-generated method stub
		return adminDao.fetchProductByID(pid);
	}

	@Override
	public String updateProduct(int id, String category, String name, String brand, String title, int stock,
			double price, String description, String mdate, String warrenty, String mname, String dimension,
			String color, String weight, byte[] imageFile) {
		// TODO Auto-generated method stub
		return adminDao.updateProduct(id, category, name, brand, title, stock, price, description, mdate, warrenty, mname, dimension, color, weight, imageFile);
	}

	@Override
	public List<Orders> fetchAllOrders() {
		// TODO Auto-generated method stub
		return adminDao.fetchAllOrders();
	}

	@Override
	public void toggleOrder(int oid) {
		// TODO Auto-generated method stub
		adminDao.toggleOrder(oid);
	}

	@Override
	public String removeProduct(int pid) {
		// TODO Auto-generated method stub
		return adminDao.removeProduct(pid);
	}
	
	
}

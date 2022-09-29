package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Advertise;
import com.app.pojos.Banner;
import com.app.pojos.Orders;
import com.app.pojos.Product;

@Repository
public class AdminDao implements AdminDaoInterface {

	@Autowired
	private EntityManager mgr;

	@Override
	public String addProduct(Product product) {
		mgr.persist(product);
		return "Product Saved Successfully";
	}

	@Override
	public List<Banner> fetchBanners() {

		return mgr.createQuery("select b from Banner b", Banner.class).getResultList();
	}

	@Override
	public String addBanner(Banner banner) {
		mgr.persist(banner);
		return "Banner Uploaded";
	}

	@Override
	public List<Advertise> fetchAdvertiesment() {
		return mgr.createQuery("select b from Advertise b", Advertise.class).getResultList();
	}

	@Override
	public String publishAdvertise(Advertise add) {
		mgr.persist(add);
		return "Advertiesment Uploaded";
	}

	@Override
	public String toggleAdvertise(int aid) {
		Advertise add = mgr.find(Advertise.class, aid);
		String status = add.getaStatus();
		if (status.equals("Show"))
			add.setaStatus("Hide");
		else
			add.setaStatus("Show");
		return "Status is changed";
	}

	@Override
	public String deleteAdvertise(int aid) {
		Advertise add = mgr.find(Advertise.class, aid);
		mgr.remove(add);
		return "Advertiesment is deleted";
	}

	@Override
	public List<Advertise> fetchShowAdvertiesment() {
		// TODO Auto-generated method stub
		return mgr.createQuery("select b from Advertise b where b.aStatus=:status", Advertise.class)
				.setParameter("status", "Show").getResultList();
	}

	@Override
	public String toggleBanner(int id) {
		Banner banner = mgr.find(Banner.class, id);
		String status = banner.getBannerStatus();
		if (status.equals("show"))
			banner.setBannerStatus("Hide");
		else
			banner.setBannerStatus("show");
		return "Banner Status Changed";
	}

	@Override
	public String deleteBanner(int id) {
		Banner banner = mgr.find(Banner.class, id);
		mgr.remove(banner);
		return "Banner Deleted";
	}

	@Override
	public List<Banner> fetchShowBanners() {

		return mgr.createQuery("select b from Banner b where b.bannerStatus=:status", Banner.class)
				.setParameter("status", "show").getResultList();

	}

	@Override
	public Product fetchProductByID(int pid) {
		// TODO Auto-generated method stub
		return mgr.find(Product.class, pid);
	}

	@Override
	public String updateProduct(int id, String category, String name, String brand, String title, int stock,
			double price, String description, String mdate, String warrenty, String mname, String dimension,
			String color, String weight, byte[] imageFile) {
		Product p = mgr.find(Product.class, id);
		p.setBrand(brand);
		p.setCategory(category);
		p.setColor(color);
		p.setDescription(description);
		p.setImage(imageFile);
		p.setMdate(mdate);
		p.setMname(mname);
		p.setName(name);
		p.setPrice(price);
		p.setStock(stock);
		p.setTitle(title);
		p.setWarrenty(warrenty);
		p.setWeight(weight);
		return "product details updated";
	}

	@Override
	public List<Orders> fetchAllOrders() {
		String jpql="Select o from Orders o";
		return mgr.createQuery(jpql, Orders.class).getResultList();
	}

	@Override
	public void toggleOrder(int oid) {
		Orders order=mgr.find(Orders.class, oid);
		String status=order.getStatus();
		if(status.equals("Placed")) {
			order.setStatus("Confirmed");
		}else if(status.equals("Confirmed")) {
			order.setStatus("Shipping");
		}else if(status.equals("Shipping")) {
			order.setStatus("Out For Dilivery");
		}else if(status.equals("Out For Dilivery")) {
			order.setStatus("Delivered");
		}else {
			order.setStatus("Completed");
		}
		
	}

	@Override
	public String removeProduct(int pid) {
		Product p=mgr.find(Product.class, pid);
		mgr.remove(p);
		return "Product Removed Successfully";
	}
}

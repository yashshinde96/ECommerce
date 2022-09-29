package com.app.service;

import java.util.List;

import com.app.pojos.Advertise;
import com.app.pojos.Banner;
import com.app.pojos.Orders;
import com.app.pojos.Product;

public interface AdminServiceInterface {

	String addProduct(Product product);

	List<Banner> fetchBanners();

	String addBanner(Banner banner);

	List<Advertise> fetchAdvertiesment();

	String publishAdvertise(Advertise add);

	String toggleAdvertise(int aid);

	String deleteAdvertise(int aid);

	List<Advertise> fetchShowAdvertiesment();

	String toggleBanner(int id);

	String deleteBanner(int id);

	List<Banner> fetchShowBanners();

	Product fetchProductByID(int pid);

	String updateProduct(int id, String category, String name, String brand, String title, int stock, double price,
			String description, String mdate, String warrenty, String mname, String dimension, String color,
			String weight, byte[] imageFile);

	List<Orders> fetchAllOrders();

	void toggleOrder(int oid);

	String removeProduct(int pid);

}

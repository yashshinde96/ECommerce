package com.app.pojos;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.tomcat.util.codec.binary.Base64;
@Entity
@Table(name = "products")
public class Product extends BaseEntity{

	private String category;
	private String name;
	private String brand;
	private String title;
	private int stock;
	private double price;
	@Column(length = 100000)
	private String description;
	private String mdate;
	private String warrenty;
	private String mname;
	private String dimension;
	private String color;
	private String weight;
	@Transient
	private String imgUtility;

	@Lob
	@Column(length = 10000000)
	private byte[] image;
	public Product() {
		super();
	}
	public Product(String category, String name, String brand, String title, int stock, double price,
			String description, String mdate, String warrenty, String mname, String dimension, String color,
			String weight, byte[] image) {
		super();
		this.category = category;
		this.name = name;
		this.brand = brand;
		this.title = title;
		this.stock = stock;
		this.price = price;
		this.description = description;
		this.mdate = mdate;
		this.warrenty = warrenty;
		this.mname = mname;
		this.dimension = dimension;
		this.color = color;
		this.weight = weight;
		this.image = image;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	public String getWarrenty() {
		return warrenty;
	}
	public void setWarrenty(String warrenty) {
		this.warrenty = warrenty;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public String getImgUtility() throws UnsupportedEncodingException {

	       byte[] encodeBase64 = Base64.encodeBase64(getImage());
	       String base64Encoded = new String(encodeBase64, "UTF-8");              
	       return base64Encoded;
		   }

	public void setImgUtility(String imgUtility) {
		this.imgUtility = imgUtility;
	}
	@Override
	public String toString() {
		return "Product [category=" + category + ", name=" + name + ", brand=" + brand + ", title=" + title + ", stock="
				+ stock + ", price=" + price + ", description=" + description + ", mdate=" + mdate + ", warrenty="
				+ warrenty + ", mname=" + mname + ", dimension=" + dimension + ", color=" + color + ", weight=" + weight
				+ ", image=" + Arrays.toString(image) + "]";
	}
	
	
}

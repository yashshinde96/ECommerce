package com.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Advertise;
import com.app.pojos.Banner;
import com.app.pojos.Orders;
import com.app.pojos.Product;
import com.app.service.AdminServiceInterface;
import com.app.service.CustomerServiceInterface;

@Controller
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	private AdminServiceInterface adminService;
	@Autowired
	private CustomerServiceInterface customerService;

	public AdminController() {
		System.out.println("in constr of " + getClass().getName());
	}

	@GetMapping("/Dashboard")
	public String showDashboard(HttpSession hs) {
		List<Advertise> list1 = adminService.fetchAdvertiesment();
		int count = 0;
		for (Advertise a : list1) {
			count = count + 1;
		}
		hs.setAttribute("addCount", count);

		List<Banner> list2 = adminService.fetchBanners();
		int count1 = 0;
		for (Banner a : list2) {
			count1 = count1 + 1;
		}
		hs.setAttribute("bannerCount", count1);
		List<Orders> list3 = adminService.fetchAllOrders();
		List<Orders> list4 = new ArrayList<>();
		for(Orders o:list3) {
			if(!o.getStatus().equals("Delivered")) {
				list4.add(o);
			}
		}
		int count3=0;
		for(Orders o:list4) {
			count3=count3+1;
		}
		hs.setAttribute("pocount", count3);
		
		List<Product> list5 = customerService.fetchProducts();
		int count5= 0;
		for (Product a : list5) {
			count5 = count5 + 1;
		}
		hs.setAttribute("pCount", count5);
		return "/Admin/Dashboard";
	}

	@GetMapping("/addProduct")
	public String showAddProduct() {
		return "/Admin/addProduct";
	}

	@GetMapping("/viewProduct")
	public String showViewProduct(HttpSession hs) {
		hs.setAttribute("productList", customerService.fetchProducts());
		return "/Admin/viewProduct";
	}

	@GetMapping("/banner")
	public String showBanner(HttpSession hs) {
		hs.setAttribute("bannerList", adminService.fetchBanners());
		return "/Admin/banner";
	}

	@PostMapping("/banner")
	public String saveBanner(HttpSession hs, @RequestParam String category, @RequestParam MultipartFile image,
			RedirectAttributes flashMap) throws IOException {
		byte[] imageFile = image.getBytes();
		Banner banner = new Banner(category, "show", imageFile);
		flashMap.addFlashAttribute("message", adminService.addBanner(banner));
		// hs.setAttribute("bannerList", adminService.fetchBanners());
		return "redirect:/Admin/banner";
	}

	@GetMapping("/banner_status")
	public String changeBannerStatus(Model modelMap, Banner b, @RequestParam int id, HttpSession hs,
			HttpServletRequest request, HttpServletResponse resp) {
		try {
			modelMap.addAttribute("message", adminService.toggleBanner(id));
			return "redirect:/Admin/banner";
		} catch (RuntimeException e) {
			return "/Admin/banner";
		}
	}

	@GetMapping("/banner_delete")
	public String deleteBanner(Model modelMap, @RequestParam int id, HttpSession hs, HttpServletRequest request,
			HttpServletResponse resp) {
		try {
			modelMap.addAttribute("message", adminService.deleteBanner(id));
			return "redirect:/Admin/banner";
		} catch (RuntimeException e) {
			return "/Admin/banner";
		}
	}

	@GetMapping("/advertisement")
	public String showAdvertisement(HttpSession hs) {
		hs.setAttribute("advertiesmentList", adminService.fetchAdvertiesment());
		return "/Admin/advertisement";
	}

	@GetMapping("/advertise_status")
	public String changeAdvertiseStatus(Model modelMap, @RequestParam int aid, HttpSession hs,
			HttpServletRequest request, HttpServletResponse resp) {

		try {
			modelMap.addAttribute("message", adminService.toggleAdvertise(aid));
			return "redirect:/Admin/advertisement";
		} catch (RuntimeException e) {

			return "/Admin/advertisement";
		}
	}

	@GetMapping("/advertise_delete")
	public String deleteAdvertise(Model modelMap, @RequestParam int aid, HttpSession hs, HttpServletRequest request,
			HttpServletResponse resp) {
		try {
			modelMap.addAttribute("message", adminService.deleteAdvertise(aid));
			return "redirect:/Admin/advertisement";
		} catch (RuntimeException e) {
			return "/Admin/advertisement";
		}
	}

	@PostMapping("/advertisement")
	public String saveAdvertisement(@RequestParam String category, @RequestParam MultipartFile image,
			RedirectAttributes flashMap, Model modelMap) throws IOException {
		byte[] imageFile = image.getBytes();
		Advertise add = new Advertise(category, "Show", imageFile);
		flashMap.addFlashAttribute("message", adminService.publishAdvertise(add));
		return "redirect:/Admin/advertisement";
	}

	@PostMapping("/add_product")
	public String saveProduct(@RequestParam String category, @RequestParam String name, @RequestParam String brand,
			@RequestParam String title, @RequestParam int stock, @RequestParam double price,
			@RequestParam String description, @RequestParam String mdate, @RequestParam String warrenty,
			@RequestParam String mname, @RequestParam String dimension, @RequestParam String color,
			@RequestParam String weight, @RequestParam MultipartFile image, RedirectAttributes flashMap)
			throws IOException {
		byte[] imageFile = image.getBytes();
		Product product = new Product(category, name, brand, title, stock, price, description, mdate, warrenty, mname,
				dimension, color, weight, imageFile);
		flashMap.addFlashAttribute("message", adminService.addProduct(product));
		return "redirect:/Admin/addProduct";
	}

	@GetMapping("/UpdateProduct")
	public String updateProduct(@RequestParam int pid, HttpSession hs) {
		hs.setAttribute("productDetails", adminService.fetchProductByID(pid));
		return "/Admin/UpdateProduct";

	}

	@PostMapping("/updateProduct")
	public String updateProductDetails(@RequestParam int id, @RequestParam String category, @RequestParam String name,
			@RequestParam String brand, @RequestParam String title, @RequestParam int stock, @RequestParam double price,
			@RequestParam String description, @RequestParam String mdate, @RequestParam String warrenty,
			@RequestParam String mname, @RequestParam String dimension, @RequestParam String color,
			@RequestParam String weight, @RequestParam MultipartFile image, RedirectAttributes flashMap)
			throws IOException {
		byte[] imageFile = image.getBytes();
		flashMap.addFlashAttribute("message", adminService.updateProduct(id, category, name, brand, title, stock, price,
				description, mdate, warrenty, mname, dimension, color, weight, imageFile));
		return "redirect:/Admin/viewProduct";
	}

	@GetMapping("/orderRequests")
	public String showOrderRequests(HttpSession hs) {
		hs.setAttribute("orderList", adminService.fetchAllOrders());
		return "/Admin/orderRequests";
	}

	@GetMapping("toggle_order")
	public String toogleOrder(HttpSession hs, @RequestParam int oid) {
		adminService.toggleOrder(oid);
		return "redirect:/Admin/orderRequests";
	}

	@GetMapping("/delete_product")
	public String deleteProduct(@RequestParam int pid, RedirectAttributes flashMap) {
		flashMap.addFlashAttribute("message", adminService.removeProduct(pid));
		return "redirect:/Admin/viewProduct";
	}
}

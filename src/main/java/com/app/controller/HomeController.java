package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Admin;
import com.app.pojos.Customer;
import com.app.service.AdminServiceInterface;
import com.app.service.CustomerServiceInterface;
import com.app.service.LoginServiceInterface;
import com.app.utility.GetPassword;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private LoginServiceInterface loginService;
	
	@Autowired
	private CustomerServiceInterface customerService;
	
	@Autowired
	private AdminServiceInterface adminService;

	public HomeController() {
		System.out.println("in constr of " + getClass().getName());
	}

	@GetMapping("/")
	public String shwoHome(HttpSession hs) {
		hs.setAttribute("productList", customerService.fetchProducts());
		hs.setAttribute("bannerList", adminService.fetchShowBanners());
		hs.setAttribute("advertiesmentList", adminService.fetchShowAdvertiesment());
		try {
			Admin admin = loginService.checkAdmin();
			if (admin != null) {

			} else {
				Admin admin1 = new Admin("Admin Account", "admin@gmail.com", "Admin#9860", "9860388909", "Active");
				loginService.registerAdmin(admin1);
			}
			return "/index";
		} catch (Exception e) {
			return "/index";
		}
	}
	@GetMapping("/forgetPassword")
	public String showForget() {
		
		return "/forgetPassword";
	}
	@PostMapping("/getPassword")
	public String sendPassword(@RequestParam String email,HttpSession hs,RedirectAttributes flashMap,Model modelMap) {
		String password=loginService.getPassword(email);
		if(password!=null) {
			GetPassword gp=new GetPassword();
			gp.sendEmail(email, password);
		flashMap.addFlashAttribute("message","password Sent On your Email");
		return "redirect:/login";
		}else {
			modelMap.addAttribute("message", "Provided Email is not Registerd");
			return "/forgetPassword";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession hs) {
		hs.getAttribute("userDetails");
		hs.invalidate();
		return "redirect:/";
	}
	@GetMapping("/about")
	public String showAbout() {
		return "/about";
	}

	@GetMapping("/testimonial")
	public String showTestimonial() {
		return "/testimonial";
	}

	@GetMapping("/login")
	public String showLogin() {
		return "/login";
	}

	@GetMapping("/registration")
	public String showRegistration() {
		return "/registration";
	}

	@PostMapping("/userLogin")
	public String LoginUser(@RequestParam String email, @RequestParam String password, Model modelMap,
			RedirectAttributes flashMap, HttpSession hs) {
		try {
			Admin admin = loginService.verifyAdmin(email, password);
			Customer customer=loginService.verifyCustomer(email,password);
			if (admin != null) {
				hs.setAttribute("userDetails", admin);
				return "redirect:/Admin/Dashboard";
			}else if(customer!=null) {
				hs.setAttribute("userDetails", customer);
				return "redirect:/";	
			} else {
				flashMap.addFlashAttribute("message", "Invalid Credentails");
				return "redirect:/";
			}
		} catch (Exception e) {
			flashMap.addFlashAttribute("message", "Invalid Credentails");
			return "redirect:/";
		}
	}
	@GetMapping("/register")
	public String showRegister() {
		return "/registration";
	}
	@PostMapping("/signup")
	public String signupUser(@RequestParam String password,@RequestParam  String mobile,@RequestParam  String pcode,@RequestParam  String country,@RequestParam  String zip,@RequestParam String state,
			@RequestParam String address, @RequestParam String locality, @RequestParam String email, @RequestParam String name,HttpSession hs,Model modelMap,RedirectAttributes flashMap) {
		Customer con=new Customer(password, mobile, pcode, country, zip, state, address, locality, email, name);
		hs.setAttribute("message", loginService.registerUser(con));
		return "redirect:/login";
	}
	
	@GetMapping("/productd")
	public String findProductDetails(@RequestParam int pid,RedirectAttributes flashMAp,Model modelMap,HttpSession hs) {
		hs.setAttribute("product", adminService.fetchProductByID(pid));
		return "/productd";
	}
	
	@GetMapping("/products")
	public String showProduct(HttpSession hs) {
		hs.setAttribute("productList", customerService.fetchProducts());
		hs.setAttribute("bannerList", adminService.fetchShowBanners());
		hs.setAttribute("advertiesmentList", adminService.fetchShowAdvertiesment());
		return "/products";
	}
}

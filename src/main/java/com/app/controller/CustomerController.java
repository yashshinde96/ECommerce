package com.app.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Cart;
import com.app.pojos.Customer;
import com.app.pojos.Orders;
import com.app.pojos.Payment;
import com.app.pojos.Product;
import com.app.service.AdminServiceInterface;
import com.app.service.CustomerServiceInterface;
import com.app.utility.OTPSender;
import com.app.utility.OrderConfirm;

@Controller
@RequestMapping("/Customer")
public class CustomerController {

	@Autowired
	private AdminServiceInterface adminService;

	@Autowired
	private CustomerServiceInterface customerService;

	public CustomerController() {
		System.out.println("in constr of" + getClass().getName());
	}

	@GetMapping("/buy")
	public String addProdtoCart(@RequestParam int pid, HttpSession hs, RedirectAttributes flashMap) {
		try {
			Customer cus = (Customer) hs.getAttribute("userDetails");
			Product prod = adminService.fetchProductByID(pid);
			hs.setAttribute("userDetails", cus);
			hs.setAttribute("product", prod);
			return "/Payment";

		} catch (Exception e) {
			return "";
		}
	}

	public static int generateOTP() {
		String digits = "0123456789";
		Random random_method = new Random();
		char[] otpchar = new char[5];
		String otp = "";
		for (int i = 0; i < 5; i++) {
			otpchar[i] = digits.charAt(random_method.nextInt(digits.length()));
			otp = otp + otpchar[i];
		}
		return Integer.parseInt(otp);
	}

	@PostMapping("/pay")
	public String processPay(@RequestParam String cardNo, @RequestParam String name, @RequestParam String expDate,
			@RequestParam String cvv, HttpSession hs, Model modelMap, RedirectAttributes flashMap) {
		Product prod = (Product) hs.getAttribute("product");
		Customer cus = (Customer) hs.getAttribute("userDetails");
		// String amount=""+prod.getPrice();
		Payment payment = new Payment(cardNo, name, expDate, cvv);
		hs.setAttribute("payment", payment);
		// Orders order=new Orders(prod, cus, payment,"Placed");
		// hs.setAttribute("order",order);
		int otp = CustomerController.generateOTP();
		hs.setAttribute("otp", otp);
		System.out.println("otp is " + otp);
		OTPSender op = new OTPSender();
		op.sendEmail(cus.getEmail(), otp);
		return "/verify";
	}

	@PostMapping("/verify")
	public String verifyPayment(@RequestParam int otp, HttpSession hs, Model modelMap, RedirectAttributes flashMap) {
		try {
			Payment p = (Payment) hs.getAttribute("payment");
			int otp1 = (int) hs.getAttribute("otp");
			if (otp1 != otp) {
				modelMap.addAttribute("error", "Invalid Otp");
				return "/verify";
			} else {
				// Product prod=(Product) hs.getAttribute("product");
				Customer cus = (Customer) hs.getAttribute("userDetails");
				List<Cart> list = (List<Cart>) hs.getAttribute("cart");
				for (Cart c : list) {
					Orders order = new Orders(c.getProduct(), cus, p, "Placed");
					double amount = c.getProduct().getPrice();
					// Payment p=(Payment)hs.getAttribute("payment");
					Payment payment = new Payment(p.getCardNo(), p.getName(), p.getExpDate(), p.getCvv(), "" + amount);
					// hs.setAttribute("payment", payment);
					// Orders order=new Orders(c.getProduct(), cus, p,"Placed");
					customerService.order(order, c);
					customerService.removeCart(c);
					OrderConfirm oc=new OrderConfirm();
					oc.sendEmail(cus.getEmail(), order);
					continue;
					
				}
				
				// Orders order=(Orders) hs.getAttribute("order");
				flashMap.addFlashAttribute("message", "");
				return "redirect:/Customer/myorders";
			}
		} catch (Exception e) {

			return "redirect:/Customer/myorders";
		}
	}

	@GetMapping("/myorders")
	public String showMyOrders(HttpSession hs) {
		Customer cus = (Customer) hs.getAttribute("userDetails");
		hs.setAttribute("orderList", customerService.fetMyOrders(cus));
		return "/myorders";
	}

	@GetMapping("addToCard")
	public String addToCart(@RequestParam int pid, Model modelMap, RedirectAttributes flashMap, HttpSession hs) {
		Customer cus = (Customer) hs.getAttribute("userDetails");
		flashMap.addFlashAttribute("message", customerService.addtoCart(pid, cus));
		List<Cart> list = customerService.fetchCart(cus);
		hs.setAttribute("cart", list);
		double total = 0;
		for (Cart c : list) {
			total = total + c.getProduct().getPrice();
		}
		System.out.println("total=" + total);
		hs.setAttribute("total", total);
		return "/viewCart";
	}

	@GetMapping("/viewCart")
	public String viewCart(HttpSession hs) {
		Customer cus = (Customer) hs.getAttribute("userDetails");
		List<Cart> list = customerService.fetchCart(cus);
		hs.setAttribute("cart", list);
		double total = 0;
		for (Cart c : list) {
			total = total + c.getProduct().getPrice();
		}
		System.out.println("total=" + total);
		hs.setAttribute("total", total);
		return "/viewCart";
	}

	@GetMapping("/check")
	public String checkout(HttpSession hs) {
		List<Cart> list = (List<Cart>) hs.getAttribute("cart");
		double total = (double) hs.getAttribute("total");
		Customer cus = (Customer) hs.getAttribute("userDetails");

		return "/Payment";
	}

	@GetMapping("/removeFromCart")
	public String removeCartItem(@RequestParam int pid, RedirectAttributes flashMap) {
		flashMap.addFlashAttribute("message", customerService.removeCart(pid));
		return "redirect:/Customer/viewCart";
	}
}

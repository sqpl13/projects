package com.sql.carcaresystem.controller;


import java.util.List;

import javax.validation.Valid;

import com.sql.carcaresystem.models.Booking;
import com.sql.carcaresystem.models.Branch;
import com.sql.carcaresystem.models.Order;
import com.sql.carcaresystem.models.Product;
import com.sql.carcaresystem.models.Promo;
import com.sql.carcaresystem.models.Service;
import com.sql.carcaresystem.models.Staff;
import com.sql.carcaresystem.repositories.BookingRepository;
import com.sql.carcaresystem.repositories.BranchRepository;
import com.sql.carcaresystem.repositories.ProductRepository;
import com.sql.carcaresystem.repositories.PromoRepository;
import com.sql.carcaresystem.repositories.ServiceRepository;
import com.sql.carcaresystem.repositories.StaffRepository;
import com.sql.carcaresystem.services.BookingService;
import com.sql.carcaresystem.services.OrderService;
import com.sql.carcaresystem.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class MainController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private PromoRepository promoRepository;
	@Autowired
    private StaffRepository staffRepository;
	@Autowired
    private BookingRepository bookingRepository;
    @Autowired
	private BookingService bookingService;
    @Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;

    @GetMapping(path="/")
	public String showHome(Model model) {
        model.addAttribute("products", productRepository.getFourRandomProducts());
		return "index"; 
	}

    @GetMapping(path="/products")
	public String showProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
		return "products"; 
	}

	@GetMapping("/products/{id}")
	public String showIndividualProductPage(@PathVariable ( value = "id") Integer id, Model model) {
		Product product = productService.getProductByID(id);
		model.addAttribute("product", product);
        model.addAttribute("moreProducts", productRepository.findAllExceptId(id));
		return "product-page";
	}

    @GetMapping(path="/services")
	public String showServices(Model model) {
        model.addAttribute("services", serviceRepository.sortServiceByPrice());
        return "services"; 
	}

    @GetMapping(path="/branches")
	public String showBranches(Model model) {
        model.addAttribute("branches", branchRepository.sortBranchByNameMainFirst());
        return "branches"; 
	}

    @GetMapping(path="/promos")
	public String showPromos(Model model) {
		model.addAttribute("currentPromos", promoRepository.findCurrentPromos());
        model.addAttribute("comingPromos", promoRepository.findNearPromos());
		return "promos"; 
	}

    @GetMapping("/booking")
	public String showBookingPage(Model model) {
		Booking booking = new Booking();
        model.addAttribute("branches", branchRepository.sortBranchByNameMainFirst());
		model.addAttribute("services", serviceRepository.sortServiceByName());
		model.addAttribute("currentPromos", promoRepository.findCurrentPromos());
        model.addAttribute("comingPromos", promoRepository.findNearPromos());
		model.addAttribute("booking", booking);
		return "booking";
	}

    @PostMapping("/booking")
	public String addBooking(@Valid @ModelAttribute("booking") Booking booking, BindingResult bindingResult, Model model) {
		model.addAttribute("branches", branchRepository.sortBranchByNameMainFirst());
		model.addAttribute("services", serviceRepository.sortServiceByName());
		model.addAttribute("currentPromos", promoRepository.findCurrentPromos());
        model.addAttribute("comingPromos", promoRepository.findNearPromos());
		List<Promo> current = promoRepository.findCurrentPromos();
		Integer branch =  booking.getBookingBranch();
		List<Staff> staffByBranch = staffRepository.getStaffListByBranch(branch);

		// Applying Promo To Cost
		Service s = serviceRepository.findById(booking.getServiceID()).get();
		booking.setBookingCost(s.getServicePrice());
		for (Promo p : current) {
			if(p.getPromoCode().equals(booking.getPromoCode())) {
				float initCost = s.getServicePrice();
				float discount = (float) (100 - p.getPromoModifier()) / 100;
				booking.setBookingCost(initCost * discount);
			}
		}

		//Assigning a Staff
		for (Staff staff: staffByBranch) {
			List<Booking> currentBooking = bookingRepository.getBookingsByDateTimeBranch(booking.getBookingDate(), booking.getBookingTimeSlot(), booking.getBookingBranch(), staff.getStaffID());
			if (booking.getStaffID() == null && currentBooking.isEmpty() ) {
				booking.setStaffID(staff.getStaffID());
			}
		}
			

		//Checking if Staff Was Assigned
		if (booking.getStaffID() == null) {

			//For Booking Guide
			int slots = staffByBranch.size();
			int sched1 = slots - bookingRepository.getCountByDateTimeBranch(booking.getBookingDate(), "08:00 - 10:00 AM", booking.getBookingBranch());
			int sched2 = slots - bookingRepository.getCountByDateTimeBranch(booking.getBookingDate(), "10:00 - 12:00 AM", booking.getBookingBranch());
			int sched3 = slots - bookingRepository.getCountByDateTimeBranch(booking.getBookingDate(), "01:00 - 03:00 PM", booking.getBookingBranch());
			int sched4 = slots - bookingRepository.getCountByDateTimeBranch(booking.getBookingDate(), "03:00 - 05:00 PM", booking.getBookingBranch());
			model.addAttribute("sched1", sched1);
			model.addAttribute("sched2", sched2);
			model.addAttribute("sched3", sched3);
			model.addAttribute("sched4", sched4);
			return "booking-not-available";
		}

		if (bindingResult.hasErrors()) {
			return "booking";
		} else {
			//Get branch name for summary
			Branch bookedBranch = branchRepository.findById(booking.getBookingBranch()).get();
			model.addAttribute("bName", bookedBranch.getBranchName());
			bookingService.addBooking(booking);
			return "booking-success";
		}
	}

	@GetMapping("/order")
	public String showOrderPage(Model model) {
		Order order = new Order();
        model.addAttribute("products", productRepository.findAll());
		model.addAttribute("currentPromos", promoRepository.findCurrentPromos());
        model.addAttribute("comingPromos", promoRepository.findNearPromos());
		model.addAttribute("order", order);
		return "order";
	}

	@GetMapping("/order/{id}")
	public String showSpecificOrderPage(@PathVariable ( value = "id") Integer id, Model model) {
		Order order = new Order();
        model.addAttribute("products", productRepository.findAll());
		model.addAttribute("currentPromos", promoRepository.findCurrentPromos());
        model.addAttribute("comingPromos", promoRepository.findNearPromos());
		model.addAttribute("order", order);
		Product product = productService.getProductByID(id);
		model.addAttribute("product", product);
		return "order-individual";
	}

	@PostMapping("/order")
	public String addOrder(@Valid @ModelAttribute("order") Order order, BindingResult bindingResult, Model model) {
		//Get product details
		order.setOrderDate(java.time.LocalDate.now());
		Product orderedProduct = productRepository.findById(order.getProductID()).get();
		model.addAttribute("pName", orderedProduct.getProductName());
		model.addAttribute("products", productRepository.findAll());
		model.addAttribute("currentPromos", promoRepository.findCurrentPromos());
        model.addAttribute("comingPromos", promoRepository.findNearPromos());
		List<Promo> current = promoRepository.findCurrentPromos();

		// Applying Promo To Cost
		order.setOrderCost(orderedProduct.getProductPrice());
		for (Promo p : current) {
			if(p.getPromoCode().equals(order.getPromoCode())) {
				float initCost = orderedProduct.getProductPrice();
				float discount = (float) (100 - p.getPromoModifier()) / 100;
				order.setOrderCost(initCost * discount);
			}
		}

		if (bindingResult.hasErrors()) {
			return "order";
		} else {
			orderService.addOrder(order);
			return "order-success";
		}	
	}

}
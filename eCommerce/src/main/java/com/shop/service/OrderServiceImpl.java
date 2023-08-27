package com.shop.service;

import java.time.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.exception.*;

import com.shop.model.*;
import com.shop.repository.*;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CurrentUserRepository currentUserRepositroy;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	FeedbackRepository feedbackRepository;

	@Autowired
	ProductDTORepository productDTORepository;

	@Override
	public Order placeOrder(Integer customerId, String key)
			throws LoginException, CustomerException, OrderException, CartException, AddressException {

		Customer customer = checkLogin(key, customerId);

		if (customer.getAddress() == null)
			throw new AddressException("Customer Must Have Address...");

		Cart cart = customer.getCart();

		if (cart == null || cart.getProducts().size() == 0)
			throw new CartException("Cart is Empty");

		Map<Products, Integer> map = cart.getProducts();

		Order order = new Order();
		order.setAddress(customer.getAddress());
		order.setOrderAmount(cart.getCartValue());
		order.setOrderDate(LocalDate.now());
		order.setOrderStatus("Payment Pending...");

		List<ProductDTO> orderProductList = new ArrayList<>();

		for (Map.Entry<Products, Integer> m : map.entrySet()) {

			Products existingProduct = m.getKey();
			ProductDTO newproduct = new ProductDTO();
			newproduct.setSeller_ProductId(existingProduct.getSeller_ProductId());
			newproduct.setProductDtoName(existingProduct.getProductName());
			newproduct.setQuantity(m.getValue());
			newproduct.setPrice(existingProduct.getPrice());
			newproduct.setCategory(existingProduct.getCategory());

			ProductDTO savedProduct = productDTORepository.save(newproduct);
			

			orderProductList.add(savedProduct);
		}
		order.setProductList(orderProductList);
		order.setCustomer(customer);
		cart.setCartValue(0);
		cart.setProducts(new HashMap<>());
		customer.getOrderList().add(order);

		Order savedOrder = orderRepository.save(order);

		return savedOrder;
	}

	@Override
	public Order getOrderById(Integer orderId, Integer customerId, String key)
			throws LoginException, CustomerException, OrderException {

		Customer customer = checkLogin(key, customerId);
		List<Order> orderList = customer.getOrderList();
		for (Order o : orderList) {
			if (o.getOrderId() == orderId) {
				return o;
			}
		}
		throw new OrderException("Invalid Order Id...");

	}

	@Override
	public List<Order> getAllOrder(Integer customerId, String key)
			throws LoginException, CustomerException, OrderException {
		Customer customer = checkLogin(key, customerId);

		List<Order> orderList = customer.getOrderList();

		if (orderList.size() == 0)
			throw new OrderException("No order placed By Customer yet.....");

		return orderList;
	}

	@Override
	public String cancelOrder(Integer orderId, Integer customerId, String key)
			throws LoginException, CustomerException, OrderException {

		checkLogin(key, customerId);

		Optional<Order> opt = orderRepository.findById(orderId);

		if (opt.isEmpty())
			throw new OrderException("Invalid OrderId");

		Order order = opt.get();

		if (order.getCustomer().getCustomerId() != customerId)
			throw new OrderException("Order Not present In Customer...");

		if (order.getOrderStatus().equals("Order Cancelled"))
			throw new OrderException("Order ALready Cancelled");

		if (order.getPayment() == null) {
			order.setOrderStatus("Order Cancelled");

			orderRepository.save(order);
			return "Order Cancelled Sucessfully... \nPlease Provide FeedBack On want went Wrong 😔";

		} else {

			order.getPayment().setPaymentStatus(false);
			order.setOrderStatus("Order Cancelled");
			orderRepository.save(order);
			return "Order Cancelled Sucessfully... \nYour Amount will be refunded within 4 to five working days "
					+ "\nPlease Provide FeedBack On want went Wrong 😔";

		}
	}

	@Override
	public String deleteOrder(Integer orderId, Integer customerId, String key)
			throws LoginException, CustomerException, OrderException {

		checkLogin(key, customerId);

		Optional<Order> opt = orderRepository.findById(orderId);

		if (opt.isEmpty())
			throw new OrderException("Invalid OrderId");

		Order order = opt.get();

		if (order.getCustomer().getCustomerId() != customerId)
			throw new OrderException("Order Not present In Customer...");
		deletefeedback(order);
		if (order.getPayment() == null) {

			orderRepository.delete(order);
			return "Order Deleted Sucessfully... \nPlease Provide FeedBack On want went Wrong 😔";

		} else {

			if (order.getOrderStatus().equals("Order Cancelled")) {
				orderRepository.delete(order);
				return "Order Deleted Sucessfully...";
			} else {
				throw new OrderException("Order Request is Still Active Please Cancel It first");
			}

		}
	}

	public Customer checkLogin(String key, Integer customerId) throws LoginException, CustomerException {
		Optional<Customer> opt = customerRepository.findById(customerId);
		if (opt.isEmpty())
			throw new CustomerException("No customer Found with id:- " + customerId);

		Customer customer = opt.get();
		CurrentUserSession cus = currentUserRepositroy.findByUuid(key);

		if (cus == null)
			throw new LoginException("Invalid Current Key");
		if (cus.getUserId() != customer.getCustomerId())
			throw new LoginException("Please Login first.....");

		return customer;

	}

	public void deletefeedback(Order order) {
		List<Feedback> list = feedbackRepository.findByOrder(order);

		for (Feedback f : list) {
			feedbackRepository.delete(f);
		}

	}

}
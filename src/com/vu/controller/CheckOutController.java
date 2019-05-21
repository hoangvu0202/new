package com.vu.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vu.entity.Cart;
import com.vu.entity.Customer;
import com.vu.entity.Item;
import com.vu.entity.Order;
import com.vu.entity.Orderdetail;
import com.vu.services.OrderDetailServeceImp;
import com.vu.services.OrderServiceImp;

/**
 * Servlet implementation class CheckOutController
 */
@WebServlet("/CheckOutController")
public class CheckOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckOutController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String description = request.getParameter("description");
		String address = request.getParameter("address");
		String command = request.getParameter("command");
		// cart
		HttpSession session = request.getSession();
		Cart cart1 = (Cart) session.getAttribute("cart");
		// customer login
		OrderServiceImp orderimp = new OrderServiceImp();
		OrderDetailServeceImp orderdetail = new OrderDetailServeceImp();
		switch (command) {
		case "checkout":
			long idOrder = new Date().getTime()/10000;
			//get data order
			System.out.println(idOrder+ address+ " "+description);
			orderimp.insert(new Order(idOrder, "admin", new Timestamp(new Date().getTime()),
					new Timestamp(new Date().getTime()), "aaa", address, description, cart1.total()));
			for (Map.Entry<Integer, Item> car : cart1.getCart().entrySet()) {
				//get data orderdetail
				orderdetail.addOrderDetail(new Orderdetail(idOrder, car.getValue().getProduct().getProductId(),
						car.getValue().getQuantity(), car.getValue().getProduct().getPrice(), 0));
			}
			response.sendRedirect("index.jsp");
			break;
		}
	}

}

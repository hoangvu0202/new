package com.vu.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vu.entity.Product;
import com.vu.services.ProductServiceImp;

/**
 * Servlet implementation class ViewProductController
 */
@WebServlet("/ViewProductController")
public class ViewProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewProductController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		String cateid = request.getParameter("cateid");
		String productid = request.getParameter("productid");
		String url = null;
		switch (command) {
		case "viewbycate":
			ProductServiceImp  productServiceImp =  new ProductServiceImp();
			try {
				ArrayList<Product> getList = (ArrayList<Product>)productServiceImp.getListProduct(Integer.parseInt(cateid));
				HttpSession session = request.getSession();
				session.setAttribute("getlist", getList);
				url="view/product.jsp";
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				Logger.getLogger(ViewProductController.class.getName()).log(Level.SEVERE, null, e);
			}
			
			break;
			
		case "viewproduct":
			ProductServiceImp  proImp =  new ProductServiceImp();
            try {
                Product pro=  (Product)proImp.findById(Integer.parseInt(productid));
                HttpSession session= request.getSession();
                session.setAttribute("product", pro);
                url= "view/viewproduct.jsp";
            } catch (SQLException ex) {
                Logger.getLogger(ViewProductController.class.getName()).log(Level.SEVERE, null, ex);
            }
			break;	

		default:
			break;
		}
		response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package com.vu.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vu.entity.Cart;
import com.vu.entity.Item;
import com.vu.entity.Product;
import com.vu.services.ProductServiceImp;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProductServiceImp proImp= new ProductServiceImp();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
        Cart cart2= (Cart)session.getAttribute("cart");
        String command= request.getParameter("command");
        String productid= request.getParameter("productid");
        String idcode = request.getParameter("idcode");
        cart2.setIdcode(idcode);
        int key= Integer.parseInt(productid);
        try {
            Product pro= proImp.findById(key);
            switch(command){
                case "plus" :
                    if(cart2.getCart().containsKey(key)){
                        cart2.plus(key, new Item(cart2.getCart().get(key).getQuantity(), pro));
                    }else{
                        cart2.plus(key, new Item(1, pro));
                    }
                    
                    session.setAttribute("cart", cart2);
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.setAttribute("cart", cart2);
        response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
        Cart cart2= (Cart)session.getAttribute("cart");
        String idcode = request.getParameter("idcode");
        cart2.setIdcode(idcode);
        session.setAttribute("cart", cart2);
        response.sendRedirect("view/cart.jsp");
		
	}

}

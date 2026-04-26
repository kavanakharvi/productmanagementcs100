package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.ProductDAO;
import com.model.Product;

@WebServlet("/display")
public class DisplayProductsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    ProductDAO dao = new ProductDAO();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        List<Product> list = dao.selectAllProducts();

        System.out.println("TOTAL PRODUCTS = " + list.size());

        request.setAttribute("productList", list);

        RequestDispatcher rd =
                request.getRequestDispatcher("productdisplay.jsp");

        rd.forward(request, response);
    }
}
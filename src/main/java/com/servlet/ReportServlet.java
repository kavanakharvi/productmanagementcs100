package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.ProductDAO;
import com.model.Product;

@WebServlet("/report")
public class ReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProductDAO dao;

    public void init() {
        dao = new ProductDAO();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        double price =
                Double.parseDouble(request.getParameter("price"));

        List<Product> list =
                dao.getProductsAbovePrice(price);

        request.setAttribute("reportList", list);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("report_result.jsp");

        dispatcher.forward(request, response);
    }
}
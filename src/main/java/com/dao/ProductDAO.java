package com.dao;

import java.sql.*;
import java.util.*;

import com.model.Product;

public class ProductDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/kavana";
	private String jdbcUsername = "root";
	private String jdbcPassword = "student";
    // Database Connection
	public Connection getConnection() {

	    Connection con = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        String url = "jdbc:mysql://localhost:3306/kavana";
	        String user = "root";
	        String password = "student";

	        con = DriverManager.getConnection(url, user, password);

	        System.out.println("Database Connected Successfully");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return con;
	}

    // Add Product
    public void insertProduct(Product p) {

        String sql =
                "INSERT INTO products VALUES (?, ?, ?, ?, ?)";

        try {
            Connection con = getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, p.getProductId());
            ps.setString(2, p.getProductName());
            ps.setString(3, p.getCategory());
            ps.setDouble(4, p.getPrice());
            ps.setInt(5, p.getQuantity());

            ps.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Product
    public void updateProduct(Product p) {

        String sql =
                "UPDATE products SET ProductName=?, Category=?, Price=?, Quantity=? WHERE ProductID=?";

        try {
            Connection con = getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, p.getProductName());
            ps.setString(2, p.getCategory());
            ps.setDouble(3, p.getPrice());
            ps.setInt(4, p.getQuantity());
            ps.setInt(5, p.getProductId());

            ps.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Product
    public void deleteProduct(int id) {

        String sql =
                "DELETE FROM products WHERE ProductID=?";

        try {
            Connection con = getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Display All Products
    public List<Product> selectAllProducts() {

        List<Product> list = new ArrayList<>();

        String sql = "SELECT * FROM products";

        try {
            Connection con = getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(rs.getString("ProductName"));

                Product p = new Product();

                p.setProductId(rs.getInt("ProductID"));
                p.setProductName(rs.getString("ProductName"));
                p.setCategory(rs.getString("Category"));
                p.setPrice(rs.getDouble("Price"));
                p.setQuantity(rs.getInt("Quantity"));

                list.add(p);
            }

            System.out.println("TOTAL PRODUCTS = " + list.size());

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    // Report: Products Above Given Price
    public List<Product> getProductsAbovePrice(double amount) {

        List<Product> list = new ArrayList<>();

        String sql =
                "SELECT * FROM products WHERE Price > ?";

        try {
            Connection con = getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setDouble(1, amount);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Product p = new Product(
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getString("Category"),
                        rs.getDouble("Price"),
                        rs.getInt("Quantity")
                );

                list.add(p);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
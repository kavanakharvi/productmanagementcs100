<%@ page import="java.util.*,com.model.Product" %>

<!DOCTYPE html>
<html>
<head>
    <title>Display Products</title>
</head>
<body>

<h2>All Products</h2>

<table border="1" cellpadding="10">

<tr>
    <th>Product ID</th>
    <th>Product Name</th>
    <th>Category</th>
    <th>Price</th>
    <th>Quantity</th>
</tr>

<%
List<Product> list = (List<Product>) request.getAttribute("productList");
if(list != null && !list.isEmpty()) {
    for(Product p : list) {
%>

<tr>
    <td><%= p.getProductId() %></td>
    <td><%= p.getProductName() %></td>
    <td><%= p.getCategory() %></td>
    <td><%= p.getPrice() %></td>
    <td><%= p.getQuantity() %></td>
</tr>

<%
    }
} else {
%>

<tr>
    <td colspan="5">No Products Found</td>
</tr>

<%
}
%>
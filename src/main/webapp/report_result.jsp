<%@ page import="java.util.*,com.model.Product" %>

<!DOCTYPE html>
<html>
<head>
    <title>Report Result</title>
</head>

<body>

<h2>Products Above Given Price</h2>

<table border="1">

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Category</th>
    <th>Price</th>
    <th>Quantity</th>
</tr>

<%
List<Product> list =
(List<Product>) request.getAttribute("reportList");

for(Product p : list){
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
%>

</table>

</body>
</html>
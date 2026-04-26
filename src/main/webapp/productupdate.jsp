<!DOCTYPE html>
<html>
<head>
    <title>Update Product</title>
</head>

<body>

<h2>Update Product</h2>

<form action="update" method="post">

<input type="number"
name="productId"
placeholder="Product ID"
required><br><br>

<input type="text"
name="productName"
placeholder="Product Name"
required><br><br>

<input type="text"
name="category"
placeholder="Category"
required><br><br>

<input type="number"
step="0.01"
name="price"
placeholder="Price"
required><br><br>

<input type="number"
name="quantity"
placeholder="Quantity"
required><br><br>

<button type="submit">
Update Product
</button>

</form>

</body>
</html>
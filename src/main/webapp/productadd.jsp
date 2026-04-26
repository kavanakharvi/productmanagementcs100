<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>

    <link rel="stylesheet"
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>

<body class="container mt-5">

    <h2>Add Product</h2>

    <form action="add" method="post">

        <div class="mb-3">
            <label>Product ID</label>
            <input type="number"
                   name="productId"
                   class="form-control"
                   required>
        </div>

        <div class="mb-3">
            <label>Product Name</label>
            <input type="text"
                   name="productName"
                   class="form-control"
                   required>
        </div>

        <div class="mb-3">
            <label>Category</label>
            <input type="text"
                   name="category"
                   class="form-control"
                   required>
        </div>

        <div class="mb-3">
            <label>Price</label>
            <input type="number"
                   step="0.01"
                   name="price"
                   class="form-control"
                   required>
        </div>

        <div class="mb-3">
            <label>Quantity</label>
            <input type="number"
                   name="quantity"
                   class="form-control"
                   required>
        </div>

        <button type="submit"
                class="btn btn-success">
            Add Product
        </button>

    </form>

</body>
</html>
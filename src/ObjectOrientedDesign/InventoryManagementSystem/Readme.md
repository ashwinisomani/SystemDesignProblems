## Inventory Management System

An **Inventory Management System** is essential for businesses to track stock, manage orders, and maintain accurate records. This project is a simple Java-based implementation that allows users to manage items in the inventory efficiently.

---

### How It Works

- Users can **add items** by providing details such as name, quantity, and price.
- Users can **remove items** from the inventory by specifying the item’s name or ID.
- Users can **view all items** currently in the inventory.
- After each operation, the **updated inventory status** is displayed.

---

### Project Structure

### 1. `Product.java`
Represents an item in the inventory with fields like **ID, name, category, quantity, and price**.

**Methods:**
- Getters and setters for each field.
- `toString()` method for easy display of product details.

---

### 2. `Inventory.java`
Manages a collection of products using a **HashMap**.

**Methods:**
- `addProduct(Product product)` → Adds a product to the inventory.
- `removeProduct(String productId)` → Removes a product by ID.
- `updateQuantity(String productId, int newQuantity)` → Updates the quantity of a product.
- `searchProduct(String productId)` → Returns a product by ID.
- `listProducts()` → Lists all products in the inventory.

---

### Features

- Easy to add, remove, and update products.
- Displays current inventory status after each operation.
- Modular OOP design for better code organization.  

package ObjectOrientedDesign.InventoryManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    Map<String, Product> map;

    public Inventory() {
        map = new HashMap<>();
    }

    public void addProduct(Product product) {
        map.put(product.getProductId(), product);
        System.out.println("Product added" + product.getName());
    }

    //remove product using productID
    public void removeProduct(String productId) {
        if (map.containsKey(productId)) {
            System.out.println("Product " + map.get(productId).getName());
            map.remove(productId);
        } else {
            System.out.println("Product not found");
        }
    }

    public void updateQuantity(String productId, int newQuantity) {
        if (map.containsKey(productId)) {
            map.get(productId).setQuantity(newQuantity);
            System.out.println("Update quantity of" + map.get(productId).getName());
        } else {
            System.out.println("Product not found");
        }
    }

    // Search product
    public Product searchProduct(String productId) {
        return map.get(productId);
    }

    public void listProduct() {
        for (Product p : map.values()) {
            System.out.println(p);
        }
    }
}


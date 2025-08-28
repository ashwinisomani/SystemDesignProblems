package ObjectOrientedDesign.InventoryManagementSystem;

public class InventoryManagement {
    public static void main(String[] args) {
    Inventory inventory = new Inventory();

        Product p1 = new Product("101", "Laptop", "Electronics", 10, 1200.50);
        Product p2 = new Product("102", "Chair", "Furniture", 20, 85.75);

        inventory.addProduct(p1);
        inventory.addProduct(p2);

        inventory.listProduct();

        inventory.updateQuantity("101", 5);
        System.out.println("After updating:");
        inventory.listProduct();

        inventory.removeProduct("102");
        inventory.listProduct();
    }
}

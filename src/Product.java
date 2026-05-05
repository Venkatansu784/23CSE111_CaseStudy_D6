public class Product {
    int productID;
    String name;
    String category;
    double price;
    boolean available;

    public Product(int productID, String name, String category, double price) {
        this.productID = productID;
        this.name = name;
        this.category = category;
        this.price = price;
        this.available = true;
    }

    public String getDetails() {
        return productID + " " + name + " (" + category + ") - " + price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void updateStock(boolean status) {
        available = status;
    }
}
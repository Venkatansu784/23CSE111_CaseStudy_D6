import java.util.*;

public class Order {
    int orderID;
    int customerID;
    List<Product> items;

    public Order(int orderID, int customerID, List<Product> items) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.items = new ArrayList<>(items);
    }

    public void generateBill() {
        double total = 0;
        System.out.println("\n===== BILL =====");
        for (Product p : items) {
            System.out.println(p.name + " - " + p.price);
            total += p.price;
        }
        System.out.println("----------------");
        System.out.println("Total: " + total);
    }

    public void printSummary() {
        System.out.println("Order ID: " + orderID + " Items: " + items.size());
    }
}

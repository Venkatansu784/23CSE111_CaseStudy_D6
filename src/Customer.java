import java.util.*;

public class Customer {
    int customerID;
    String username;
    String email;
    List<Order> history;

    public Customer(int id, String username, String email) {
        this.customerID = id;
        this.username = username;
        this.email = email;
        history = new ArrayList<>();
    }
    public void login() {
        System.out.println("Logged in: " + username);
    }

    public void viewOrderHistory() {
        System.out.println("\n--- ORDER HISTORY ---");
        for (Order o : history) {
            o.printSummary();
        }
    }

    public void addOrder(Order o) {
        history.add(o);
    }
}

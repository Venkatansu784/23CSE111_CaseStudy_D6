import java.io.*;

public class OrderService {
    int transactionID = 1;

    public Order processCheckout(Cart cart, Customer customer) {

        Order o = new Order(transactionID++, customer.customerID, cart.itemsList);

        double total = 0;

        try {
            FileWriter fw = new FileWriter("order_history.txt", true);

            fw.write("===== ONLINE SHOPPING SYSTEM - ORDER REPORT =====\n\n");

            fw.write("Order ID: " + o.orderID + "\n");
            fw.write("Customer ID: " + customer.customerID + "\n");
            fw.write("Customer Name: " + customer.username + "\n\n");

            fw.write("Products Purchased:\n");

            for (Product p : cart.itemsList) {
                fw.write(p.name + " (" + p.category + ") - " + p.price + "\n");
                total += p.price;
            }

            fw.write("\nTotal Amount: " + total + "\n\n");

            fw.write("Order Status: Confirmed\n");
            fw.write("Payment Status: Successful\n");

            fw.write("\n===============================================\n\n");

            fw.close();

            System.out.println("Order saved to order_history.txt");

        } catch (Exception e) {
            System.out.println("Error saving order.");
        }

        saveToHistory(customer, o);

        return o;
    }

    public void saveToHistory(Customer c, Order o) {
        c.addOrder(o);
    }
}
